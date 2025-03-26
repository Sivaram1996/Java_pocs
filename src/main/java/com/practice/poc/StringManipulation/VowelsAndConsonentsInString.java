package com.practice.poc.StringManipulation;

import java.util.HashSet;
import java.util.Set;

public class VowelsAndConsonentsInString {

    public static void countVowelsAndConsonants(String text){
        int vowels = 0;
        int consonants = 0;
        Set<String> vowelsSet = new HashSet<>();
        vowelsSet.add("a");
        vowelsSet.add("e");
        vowelsSet.add("i");
        vowelsSet.add("o");
        vowelsSet.add("u");
        for(char chars : text.toLowerCase().toCharArray()){
            if(vowelsSet.contains(String.valueOf(chars))){
                vowels++;
            }else{
                consonants++;
            }
        }

        System.out.println("Vowels: "+vowels +" Consonants: "+consonants);
    }

    public static void main(String[] args) {
        countVowelsAndConsonants("ABCDAEI");
    }




}
