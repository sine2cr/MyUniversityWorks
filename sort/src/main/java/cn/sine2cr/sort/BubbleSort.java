package cn.sine2cr.sort;

import java.util.Arrays;
import java.util.List;

/**
 * 冒泡排序
 * @思想 将原有数组分为两部分，默认后面部分的元素已经有序，不断向前寻找最大值继续构建有序数组
 * @时间复杂度 指数级 每一个元素的确定都遍历了整个数组
 * @空间复杂度 常数级 仅在原数组上操作无其他空间
 * @优化 在比较时再找到一个最小值放在数组前方
 * @author Sine2cr
 * @Date 2023/5/9
 * @Mail sine2cr@163.com
 **/
public class BubbleSort {
    private int[] r;
    public int[] bubbleSort(int[] list){
        if (list.length==0) return list;
        for (int i = list.length-1; i >=1; i--) {//可以改为到1号元素停止吗？ 可以，因为到达倒数第二个元素时最后一个元素已经有序
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

    // TODO: 2023/5/22 将顺序表逆序输出
    // TODO: 2023/5/22 实现优化代码
    @Override
    public String toString() {
        return "BubbleSort{" +
                "r=" + Arrays.toString(r) +
                '}';
    }
}
