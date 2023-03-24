package dataStructure;

public class LinkedNode<E> {
    public static class Node<E> {
        E item;
        Node<E> pre;
        Node<E> next;
        public Node(E e){
            this.item=e;
        }

    }

    public void headInsert(int[] a) {
        Node<Integer> head = new Node<>(null);
       // int[] a = {1,2,3,4};
        for (int i = 0; i < a.length; i++) {
            Node<Integer> newNode = new Node<>(a[i]);
            newNode.next=head;
            head=newNode;
        }
        Node<Integer> p = head;

        for (int i = 0; i < a.length ; i++) {

            System.out.println(p.item);
            p=p.next;

        }

    }
}