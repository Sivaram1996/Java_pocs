package com.practice.poc.StringManipulation;

public class StringPalindrom {

    public static boolean isPalindrom (String text){

        char[] chars = text.toCharArray();

        String temp = "";
        for(int i= chars.length-1; i >= 0; i--){
           temp = temp + chars[i];
        }
        if(temp.equals(text)){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        boolean trueOrFalse = isPalindrom("MADAM");
        System.out.println(trueOrFalse);
    }
}
