package src.collection;

public class ArrayList<E> {
    int capacity =2;
    int size =0;
    private Object[] array = new Object[capacity];

    // 线性表添加元素操作就是在所要添加的元素位置上将后面的元素都向后挪一位
    public void add(E element, int index){
        //插入位置不能超出这个底层的数组长度否则会发生数组越界
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException("插入位置非法，合法的插入位置为：0 ~ "+size);
        //当数组元素满了通过更换数组对象扩容原有数组
        if(capacity == size) {
            int newCapacity = capacity + (capacity >> 1);   //加上原来的数值右移一位
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            //更新新的数组对象并更新新的数组容量
            array = newArray;
            capacity = newCapacity;
        }
        for(int i = size; i >index ; i--) {
           array[i]=array[i-1];
        }
        array[index]=element;
        size++;
    }

    // 在所要删除的元素位置上将后面的元素依次向前移动一位覆盖
    public E remove(int index){
        if (index<0||index>size){
            throw new IndexOutOfBoundsException("非法的位置");
        }
        E e = (E) array[index];
        for (int i = index; i <size ; i++) {
            array[i]=array[i+1];
            size--;
        }
        return e;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) builder.append(array[i]).append(" ");
        return builder.toString();
    }
}
