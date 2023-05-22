package cn.sine2cr.sort;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Sine2cr
 * @Date 2023/5/22
 * @Mail sine2cr@163.com
 **/
public class HeapSortTest {

    private HeapSort heapSort=new HeapSort();
    @Test
    public void testHeapSort() {
        int[] list={2,3,4,5,1,7,6,9,8};
        heapSort.heapSort(list);
        System.out.println(heapSort.toString());
    }
}