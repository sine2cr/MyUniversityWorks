package cn.sine2cr.sort;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sine2cr
 * @Date 2023/5/17
 * @Mail sine2cr@163.com
 **/
public class CountingSortTest {
    CountingSort countingSort=new CountingSort();

    @Test
    public void testCountingSort(){
//        int[] list = {9,11,-13,4.67,12,1,-10,3.3333,8,3};
        int[] list = {9,11,13,4,12,1,10,22,8,3};
        countingSort.countingSort(list);
        System.out.println(countingSort.toString());
    }

}