package src.collection;

public class LinkedList<E> {

    private final Node<E>head=new Node<>(null);
    private int size=0;
    public static class Node<E>{
        E element;
        Node<E> next;
        public Node(E element){
            this.element=element;
        }
    }

    public void add(E element,int index){
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException("插入位置非法，合法的插入位置为：0 ~ "+size);
        Node<E> p=head;
        for (int i = 0; i < index; i++) {
            p=p.next;
        }
        Node<E> newNode = new Node<>(element);
        newNode.next=p.next;
        p.next=newNode;

        size++;
    }

    public E remove(int index){
        if (index<0||index>size){
            throw new IndexOutOfBoundsException("非法的位置");
        }
        Node<E> p=head;
        for (int i = 0; i < index; i++) {
            p=p.next;
        }
        E element=p.next.element;
        p.next=p.next.next;
        size--;
        return element;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<E> node = head.next;   //从第一个结点开始，一个一个遍历，遍历一个就拼接到字符串上去
        while (node != null) {
            builder.append(node.element).append(" ");
            node = node.next;
        }
        return builder.toString();
    }
}
