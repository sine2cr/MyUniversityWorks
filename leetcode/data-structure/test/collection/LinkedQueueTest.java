package collection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedQueueTest {
    @Test
    void test() {
        //链表队列
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.offer(111);
        queue.offer(222);
        queue.offer(333);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}