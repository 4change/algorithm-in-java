package com.java.algorithm.sort;

public class InsertSort {

    public static void main(String[] args) {
        int[] arrays = {6, 3, 8, 7, 5, 1, 2, 23, 4321, 432, 3,2,34234,2134,1234,5,132423, 234, 4, 2, 4, 1, 5, 2, 5};
        insertSort(arrays);

        for (int i: arrays) {
            System.err.print(i + "\t");
        }
    }

    public static void insertSort(int[] arrays) {


        //临时变量
        int temp;


        //外层循环控制需要排序的趟数(从1开始因为将第0位看成了有序数据)
        for (int i = 1; i < arrays.length; i++) {

            temp = arrays[i];

            //如果前一位(已排序的数据)比当前数据要大，那么就进入循环比较[参考第二趟排序]

            int j = i - 1;

            while (j >= 0 && arrays[j] > temp) {

                //往后退一个位置，让当前数据与之前前位进行比较
                arrays[j + 1] = arrays[j];

                //不断往前，直到退出循环
                j--;

            }
            //退出了循环说明找到了合适的位置了，将当前数据插入合适的位置中
            arrays[j + 1] = temp;

        }
    }

}
