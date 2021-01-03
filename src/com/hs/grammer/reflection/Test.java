package com.hs.grammer.reflection;

import java.lang.reflect.Method;

class ReflectTest {
    public void sayHi(String name) {
        System.out.println("Hi " + name);
    }
}

class Reflect{

    public void reflectionTest1() {
        try {
            Class vectorClass = Class.forName("java.util.Vector");

            Method[] methods = vectorClass.getDeclaredMethods();

            /* 임의의 메서드 지정, 이름으로 확인 */
            Method method = methods[25];
            System.out.println("Class Name : " + method.getDeclaringClass());
            System.out.println("Method Name : " + method.getName());
            System.out.println("Return Type : " + method.getReturnType());

            /* Parameter Types */
            Class[] paramTypes = method.getParameterTypes();
            for(Class paramType : paramTypes) {
                System.out.println("Param Type : " + paramType);
            }

            /* Exception Types */
            Class[] exceptionTypes = method.getExceptionTypes();
            for(Class exceptionType : exceptionTypes) {
                System.out.println("Exception Type : " + exceptionType);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void reflectionTest2(){
        try {
            Class myClass = Class.forName("com.hs.grammer.reflection.ReflectTest");
            Method method = myClass.getMethod("sayHi", new Class[]{String.class});
            method.invoke(myClass.newInstance(), new Object[]{new String("ganta")});

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Test {
    public static void main(String[] args){
        new Reflect().reflectionTest1();
        new Reflect().reflectionTest2();
    }
}
