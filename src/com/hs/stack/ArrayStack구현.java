package com.hs.stack;

import java.util.Optional;

interface ArrayStack{
    void push(int data);
    Optional<Integer> pop();
    void print();
}

class ArrayStackImpl implements ArrayStack {
    private int head;
    private int size;
    private int storage;
    private int[] numArray;

    ArrayStackImpl(int stackSize){
        this.numArray = new int[stackSize];
        this.size = 0;
        this.storage = stackSize;
        this.head = -1;
    }

    @Override
    public void push(int data){
        this.head++;
        if(this.head == this.storage){
            System.out.println("스택이 꽉 찼습니다.");
            System.out.println("=================");
            this.head--;
        }else{
            System.out.println(data + " 를 push했습니다.");
            System.out.println("=================");
            numArray[this.head] = data;
            this.size++;
        }
    }

    @Override
    public Optional<Integer> pop(){
        if(this.head == -1){
            System.out.println("스택이 비었습니다.");
            System.out.println("=================");
        }else{
            System.out.println(numArray[this.head] + " 를 pop했습니다.");
            System.out.println("=================");
            this.size--;
            return Optional.of(numArray[this.head--]);
        }
        return Optional.empty();
    }

    @Override
    public void print(){
        System.out.println("스택 Print");
        System.out.println("데이터 항목");
        for (int i = 0 ; i <= this.head; i++){
            System.out.print(numArray[i] + " ");
        }
        System.out.println();
        System.out.println("스택의 현제 크기");
        System.out.println(this.size);
        System.out.println("=================");
    }
}

public class ArrayStack구현 {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStackImpl(4);

        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);

        arrayStack.print();

        arrayStack.push(5);

        arrayStack.pop();
        arrayStack.print();
        arrayStack.pop();
        arrayStack.print();
        arrayStack.pop();
        arrayStack.print();
        arrayStack.pop();
        arrayStack.print();
        arrayStack.pop();
    }
}
