package com.java.algorithm.sort;

public class SelectSort {

    public static void main(String[] args) {
        int[] arrays = {6, 3, 8, 7, 5, 1, 2, 23, 4321, 432, 3,2,34234,2134,1234,5,132423, 234, 4, 2, 4, 1, 5, 2, 5};
        selectSort(arrays);
        for (int i: arrays) {
            System.err.print(i + "\t");
        }
    }

    public static void selectSort(int[] arrays) {
        // 外层循环控制需要排序的趟数
        for (int i = 0; i < arrays.length - 1; i++) {
            // // 记录当前趟数的最大值的角标, 新的趟数、将角标重新赋值为0
            int pos = 0;

            // 内层循环控制遍历数组的个数并得到最大数的角标
            for (int j = 0; j < arrays.length - i; j++) {
                if (arrays[j] > arrays[pos]) pos = j;
            }

            // 交换
            int temp = arrays[pos];
            arrays[pos] = arrays[arrays.length - 1 - i];
            arrays[arrays.length - 1 - i] = temp;
        }
    }

}
