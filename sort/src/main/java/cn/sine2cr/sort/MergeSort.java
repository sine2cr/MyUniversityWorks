package cn.sine2cr.sort;


import java.util.Arrays;

/**
 * 归并排序
 *
 * @author Sine2cr
 * @思想 利用分治的思想将整个数组需要排序这个大问题转换为两个小数组需要排序这两个子问题
 * 然后再合并这两个数组解决原来的问题
 * @时间复杂度 线性对数级 分治使用了对数级的时间合并用了约常数级时间
 * @空间复杂度 线性级 申请了一个和原数组大小相等的数组辅助使用
 * @优化 todo
 * @Date 2023/5/9
 * @Mail sine2cr@163.com
 **/
public class MergeSort {
    private int[] r;

    public int[] MergeSort(int[] list) {
        if (list.length == 0) return list;
        sort(list, 0, list.length - 1);
        r = list;
        return r;
    }

    private void sort(int[] list, int start, int end) {
        if (start == end) return;
        int mid = (start + end) / 2;
        sort(list, start, mid);
        sort(list, mid + 1, end);
        merge(list, start, mid, end);
    }

    private void merge(int[] list, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int l = start, r = mid + 1, o = 0;
        while (l <= mid && r <= end) {
            if (list[l] <= list[r]) {
                tmp[o] = list[l];
                l++;
            } else {
                tmp[o] = list[r];
                r++;
            }
            o++;
        }
        for (int i = l; i <= mid; i++) {
            tmp[o] = list[i];
            o++;
        }
        for (int i = r; i <= end; i++) {
            tmp[o] = list[i];
            o++;
        }
        for (int i = start; i <= end; i++) {
            list[i] = tmp[i - start];
        }
    }

    // TODO: 2023/5/22 尝试不使用递归实现归并排序
    // TODO: 2023/5/22 逆序输出
    // TODO: 2023/5/22 实现改善代码
    @Override
    public String toString() {
        return "MergeSort{" +
                "r=" + Arrays.toString(r) +
                '}';
    }
}
