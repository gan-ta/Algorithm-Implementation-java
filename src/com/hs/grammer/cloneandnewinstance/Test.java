package com.hs.grammer.cloneandnewinstance;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Num implements Cloneable {
    int num;

    public Num(){
    }

    public Num(Integer num) {
        this.num = num;
    }

    @Override
    protected Num clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return (Num) obj;
    }
}

public class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //clone을 이용한 객체 생성
        Num n1 = new Num(1);
        Num n2 = n1.clone();
        n2.num = 2;

        System.out.println(n1.num);
        System.out.println(n2.num);
        System.out.println(n1 == n2);
        System.out.println(n1.equals(n2));

        //new instance 사용
        //기본생성자 사용
        Num n3 = new Num(3);
        Num n4 = n3.getClass().newInstance();
        System.out.println(n4.num);

        //인자 사용
        Class n5 = Num.class;
        Constructor n5c = n5.getConstructor(new Class[]{Integer.class});
        Num n6 = (Num)n5c.newInstance(6);
        System.out.println(n6.num);
    }
}
