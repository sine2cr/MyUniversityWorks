package cn.sine2cr.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 基数排序
 *
 * @author Sine2cr
 * @时间复杂度
 * @空间复杂度
 * @改善
 * @Date 2023/5/17
 * @Mail sine2cr@163.com
 **/
public class RadixSort {
    private int[] r;

    public int[] radixSort(int[] list) {
        int base = 1;
        int maxValue = Arrays.stream(list).max().getAsInt();
        while (base < maxValue) {
            ArrayList<Integer>[] bucket = new ArrayList[10];
            for (int i = 0; i < 10; i++) {
                bucket[i] = new ArrayList<>();
            }
            for (int i = 0; i < list.length; i++) {
                int index = list[i] / base % 10;
                bucket[index].add(list[i]);
            }
            int o = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < bucket[i].size(); j++) {
                    list[o] = bucket[i].get(j);
                    o++;
                }
            }

            base *= 10;
        }

        r = list;
        return list;
    }


    @Override
    public String toString() {
        return "RadixSort{" +
                "r=" + Arrays.toString(r) +
                '}';
    }
}
