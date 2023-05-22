package cn.sine2cr.sort;


import java.util.Arrays;

/**
 * 选择排序
 *
 * @author Sine2cr
 * @思想 默认前面的元素全部有序，不断向后构造有序数组
 * @时间复杂度 指数级，因为每一个元素的确定，都遍历了剩下的数组
 * @空间复杂度 常数级，因为没有再申请别的存储空间都在原数组上操作
 * @优化 在比较最小值时同时选择一个最大值放在最后
 * @Date 2023/5/9
 * @Mail sine2cr@163.com
 **/
public class SelectionSort {
    private int[] r;

    public int[] selectionSort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {//为什么到n-2就结束？ 因为到n-2时对应选择到了倒数第二个元素剩下的那个元素自然是最大的无需再比较
            int min = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[min] > list[j]) min = j;
            }
            int temp;
            temp = list[i];
            list[i] = list[min];
            list[min] = temp;
        }
        r = list;
        return list;
    }

    //todo 将顺序表递减输出
    //todo 实现优化版选择排序
    @Override
    public String toString() {
        return "SelectionSort{" +
                "r=" + Arrays.toString(r) +
                '}';
    }
}

