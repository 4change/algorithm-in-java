package com.java.algorithm.sort;

public class RadixSort {

    /**
     * 基数排序还存在问题
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arrays = {6, 3, 8, 7, 5, 1, 2, 23, 4321, 432, 3,2,34234,2134,1234,5,132423, 234, 4, 2, 4, 1, 5, 2, 5};
        radixSort(arrays);
        for (int i: arrays) {
            System.err.print(i + "\t");
        }
    }


    /**
     * 递归，找出数组最大的值
     * @param arrays 数组
     * @param L      左边界，第一个数
     * @param R      右边界，数组的长度
     * @return
     */

    public static int findMax(int[] arrays, int L, int R) {

        //如果该数组只有一个数，那么最大的就是该数组第一个值了
        if (L == R) {
            return arrays[L];
        } else {

            int a = arrays[L];
            int b = findMax(arrays, L + 1, R);//找出整体的最大值

            if (a > b) {
                return a;
            } else {
                return b;
            }
        }
    }

    public static void radixSort(int[] arrays) {

        int max = findMax(arrays, 0, arrays.length - 1);

        //需要遍历的次数由数组最大值的位数来决定
        for (int i = 1; max / i > 0; i = i * 10) {

            int[][] buckets = new int[arrays.length][10];

            //获取每一位数字(个、十、百、千位...分配到桶子里)
            for (int j = 0; j < arrays.length; j++) {

                int num = (arrays[j] / i) % 10;

                //将其放入桶子里
                buckets[j][num] = arrays[j];
            }

            //回收桶子里的元素
            int k = 0;

            //有10个桶子
            for (int j = 0; j < 10; j++) {
                //对每个桶子里的元素进行回收
                for (int l = 0; l < arrays.length ; l++) {

                    //如果桶子里面有元素就回收(数据初始化会为0)
                    if (buckets[l][j] != 0) {
                        arrays[k++] = buckets[l][j];

                    }

                }

            }

        }
    }

}
