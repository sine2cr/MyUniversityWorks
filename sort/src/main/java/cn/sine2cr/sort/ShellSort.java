package cn.sine2cr.sort;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * @author Sine2cr
 * @思想
 * @时间复杂度
 * @空间复杂度
 * @优化
 * @Date 2023/5/21
 * @Mail sine2cr@163.com
 **/
public class ShellSort {
    private int[] r;

    public int[] shellSort(int[] list) {
        int n = list.length;
        int gap = n / 2;
        while (gap > 0) {
            for (int i = 0; i < n; i += gap) {
                int a = list[i];
                int j = i;
                //插入排序，一直比较前面的数直到找到合适的元素位置插入
                while (j >= gap) {
                    if (a < list[j - gap]) {
                        list[j] = list[j - gap];
                    } else {
                        break;
                    }
                    j -= gap;
                }
                list[j] = a;
            }
            gap = gap / 2;
        }
        r = list;
        return r;
    }

    // TODO: 2023/5/24 逆序输出
    @Override
    public String toString() {
        return "ShellSort{" +
                "r=" + Arrays.toString(r) +
                '}';
    }
}
