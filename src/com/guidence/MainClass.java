package com.guidence;

import com.guidence.pojo.Department;
import com.guidence.pojo.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class MainClass implements Cloneable{

    public static void main(String []args) throws ClassNotFoundException, CloneNotSupportedException {
//        int num[] = {1,2,3,5,6};
//        rotate(num, 3);
        distinctArray();

        Class loadClass = Class.forName("Test");
        MainClass main=  new MainClass();
        MainClass main1= (MainClass) main.clone();
    }

    public static void distinctArray(){
        int []array = {1,3,2,3,4,3,2,5,6};

       Arrays.stream(array)
                .distinct()
                .forEach(System.out::println);

       Arrays.asList(array)
               .stream()
               .distinct()
               .forEach(System.out::println);

        //System.out.println(Arrays.toString(disArray));
    }

    public static void fibonacci(){
        //1,1,2,3

        int a=0, b=1,c=0;
        for(int i=1; i<=10;i++){
            a=b;
            b=c;
            c=a+b;
            System.out.println(c);
        }
    }

    // apple mango

    public static String calculate(String str1, String str2){

       String[] charArray1 = str1.split(""); // a, p, p, l, e
       String[] charArray2 = str2.split(""); // m, a, n, g, o
        String output="";
        int i=0, j=0;

      while ( i < charArray1.length-1 && j < charArray2.length-1){
           if(charArray1[i].compareTo(charArray2[j]) >= 1){
               output=output + charArray2[j];
               charArray2[j] = "";
               j++;
           }
          if(charArray1[i].compareTo(charArray2[j]) < 1){
              output=output + charArray1[i];
              charArray1[i] = "";
              i++;
          }
       }
        return output;
    }


    public static int searchInsert(int[] nums, int target) {
        int min=0;
        int max= nums.length-1;

        while(min <= max){

            int mid = min + (max-min)/2;

            if(nums[mid] < target)
                min = mid+1;
            else if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                max = mid-1;
        }

        if(min > max) {
            return min;
        }
        return max;
    }

    public static void rotate(int[] nums, int k) {
        int size= nums.length-1;
        int []result= nums.clone();
        int count=0;

        for(int i=size-k+1; i<=size && count<k; i++){
            nums[count] = result[i];
            count++;
        }

        for(int i=k, j=0; i<result.length; i++,j++){
            nums[i] = result[j];
        }

        System.out.println(Arrays.toString(nums));
    }

    private static int[] sortArray(int []nums){
        int result[] = {};

        System.out.println(result);
        return  IntStream.of(nums)
                .map(i->i*i)
                .sorted()
                .toArray();

    }


    private static void duplicateCharsFromString() {
        String str="abcedacvvfdvf";

        String[] stringArray = str.split("");

        Map<String, Long> stringLongMap = Arrays.stream(stringArray)
                .collect(groupingBy(Function.identity(), counting()));

        stringLongMap.entrySet()
                .stream()
                .filter(e->e.getValue()>1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }

    //count characters of the word.
    private static void countCharFromString() {
        String str = "aabbbbwwweeewewercvcdse";
        String[] stringArray = str.split("");

        Map<String, Long> stringLongMap =
                Arrays.stream(stringArray)
                        .collect(groupingBy(Function.identity(), counting()));

        stringLongMap.entrySet().forEach(System.out::println);

    }

    //get list of all Departments
    private List<Department> getDepartmentList(){
        return prepareEmployeeList().stream()
                .map(Employee::getDepartment)
                .toList();
    }

    private static Map<String, List<String>> getPhoneNumbers(){
        return prepareEmployeeList().stream()
                .collect(groupingBy(Employee::getName,
                        mapping(Employee::getPhoneNumber,
                                flatMapping(Collection::stream, toList()))));
    }

    private static List<Employee> sortBasedOnAgeAndName(){
        return prepareEmployeeList().stream()
                .sorted(Comparator.comparing(Employee::getAge)
                        .thenComparing(Employee::getName))
                .collect(toList());
    }

    private static List<Employee> sortBasedOnAge() {
        return prepareEmployeeList().stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .collect(toList());
    }

        //get list of all products
    public static List<Employee>  prepareEmployeeList(){
        return List.of(
                new Employee(1, "Urmila", 23, "Pune", List.of("223345","764567"), new Department(1, "Laptop",56.78)),
                new Employee(2, "Sheetal", 25, "Pune", List.of("7872345","4578867"), new Department(2, "Bag",20.56)),
                new Employee(3, "Rohit", 33, "Pune", List.of("4352345","456567"), new Department(3, "Pen",230.56)),
                new Employee(4, "Sumit", 43, "Pune", List.of("24543345","4354567"), new Department(4, "Mouse",120.96)),
                new Employee(5, "Kshitija", 45, "Pune", List.of("23456345","234567"), new Department(5, "Speaker",2430.56)),
                new Employee(6, "Urmila", 60, "Pune", List.of("23654645","8764567"), new Department(6, "Table",2320.56))

        );
    }

    private static void findSecondLargest() {
        List<Integer> list =Arrays.asList(112,43,21,34,67,85,36,98);
        int secondLargest =0;
        int largest =0;
        for (Integer integer : list) {
            if (largest < integer) {
                secondLargest = largest;
                largest = integer;
            } else if (secondLargest < integer) {
                secondLargest = integer;
            }
        }
        System.out.println(secondLargest);
    }

    private static void reverseString() {
        String name= "urmila kadam";

        String[] nameArray = name.split("");

        IntStream.iterate(nameArray.length - 1, i -> i >= 0, i -> i - 1)
                .mapToObj(i -> nameArray[i])
                .forEach(System.out::print);
    }

    public static boolean isAnagram(String s, String t) {
        List<String> list1 = Arrays.stream(s.split("")).sorted().collect(toList());
        List<String> list2 = Arrays.stream(t.split("")).sorted().collect(toList());
        if(list1.equals(list2)) {
            return true;
        }
          return false;
    }

    public static boolean isAnagramUsingMap(String s, String t) {
        List<String> list1 = Arrays.stream(s.split("")).sorted().collect(toList());
        List<String> list2 = Arrays.stream(t.split("")).sorted().collect(toList());
        if(list1.equals(list2)) {
            return true;
        }
        return false;
    }

    public static void subString(){
        String str="urmila";
        System.out.println("All substring are:");
        for (int i = 0; i < str.length(); i++)
            for (int j = i + 1; j <= str.length(); j++)
                System.out.println(str.substring(i, j));
    }

    public static void printPermutation(String str, int first, int last){
        char []charArray= str.toCharArray();

        for(int i=0; i< charArray.length; i++){
           // swap()
        }

    }

    void swap(char x, char y)
    {
        char temp;
        temp = x;
	    x = y;
	    y = temp;
    }

}
