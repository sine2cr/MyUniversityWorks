package collection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {
    @Test
    void test() {
        //数组栈
        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(111);
        stack.push(222);
        stack.push(333);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}