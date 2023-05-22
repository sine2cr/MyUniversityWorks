package cn.sine2cr.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 思想:认为前面已经全部有序，并用插入的方式将元素插入前面相应位置的有序的元素中
 * @author Sine2cr
 * @Date 2023/5/9
 * @Mail sine2cr@163.com
 **/
public class InsertionSort {
    private int[] r;
    public int[] insertionSort(int[] list){
        if (list.length==0)return list;
        for (int i = 1; i <list.length; i++) {
            int temp=list[i];
            for (int j=i-1;j>0;j--){
                if (list[i]<list[j]){
                    list[j+1]=list[j];
                }else {
                    break;
                }
                list[j]=temp;

            }
        }
        r=list;
        return list;
    }

    @Override
    public String toString() {
        return "InsertSort{" +
                "r=" + Arrays.toString(r) +
                '}';
    }
}
