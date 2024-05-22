package cn.sine2cr.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 桶排序
 * 无桶数量确定方法目前有BUG
 *
 * @author Sine2cr
 * @时间复杂度
 * @空间复杂度
 * @改善
 * @Date 2023/5/17
 * @Mail sine2cr@163.com
 **/
public class BucketSort {
    private int[] r;
    private final SelectionSort selectionSort = new SelectionSort();

    // TODO: 2023/5/17 问题，未找到合适的桶数量确定方法有bug需要找到合适的桶数量确定方法
    public int[] bucketSort(int[] list) {
        int count = 100;
        List<Integer>[] tmp = new ArrayList[count];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            tmp[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < list.length; i++) {
            int index = list[i] % count;
            tmp[index].add(list[i]);
        }

        for (int i = 0; i < count; i++) {
            int[] a = new int[tmp[i].size()];

            for (int j = 0; j < tmp[i].size(); j++) {
                a[j] = tmp[i].get(j);
            }

            selectionSort.selectionSort(a);

            for (int j = 0; j < a.length; j++) {
                result.add(a[j]);
            }
        }
        for (int i = 0; i < result.size(); i++) {
            list[i] = result.get(i);
        }
        r = list;
        return r;
    }

    @Override
    public String toString() {
        return "BucketSort{" +
                "r=" + Arrays.toString(r) +
                '}';
    }
}
