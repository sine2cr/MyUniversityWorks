package cn.sine2cr.sort;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * @author Sine2cr
 * @Date 2023/5/21
 * @Mail sine2cr@163.com
 **/
public class QuickSortTest {
    QuickSort quickSort=new QuickSort();
    @Test
    public void testQuickSort(){
        int[] list={2,1,3,4,6,5,7,9,8};
        quickSort.quickSort(list,0,8);
        System.out.println(quickSort.toString());
    }

}