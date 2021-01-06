package com.hs.tree;

class TreeNode{
    private int data;
    private TreeNode right;
    private TreeNode left;

    public int getData() {
        return data;
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode(int data, TreeNode right, TreeNode left) {
        this.data = data;
        this.right = right;
        this.left = left;
    }

    public TreeNode(int data) {
        this.data = data;
    }
}

class Tree{
    private TreeNode root;

    //전위순회
    public void preOrder(){
        System.out.println("전위순회");
        searchPre(this.root);
        System.out.println("\n============================");
    }

    public void searchPre(TreeNode node){
        if(node != null) {
            System.out.print(node.getData() + " ");
            if (node.getLeft() != null) searchPre(node.getLeft());
            if (node.getRight() != null) searchPre(node.getRight());
        }

    }

    //중위순회
    public void inOrder(){
        System.out.println("중위순회");
        searchIn(this.root);
        System.out.println("\n============================");
    }

    public void searchIn(TreeNode node){
        if(node != null) {
            if (node.getLeft() != null) searchPre(node.getLeft());
            System.out.print(node.getData() + " ");
            if (node.getRight() != null) searchPre(node.getRight());
        }
    }

    //후위순회
    public void postOrder(){
        System.out.println("후위순회");
        searchPost(this.root);
        System.out.println("\n============================");
    }

    public void searchPost(TreeNode node){
        if(node != null){
            if(node.getLeft() != null) searchPost(node.getLeft());
            if(node.getRight() != null) searchPost(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

    //같은 노드가 있는지 확인
    public Boolean find(int data){
        TreeNode currentNode = this.root;

        while(currentNode != null){
            if(currentNode.getData() == data) return true;
            else if(currentNode.getData()> data) currentNode = currentNode.getLeft();
            else currentNode = currentNode.getRight();
        }
        return false;
    }

    /*
     * 해당 데이터 추가
     * 부모보다 크면 오른쪽, 작으면 왼쪽
     */
    public Boolean insert(int data){
        TreeNode insertNode = new TreeNode(data);
        TreeNode currentNode = this.root;

        if(this.find(data)) return false;

        if(currentNode == null) {
            this.root = insertNode;
            return true;
        }

        while(true){
            if(currentNode.getData() < data){
                if(currentNode.getRight() == null) {
                    currentNode.setRight(insertNode);
                    return true;
                }
                currentNode = currentNode.getRight();
            }
            else{
                if(currentNode.getLeft() == null){
                    currentNode.setLeft(insertNode);
                    return true;
                }
                currentNode = currentNode.getLeft();
            }
        }
    }
}

public class Tree구현 {
    public static void main(String[] args){
        Tree t = new Tree();
        t.insert(5);
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(6);
        t.insert(7);

        t.preOrder();
        t.inOrder();
        t.postOrder();


    }
}
