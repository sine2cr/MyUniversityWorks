package collection;

import java.util.NoSuchElementException;

public class ArrayQueue <E>{
    int capacity =2;
    int size =0;
    private Object[] array = new Object[capacity];
    public void offer(E element){
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
    public E poll(){
        if (size==0){
            throw new NoSuchElementException("栈空了");
        }
        E e = (E) array[0];
        for(int i = 1; i <size ; i++) {
           array[i-1]=array[i];
        }
        size--;
        return e;
    }
}
