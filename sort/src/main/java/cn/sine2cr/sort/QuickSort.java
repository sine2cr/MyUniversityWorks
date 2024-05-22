package cn.sine2cr.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author Sine2cr
 * @思想
 * @时间复杂度
 * @空间复杂度
 * @优化
 * @Date 2023/5/20
 * @Mail sine2cr@163.com
 **/
public class QuickSort {
    private int[] r;

    private int quickSortPivot(int[] list, int start, int end) {
        int pivot = start;
        int current = start + 1;//指向已排序的元素的下一个，永远指向待交换元素的
        for (int i = start + 1; i <= end; i++) {
            if (list[i] <= list[pivot]) {
                int temp = list[current];
                list[current] = list[i];
                list[i] = temp;
                current++;
            }
        }
        int temp = list[pivot];
        list[pivot] = list[current - 1];
        list[current - 1] = temp;//将基准数与已排序元素末位对换
        pivot = current - 1;
        return pivot;
    }

    public int[] quickSort(int[] list, int start, int end) {
        if (start >= end) {
            return list;
        }
        int pivot = quickSortPivot(list, start, end);
        quickSort(list, start, pivot);
        quickSort(list, pivot + 1, end);
        r = list;
        return r;
    }

    @Override
    public String toString() {
        return "QuickSort{" +
                "r=" + Arrays.toString(r) +
                '}';
    }
}
