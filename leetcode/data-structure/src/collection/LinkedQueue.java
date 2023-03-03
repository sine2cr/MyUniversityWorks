package src.collection;

import java.util.NoSuchElementException;

public class LinkedQueue <E>{
    private final Node<E> head = new Node<>(null);
    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }
    public void offer(E element){
        Node<E> last = head;
        while (last.next!=null){
            last=last.next;
        }
        last.next=new Node<>(element);

    }
    public E poll(){
        if(head.next == null)
            throw new NoSuchElementException("队列为空");
        E e = head.next.element;
        head.next=head.next.next;
        return e;
    }
}
