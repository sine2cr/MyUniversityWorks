package collection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    @Test
    void test() {
        //链表
        LinkedList<Integer> list = new LinkedList<>();
        list.add(111,0);
        list.add(222,1);
        list.add(333,2);
        System.out.println(list.remove(1));
        System.out.println(list.toString());
    }
}