package cn.sine2cr.sort;


import org.junit.jupiter.api.Test;



/**
 * @author Sine2cr
 * @Date 2023/5/9
 * @Mail sine2cr@163.com
 **/
public class SelectionSortTest {


    private SelectionSort selectionSort=new SelectionSort();
    @Test
    public void testSelectionSort(){
        int[] a={9,11,13,4,6,5,7,12,1,10,2,8,3,16,14,15};
        selectionSort.selectionSort(a);
        System.out.println(selectionSort.toString());
    }
}