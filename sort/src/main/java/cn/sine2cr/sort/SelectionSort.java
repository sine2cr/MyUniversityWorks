package cn.sine2cr.sort;

import com.sun.istack.internal.Nullable;

import java.util.Arrays;

/**
 * 选择排序
 * 思想:默认前面的元素全部有序，不断向后构造有序数组
 * @author Sine2cr
 * @Date 2023/5/9
 * @Mail sine2cr@163.com
 **/
public class SelectionSort {
    private int[] r;

    public int[] selectionSort(int[] list){
        for (int i = 0; i < list.length; i++) {
            int min=i;
            for (int j = i+1; j < list.length; j++) {
                if (list[min]>list[j]) min=j;
            }
            int temp;
            temp=list[i];
            list[i]=list[min];
            list[min]=temp;
        }
        r=list;
        return list;
    }

    @Override
    public String toString() {
        return "SelectionSort{" +
                "r=" + Arrays.toString(r) +
                '}';
    }
}

