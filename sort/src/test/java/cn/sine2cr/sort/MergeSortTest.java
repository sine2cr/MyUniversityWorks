package cn.sine2cr.sort;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * @author Sine2cr
 * @Date 2023/5/9
 * @Mail sine2cr@163.com
 **/
public class MergeSortTest {

    private MergeSort mergeSort=new MergeSort();
    @Test
    public void testMergeSort(){
        int[] list={101,11,13,51,7,12,1,8,10,2,17,3,16,14};
        mergeSort.MergeSort(list);
        System.out.println(mergeSort.toString());
    }

}