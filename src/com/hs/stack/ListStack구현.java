package com.hs.stack;

import com.hs.list.ListNode;

import java.util.Optional;

interface ListStack{
    void push(int data);
    Optional<Integer> pop();
    void print();
}

class ListStackImpl implements ListStack {
    private ListNode head;
    private int size;

    ListStackImpl(){
        this.head = null;
        this.size = 0;
    }

    @Override
    public void push(int data) {
        if(this.size == 0){
            this.head = new ListNode(data);
        }else{
            ListNode insert = new ListNode(data);
            insert.setFront(this.head);
            this.head = insert;
        }
        this.size++;
    }

    @Override
    public Optional<Integer> pop() {
        if(this.size == 0){
            System.out.println("스택이 비었습니다.");
            System.out.println("=================");
        }else{
            ListNode popNode = this.head;
            System.out.println(popNode.getNum() + " 를 pop했습니다.");
            System.out.println("=================");
            this.size--;
            this.head = popNode.getFront();
            return Optional.of(popNode.getNum());
        }
        return Optional.empty();
    }

    @Override
    public void print() {
        ListNode cur = this.head;
        System.out.println("스택 Print");
        System.out.println("데이터 항목");
        while(cur != null){
            System.out.print(cur.getNum() + " ");
            cur = cur.getFront();
        }
        System.out.println();
        System.out.println("스택의 현제 크기");
        System.out.println(this.size);
        System.out.println("=================");
    }
}

public class ListStack구현 {
    public static void main(String[] args){
        ListStack listStack = new ListStackImpl();

        listStack.push(1);
        listStack.push(2);
        listStack.push(3);
        listStack.push(4);

        listStack.print();

        listStack.pop();
        listStack.print();
        listStack.pop();
        listStack.print();
        listStack.pop();
        listStack.print();
        listStack.pop();
        listStack.print();
        listStack.pop();
        listStack.print();
    }
}
