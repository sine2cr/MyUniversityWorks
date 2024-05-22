package cn.sine2cr.sort;

import java.util.Arrays;

/**
 * 计数排序
 *
 * @author Sine2cr
 * @时间复杂度
 * @空间复杂度
 * @优化
 * @Date 2023/5/17
 * @Mail sine2cr@163.com
 **/
public class CountingSort {
    private int[] r;

    public int[] countingSort(int[] list) {
        int n1 = Arrays.stream(list).max().getAsInt();
        int[] array = new int[n1 + 1];
        for (int i = 0; i < list.length; i++) {
            array[list[i]] += 1;
        }
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            while (array[i] > 0) {
                array[i] -= 1;
                list[n] = i;
                n++;
            }
        }
        r = list;
        return list;
    }

    @Override
    public String toString() {
        return "CountingSort{" +
                "r=" + Arrays.toString(r) +
                '}';
    }
}
