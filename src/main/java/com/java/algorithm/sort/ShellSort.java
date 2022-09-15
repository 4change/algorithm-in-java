package com.java.algorithm.sort;

public class ShellSort {

    public static void main(String[] args) {
        int[] arrays = {6, 3, 8, 7, 5, 1, 2, 23, 4321, 432, 3,2,34234,2134,1234,5,132423, 234, 4, 2, 4, 1, 5, 2, 5};
        shellSort(arrays);
        for (int i: arrays) {
            System.err.print(i + "\t");
        }
    }

    public static void shellSort(int[] arrays) {
        //增量每次都/2
        for (int step = arrays.length / 2; step > 0; step /= 2) {

            //从增量那组开始进行插入排序，直至完毕
            for (int i = step; i < arrays.length; i++) {

                int j = i;
                int temp = arrays[j];

                // j - step 就是代表与它同组隔壁的元素
                while (j - step >= 0 && arrays[j - step] > temp) {
                    arrays[j] = arrays[j - step];
                    j = j - step;
                }
                arrays[j] = temp;
            }
        }
    }

}
