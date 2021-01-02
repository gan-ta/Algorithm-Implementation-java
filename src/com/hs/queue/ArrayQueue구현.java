package com.hs.queue;

import java.util.Optional;


//Circular Queue 방식으로 구현
interface ArrayQueue{
    void push(int data);
    Optional<Integer> pop();
    void print();
}

class ArrayQueueImpl implements  ArrayQueue{
    private int front;
    private int rear;
    private int size;
    private int storage;
    private int[] numArray;

    ArrayQueueImpl(int queueSize){
        this.numArray = new int[queueSize];
        this.size = 0;
        this.front = 0;
        this.rear =  0;
        this.storage = queueSize;
    }

    //size가 0일때와 1일때 잘 고려해주기
    @Override
    public void push(int data) {
        if(this.size == this .storage){
            System.out.println("큐가 꽉 찼습니다.");
            System.out.println("=================");
        }else if(this.size == 0){
            System.out.println(data + " 를 push했습니다.");
            System.out.println("=================");
            this.numArray[this.front] = data;
            this.size++;
        }else{
            System.out.println(data + " 를 push했습니다.");
            System.out.println("=================");
            this.front = (this.front+1) % this.storage;
            this.numArray[this.front] = data;
            this.size++;
        }
    }

    @Override
    public Optional<Integer> pop() {

        if(this.size == 0){
            System.out.println("큐가 비었습니다.");
            System.out.println("=================");
        }else if(this.size == 1){
            Integer out = numArray[this.rear];
            System.out.println(out + " 를 pop했습니다.");
            System.out.println("=================");
            this.front = (this.front+1) % this.storage;
            this.rear = (this.rear + 1) % this.storage;
            this.size--;
            return Optional.of(out);
        }else{
            Integer out = numArray[this.rear];
            System.out.println(out + " 를 pop했습니다.");
            System.out.println("=================");
            this.rear = (this.rear + 1) % this.storage;
            this.size--;
            return Optional.of(out);
        }
        return Optional.empty();
    }

    @Override
    public void print() {
        int cur = this.rear;
        int count = 0;
        System.out.println("큐 Print");
        System.out.println("데이터 항목");
        while(count != this.size){
            System.out.print(numArray[cur] + " ");
            cur = (cur + 1) % this.storage;
            count++;
        }
        System.out.println();
        System.out.println("큐의 현제 크기");
        System.out.println(this.size);
        System.out.println("=================");
    }
}

public class ArrayQueue구현 {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueueImpl(3);

        arrayQueue.push(-1);
        arrayQueue.pop();
        arrayQueue.print();

        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);

        arrayQueue.print();

        arrayQueue.push(4);

        arrayQueue.pop();
        arrayQueue.print();
        arrayQueue.push(5);
        arrayQueue.print();

        arrayQueue.pop();
        arrayQueue.push(7);
        arrayQueue.print();
    }
}
