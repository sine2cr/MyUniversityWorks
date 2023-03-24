package collection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {
    @Test
    void test() {
        //数组队列
        collection.ArrayQueue<Integer> queue = new collection.ArrayQueue<>();
        queue.offer(111);
        queue.offer(222);
        queue.offer(333);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}