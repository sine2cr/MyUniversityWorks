package cn.sine2cr.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 归并排序
 * @author Sine2cr
 * @Date 2023/5/9
 * @Mail sine2cr@163.com
 **/
public class MergeSort {
    private int[] r;

    public int[] MergeSort(int[] list){
        if (list.length==0) return list;
        sort(list,0,list.length-1);
        r=list;
        return r;
    }
    private void sort(int[] list,int start,int end){
        if (start==end) return;
        int mid = (start+end)/2;
        sort(list,start,mid);
        sort(list,mid+1,end);
        merge(list,start,mid,end);
    }
    private void merge(int[] list ,int start,int mid,int end){
        int[] tmp=new int[end-start+1];
        int l=start,r=mid+1,o=0;
        while (l<=mid && r<=end){
            if (list[l]<=list[r]){
                tmp[o]=list[l];
                l++;
            }else {
                tmp[o]=list[r];
                r++;
            }
            o++;
        }
        for (int i=l;i<=mid;i++){
            tmp[o]=list[i];
            o++;
        }
        for (int i=r;i<=end;i++){
            tmp[o]=list[i];
            o++;
        }
        for (int i = start; i <=end; i++) {
            list[i]= tmp[i - start];
        }
    }
    @Override
    public String toString() {
        return "MergeSort{" +
                "r=" + Arrays.toString(r) +
                '}';
    }
}
