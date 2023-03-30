package com.anzj.datastructure.list;

/**
 * @author anzj
 * @date 2021/7/11 8:56
 * @description 单链表
 */
public class SingleLinkedList<E> {
    private Node<E> first;
    public int size;

    public SingleLinkedList(){
    }

    public boolean isEmpty(){
        return first == null;
    }
    //头插法
    public void insertHead(E ele){
        Node<E> newElement = new Node<>(ele);
        newElement.next = first; //新元素下个元素指向原来的第一个元素
        first = newElement;//首元素指针指向新元素
        ++size;
    }

    public void deleteFirst(){
        first = first.next;
    }

    public void deleteAll(){
        while(!isEmpty()){
            deleteFirst();
        }
    }

    public E delete(E element){
        Node<E> current = first;
        Node<E> previous = first;
        while(current.element != element){
            if(current.next == null){
                return null;
            }else{
                previous = current;
                current = current.next;
            }
        }
        if(current == first){
            first = first.next;
        }else{
            previous.next = current.next;
        }
        return current.element;
    }

    public E get(E e){
        Node<E> current = first;
        while(current.element != e){
            if(current.next == null)
                return null;
            else{
                current = current.next;
            }
        }
        return current.element;
    }

    public void getAllElement(){
        Node<E> currentNode = first;
        int num = 1;
        while(currentNode != null){
            System.out.println("element"+num+":"+currentNode.element.toString());
            currentNode = currentNode.next;
            ++num;
        }
    }
    class Node<E>{
         E element;
         Node<E> next;

        public Node(E data){
            this.element = data;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<String> myList = new SingleLinkedList<String>();
        myList.insertHead("hello");
        myList.insertHead("world");

        myList.getAllElement();
        System.out.println(myList.size);
    }
}
