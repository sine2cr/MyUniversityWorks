package collection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {
    @Test
    void test() {
        //链表栈
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(111);
        stack.push(222);
        stack.push(333);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}