package com.guidence;

import com.guidence.pojo.Department;
import com.guidence.pojo.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class MainClass {

    public static void main(String []args){
        System.out.println(sortBasedOnAge());

    }

    private static void findSecondLargest() {
        List<Integer> list =Arrays.asList(112,43,21,34,67,85,36,98);
        int secondLargest =0;
        int largest =0;
        for (int i = 0; i < list.size(); i++) {
            if (largest < list.get(i)) {
                secondLargest = largest;
                largest = list.get(i);
            }
           else if(secondLargest < list.get(i)){
                secondLargest = list.get(i);
            }
        }
        System.out.println(secondLargest);
    }

    private static void duplicateWordsFromString() {
        String str="abcedacvvfdvf";

        String[] stringArray = str.split("");

        Map<String, Long> stringLongMap = Arrays.stream(stringArray)
                .collect(groupingBy(Function.identity(), counting()));

        stringLongMap.entrySet().stream().filter(e->e.getValue()>1).map(e->e.getKey()).forEach(System.out::println);
    }

    private static void countWordsFromString() {
        String str = "aabbbbwwweeewewercvcdse";
        String[] stringArray = str.split("");

        Map<String, Long> stringLongMap =
                Arrays.stream(stringArray)
                        .collect(groupingBy(Function.identity(), counting()));

        stringLongMap.entrySet().forEach(System.out::println);

    }

    private static void reverseString() {
        String name= "urmila kadam";

        String[] nameArray = name.split("");

        for (int i=nameArray.length-1; i>=0; i--) {
            System.out.print(nameArray[i]);
        }
    }

    //get list of all Departments
    private List<Department> getDepartmentList(){
        return prepareEmployeeList().stream().map(Employee::getDepartment).toList();
    }

    private static List<Employee> sortBasedOnAge(){
        return prepareEmployeeList().stream()
                .sorted(Comparator.comparing(Employee::getAge).thenComparing(Employee::getName))
                .collect(toList());
    }

    //get list of all products
    public static List<Employee>  prepareEmployeeList(){
        return List.of(
                new Employee(1, "Urmila", 23, "Pune", List.of("223345","764567") ,new Department(1, "Laptop",56.78)),
                new Employee(2, "Sheetal", 25, "Pune", List.of("7872345","4578867") ,new Department(2, "Bag",20.56)),
                new Employee(3, "Rohit", 33, "Pune", List.of("4352345","456567") ,new Department(3, "Pen",230.56)),
                new Employee(4, "Sumit", 43, "Pune", List.of("24543345","4354567") ,new Department(4, "Mouse",120.96)),
                new Employee(5, "Kshitija", 45, "Pune", List.of("23456345","234567") ,new Department(5, "Speaker",2430.56)),
                new Employee(6, "Urmila", 60, "Pune", List.of("23654645","8764567") ,new Department(6, "Table",2320.56))

        );
    }

}
