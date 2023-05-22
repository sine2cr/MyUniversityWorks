package cn.sine2cr.sort;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * @author Sine2cr
 * @Date 2023/5/21
 * @Mail sine2cr@163.com
 **/
public class ShellSortTest {
    private  ShellSort shellSort=new ShellSort();
    @Test
    public void shellsort(){
        int[] list={2,3,4,6,7,8,9,5,1};
        shellSort.shellSort(list);
        System.out.println(shellSort.toString());
    }

}