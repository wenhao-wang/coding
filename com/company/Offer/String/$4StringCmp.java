package com.company.Offer.String;/*
 * @description
 * @author : wenhao
 * @create : 2018/12/8 下午9:59
 */

public class $4StringCmp {
    public static void main(String[] args){
        String ch1 = "hello world";
        String ch2 = "hello world";
        String ch3 = new String("hello world");
        if(ch1 == ch2){
            System.out.println("ch1 == ch2");
        }else {
            System.out.println("ch1 != ch2");
        }

        if(ch1.equals(ch2)){
            System.out.println("ch1.equals( ch2)");
        }else{
            System.out.println("!ch1.equals(ch2)");
        }
        if(ch1 == ch3){
            System.out.println("ch1 == ch3");
        }else {
            System.out.println("ch1 != ch3");
        }

        if(ch1.equals(ch3)){
            System.out.println("ch1.equals( ch3)");
        }else{
            System.out.println("!ch1.equals(ch3)");
        }

    }
}
