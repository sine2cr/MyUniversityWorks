package src.collection;

import java.util.NoSuchElementException;

public class LinkedStack <E>{
    private final Node<E> head = new Node<>(null);

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }
    public void push(E element){
        Node<E> node = new Node<>(element);
        node.next=head.next;
        head.next=node;
    }
    public E pop(){
        if (head.next==null){
            throw new NoSuchElementException("栈已经空了");
        }
        E e= head.next.element;
        head.next=head.next.next;
        return e;
    }
}
