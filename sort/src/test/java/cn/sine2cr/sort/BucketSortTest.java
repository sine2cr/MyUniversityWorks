package cn.sine2cr.sort;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * @author Sine2cr
 * @Date 2023/5/17
 * @Mail sine2cr@163.com
 **/
public class BucketSortTest {
    BucketSort bucketSort=new BucketSort();
    @Test
    public void testBucketSort(){
        int[] list = {2,3,4,1,5,7,6,8,9,33,44,54,43,32,67,45,77,744,567,345};
        bucketSort.bucketSort(list);
        System.out.println(bucketSort.toString());
    }
}