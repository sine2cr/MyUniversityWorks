package cn.sine2cr.sort;

import java.util.Arrays;

/**
 * 插入排序
 * @思想 将数组分为两部分，在后方无序数组不断向有序数组前方遍历直到找到相应位置插入
 * @时间复杂度 指数级 每个元素也需遍历整个数组
 * @空间复杂度 常数级 无其他空间
 * @优化 设置一个增量，使得向前查询的次数减少
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

    // TODO: 2023/5/22 实现优化 
    // TODO: 2023/5/22 实现递减输出
    @Override
    public String toString() {
        return "InsertSort{" +
                "r=" + Arrays.toString(r) +
                '}';
    }
}
