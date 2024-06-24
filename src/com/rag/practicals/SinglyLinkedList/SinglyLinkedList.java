package com.rag.practicals.SinglyLinkedList;

public class SinglyLinkedList<E> {
    public static class Node<E>{
        private E elementOfNode;
        private Node<E> nextNode;

        public Node(E e, Node<E> nextNode){
            this.elementOfNode = e;
            this.nextNode = nextNode;
        }
        public E getElementOfNode(){
            return elementOfNode;
        }
        public Node<E> getNextNode(){
            return nextNode;
        }
        public void setNextNode(Node<E> node){
            this.nextNode = node;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    public SinglyLinkedList(){

    }

    public boolean isEmpty(){
        return size==0;
    }

    public E first(){
        if(isEmpty())return null;
        return head.getElementOfNode();
    }
    public E last(){
        if(isEmpty())return null;
        return tail.getElementOfNode();
    }
    public void addFirst(E e){
        head = new Node<>(e, head);
        if(size ==0){
            tail = head;
        }
        size++;
    }
    public void addLast(E e){

        Node<E> newestNode = new Node<>(e,null);

        if(isEmpty()){
            head = newestNode;
        }else{
            tail.setNextNode(newestNode);
        }
        tail = newestNode;
        size++;
    }

    public E removeFirst(){
        if(isEmpty()) return null;
        E answer = head.getElementOfNode();
        head = head.getNextNode();
        size--;
        if(isEmpty()){
            tail = null;
        }
        return answer;
    }

}
