package cn.sine2cr.sort;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author Sine2cr
 * @Date 2023/5/22
 * @Mail sine2cr@163.com
 **/
public class HeapSort {
    private int[] r;

    private void maxHeapify(int[] heap, int start, int end) {
        int son = start * 2;
        while (son <= end) {
            if (son + 1 <= end && heap[son + 1] > heap[son]) {
                son += 1;
            }
            if (heap[son] > heap[start]) {
                int temp = heap[start];
                heap[start] = heap[son];
                heap[son] = temp;
                start = son;
                son *= 2;
            } else {
                break;
            }
        }
    }

    public int[] heapSort(int[] list) {
        int[] heap = new int[list.length + 1];
        System.arraycopy(list, 0, heap, 1, list.length);
        int root = 1;
        int l=heap.length;
        for (int i = l/2; i >root-1 ; i--) {
            maxHeapify(heap,i,l-1);
        }
        for (int i = l-1; i >root ; i--) {
            int temp=heap[i];
            heap[i]=heap[root];
            heap[root]=temp;
            maxHeapify(heap,root,i-1);
        }
        System.arraycopy(heap,1,list,0,heap.length-1);
        r=list;
        return r;


    }

    @Override
    public String toString() {
        return "HeapSort{" +
                "r=" + Arrays.toString(r) +
                '}';
    }
}
