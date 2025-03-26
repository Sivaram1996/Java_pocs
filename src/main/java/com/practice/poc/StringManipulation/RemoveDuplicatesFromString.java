package com.practice.poc.StringManipulation;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromString {

    public static String removeDuplicates(String text){
        Set<String> set = new HashSet<>();
        for(char c: text.toCharArray()){
            set.add(String.valueOf(c));
        }
        StringBuilder builder = new StringBuilder();
        set.forEach(builder::append);
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("ABBCCC"));
    }
}
