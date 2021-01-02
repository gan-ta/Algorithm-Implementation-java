package com.hs.list;

public class ListNode {
    private int num;
    private ListNode front = null;

    public ListNode(int num) {
        this.num = num;
    }

    public void setFront(ListNode front) {
        this.front = front;
    }

    public int getNum() {
        return num;
    }

    public ListNode getFront() {
        return front;
    }
}

