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
        int[] list = {1, 2, 4, 5, 6, 7, 6, 5, 4, 3, 2,111111,0};
        countingSort.countingSort(list);
        System.out.println(countingSort.toString());
    }

}