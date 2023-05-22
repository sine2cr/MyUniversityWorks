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
        int[] list={2,1,3,5,4,6,8,7};
        mergeSort.MergeSort(list);
        System.out.println(mergeSort.toString());
    }

}