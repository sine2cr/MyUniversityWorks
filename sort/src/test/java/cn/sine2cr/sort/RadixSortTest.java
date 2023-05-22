package cn.sine2cr.sort;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * @author Sine2cr
 * @Date 2023/5/17
 * @Mail sine2cr@163.com
 **/
public class RadixSortTest {
    private RadixSort radixSort=new RadixSort();

    @Test
    public void testRadixSort(){
        int[] list = {1, 2, 44, 5, 6,88};
        radixSort.radixSort(list);
        System.out.println(radixSort.toString());
    }
}