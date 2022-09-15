package com.java.algorithm.sort.quick_sort;

public class QuickSortTest {

    public static void main(String[] args) {
        int[] arrays = {6, 3, 8, 7, 5, 1, 2, 23, 4321, 432, 3,2,34234,2134,1234,5,132423, 234, 4, 2, 4, 1, 5, 2, 5};
        QuickSort.quickSort(arrays, 0, arrays.length - 1);
        for (int i: arrays) {
            System.out.print(i + "\t");
        }
    }

}
