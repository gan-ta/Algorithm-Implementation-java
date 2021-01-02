package com.hs.queue;

import com.hs.list.ListNode;

import java.util.Optional;

interface ListQueue{
    void push(int data);
    Optional<Integer> pop();
    void print();
}

class ListQueueImpl implements ListQueue{

    private ListNode front;
    private ListNode rear;
    private int size;

    ListQueueImpl(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    @Override
    public void push(int data) {
        if(this.size == 0) {
            System.out.println(data + " 를 push했습니다.");
            System.out.println("=================");
            this.front = new ListNode(data);
            this.rear = this.front;
            this.size++;
        }else{
            System.out.println(data + " 를 push했습니다.");
            System.out.println("=================");
            ListNode insert = new ListNode(data);
            this.front.setFront(insert);
            this.front = insert;
            this.size++;
        }
    }

    @Override
    public Optional<Integer> pop() {
        if(this.size == 0){
            System.out.println("큐가 비어있습니다.");
            System.out.println("=================");
        }else if(this.size == 1){
            ListNode out = this.rear;
            System.out.println(out.getNum() + " 를 pop했습니다.");
            System.out.println("=================");
            this.front = null;
            this.rear = null;
            this.size--;
            return Optional.of(out.getNum());
        }else{
            ListNode out = this.rear;
            System.out.println(out.getNum() + " 를 pop했습니다.");
            System.out.println("=================");
            this.rear = this.rear.getFront();
            this.size--;
            return Optional.of(out.getNum());
        }
        return Optional.empty();
    }

    @Override
    public void print() {
        ListNode cur = this.rear;
        int count = 0;
        System.out.println("큐 Print");
        System.out.println("데이터 항목");
        while(count != this.size){
            System.out.print(cur.getNum() + " ");
            cur = cur.getFront();
            count++;
        }
        System.out.println();
        System.out.println("큐의 현제 크기");
        System.out.println(this.size);
        System.out.println("=================");
    }
}

public class ListQueue구현 {
    public static void main(String[] args) {
        ListQueue listQueue = new ListQueueImpl();

        listQueue.push(-1);
        listQueue.pop();
        listQueue.print();

        listQueue.push(1);
        listQueue.push(2);
        listQueue.push(3);

        listQueue.print();

        listQueue.push(4);

        listQueue.pop();
        listQueue.print();
        listQueue.push(5);
        listQueue.print();

        listQueue.pop();
        listQueue.push(7);
        listQueue.print();
    }
}
