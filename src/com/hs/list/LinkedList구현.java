package com.hs.list;

import java.util.Optional;

interface LinkedList{
    Optional<ListNode> add(ListNode head, ListNode nodeToAdd, int position);
    Optional<ListNode> remove(ListNode head, int positionToRemove);
    boolean contains(ListNode head, ListNode nodeToCheck);
    void print();
    ListNode getHead();
}

class LinkedListImpl implements LinkedList{
    private ListNode head = null;
    private int size = 0;

    public ListNode getHead(){
        return this.head;
    }

    public int getSize(){
        return this.size;
    }

    @Override
    public Optional<ListNode> add(ListNode head, ListNode nodeToAdd, int position){
        if(size+1 < position || position <= 0){
            System.out.println("잘못된 위치입니다.");
            return Optional.empty();
        }

        if(position == 1){
            this.head = nodeToAdd;
        }else{
            ListNode cur = this.head;
            int count = 0;

            while(count != position-2){
                count++;
                cur = this.head.getFront();
            }

            nodeToAdd.setFront(cur.getFront());
            cur.setFront(nodeToAdd);
        }
        this.size++;
        return Optional.of(nodeToAdd);
    }

    @Override
    public Optional<ListNode> remove(ListNode head, int positionToRemove) {
        ListNode removeNode = null;

        if(size < positionToRemove || positionToRemove <= 0){
            System.out.println("잘못된 위치입니다.");
            return Optional.empty();
        }

        if(positionToRemove == 1){
            removeNode = this.head;
            this.head = this.head.getFront();
        }else{
            ListNode cur = this.head;
            int count = 0;

            while(count == positionToRemove-2){
                count++;
                cur = this.head.getFront();
            }
            removeNode = cur.getFront();
            cur.setFront(removeNode.getFront());
        }
        this.size--;
        return Optional.of(removeNode);
    }

    @Override
    public boolean contains(ListNode head, ListNode nodeToCheck) {
        boolean check = false;
        ListNode cur = head;
        while(cur != null){
            if(cur.getNum() == nodeToCheck.getNum()){
                check = true;
                break;
            }
            cur = cur.getFront();
        }
        return check;
    }

    @Override
    public void print() {
        System.out.println("현재 노드의 목록");
        ListNode cur = this.head;
        while(cur != null){
            System.out.print(cur.getNum() + " ");
            cur = cur.getFront();
        }
        System.out.println();
        System.out.println("현재 노드의 크기");
        System.out.println(this.getSize());
        System.out.println("======================");
    }
}

public class LinkedList구현 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedListImpl();
        linkedList.print();
        linkedList.add(linkedList.getHead(),new ListNode(3),1);
        linkedList.print();
        linkedList.add(linkedList.getHead(),new ListNode(5),2);
        linkedList.print();
        linkedList.add(linkedList.getHead(),new ListNode(7),2);
        linkedList.print();
        linkedList.remove(linkedList.getHead(),1);
        linkedList.print();
        linkedList.remove(linkedList.getHead(),1);
        linkedList.print();
        linkedList.add(linkedList.getHead(),new ListNode(3),2);
        linkedList.print();
        linkedList.add(linkedList.getHead(),new ListNode(5),3);
        linkedList.print();
        linkedList.add(linkedList.getHead(),new ListNode(7),4);
        linkedList.print();
        System.out.println(linkedList.contains(linkedList.getHead(),new ListNode(7)));
        System.out.println(linkedList.contains(linkedList.getHead(),new ListNode(9)));

        System.out.println("예외 확인");
        linkedList.add(linkedList.getHead(),new ListNode(7),6);
        linkedList.add(linkedList.getHead(),new ListNode(7),-1);
        linkedList.remove(linkedList.getHead(),5);
        linkedList.remove(linkedList.getHead(),0);
    }
}
