package com.hs.grammer.switch_java13;

public class switchTest {
    public static void main(String[] args){
        String day = "MONDAY";

        switch(day) {
            case "MONDAY", "TWO" -> System.out.println("aa");
            case "NOT" -> System.out.println("bb");
            default -> System.out.println("cc");
        }

        String str = "hello";

        var result = switch(str){
            case "hi":
                yield 1;
            case "hello":
                yield 2;
            default :
                yield 3;
        };

        System.out.println(str);
        System.out.println(result);

    }
}


