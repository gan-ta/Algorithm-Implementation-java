package com.hs.grammer.inheritance;

import javax.security.auth.login.AccountNotFoundException;

abstract class Animal{
    public abstract void eat(String food);
}

class Dog extends Animal{
    String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void eat(String food) {
        System.out.println("eat "+ food);
    }
}

class GrandParent{
    String name;

    private Object printName(){
        System.out.println("grandParent name: " + this.name);
        return null;
    }
}

class Parent extends GrandParent{
    String name;

    public Parent(String name){
        this.name = name;
        System.out.println("parent Constructor");
    }

    Parent printName(){
        System.out.println("parent name: " + this.name);
        return null;
    }
}

class Child extends Parent{
    String name;

    public Child(String name) {
        super("parent - " + name);
        this.name = name;
        System.out.println("child Constructor");
    }

    public Child printName(){
        System.out.println("child name: " + this.name);
        return null;
    }
}

public class Test {
    public static void main(String[] args){
        Parent parent = new Child("child1");
        Child child = new Child("child2");
        System.out.println(parent.name);//필드는 해당 타입을 기준으로 위에서 아래로 탐색
        System.out.println(child.name);

        parent.printName();//동적바인딩
        child.printName();

        Animal dog = new Dog("dog");
        dog.eat("apple");
    }
}
