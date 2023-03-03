package src.collection;

import java.util.NoSuchElementException;

public class ArrayStack <E>{
    int capacity =2;
    int size =0;
    private Object[] array = new Object[capacity];

    public void push(E element){
        if(capacity == size) {
            int newCapacity = capacity + (capacity >> 1);   //加上原来的数值右移一位
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            //更新新的数组对象并更新新的数组容量
            array = newArray;
            capacity = newCapacity;
        }

        array[size]=element;
        size++;
    }
    public E pop(){
        if (size==0){
            throw new NoSuchElementException("栈空了");
        }
        E e = (E) array[size-1];
        size--;
        return e;
    }
}
