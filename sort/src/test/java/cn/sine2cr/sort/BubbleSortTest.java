package cn.sine2cr.sort;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * @author Sine2cr
 * @Date 2023/5/9
 * @Mail sine2cr@163.com
 **/
public class BubbleSortTest {
    private BubbleSort bubbleSort=new BubbleSort();
    @Test
    public void testBubbleSort(){
        int[] a={-5,9,11,13,32,4,1,10,88,2,8,3,16,14};
        bubbleSort.bubbleSort(a);
        System.out.println(bubbleSort.toString());
    }
}