package cn.sine2cr.sort;

import java.util.Arrays;
import java.util.List;

/**
 * 冒泡排序
 * 思想:默认最后的元素已经有序，不断向前寻找最大值构建有序数组
 * @author Sine2cr
 * @Date 2023/5/9
 * @Mail sine2cr@163.com
 **/
public class BubbleSort {
    private int[] r;
    public int[] bubbleSort(int[] list){
        if (list.length==0) return list;
        for (int i = list.length-1; i >=0; i--) {
            for (int j = 0; j < i; j++) {
                if (list[j]>list[i]){
                    int temp;
                    temp=list[i];
                    list[i]=list[j];
                    list[j]=temp;
                }
            }
        }
        r=list;

        return list;
    }

    @Override
    public String toString() {
        return "BubbleSort{" +
                "r=" + Arrays.toString(r) +
                '}';
    }
}
