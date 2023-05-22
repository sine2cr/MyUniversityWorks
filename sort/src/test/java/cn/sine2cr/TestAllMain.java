package cn.sine2cr;

import cn.sine2cr.sort.*;

/**
 * @author Sine2cr
 * @Date 2023/5/22
 * @Mail sine2cr@163.com
 **/
public class TestAllMain {

    private TestAllMain(){

    }

    public static void main(String[] args) {
        BubbleSortTest bubbleSortTest = new BubbleSortTest();
        BucketSortTest bucketSortTest = new BucketSortTest();
        CountingSortTest countingSortTest = new CountingSortTest();
        InsertionSortTest insertionSortTest = new InsertionSortTest();
        MergeSortTest mergeSortTest = new MergeSortTest();
        QuickSortTest quickSortTest = new QuickSortTest();
        RadixSortTest radixSortTest = new RadixSortTest();
        SelectionSortTest selectionSortTest = new SelectionSortTest();
        ShellSortTest shellSortTest = new ShellSortTest();

        System.out.println("#=========感谢B站英雄哥的优质视频分享========");
        bubbleSortTest.testBubbleSort();
        bucketSortTest.testBucketSort();
        countingSortTest.testCountingSort();
        insertionSortTest.testInsertionSort();
        mergeSortTest.testMergeSort();
        quickSortTest.testQuickSort();
        radixSortTest.testRadixSort();
        selectionSortTest.testSelectionSort();
        shellSortTest.shellsort();

    }
}
