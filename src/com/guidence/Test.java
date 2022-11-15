package com.guidence;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String []args){
       List<Integer> list = Arrays.asList(2,4,12,5,12,14,6,7,8,10);
        System.out.println(findMaxNumber(list));
    }

    public static int findMaxNumber(List<Integer> list){

       return list.stream()
                .mapToInt(i->i)
                .max()
                .orElse(0);
    }
}
