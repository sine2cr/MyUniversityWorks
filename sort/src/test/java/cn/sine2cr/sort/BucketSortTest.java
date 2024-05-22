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
        int[] list = {1011,23211,124243,511,724332,-1124234};
        bucketSort.bucketSort(list);
        System.out.println(bucketSort.toString());
    }
}