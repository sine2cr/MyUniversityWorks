package cn.sine2cr.sort;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * @author Sine2cr
 * @Date 2023/5/9
 * @Mail sine2cr@163.com
 **/
public class InsertionSortTest {
    private InsertionSort insertionSort=new InsertionSort();
    @Test
    public void testInsertionSort(){
        int[] a={1,3,2,5,4,7,6,9,8};
        insertionSort.insertionSort(a);
        System.out.println(insertionSort.toString());
    }

}