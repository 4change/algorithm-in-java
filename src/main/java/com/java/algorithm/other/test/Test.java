package com.java.algorithm.other.test;

public class Test {

    public static void main(String[] args) {
        System.out.println(new Test().Unknown(new int[]{1, 3, 4, 5}, 0,2));
    }

    public int Unknown(int arr[], int i, int n) {
        if (i == n - 1) {
            return arr[i];
        } else {
            int tmp = Unknown(arr, i + 1, n);

            if (tmp < arr[i]) {
                return arr[i];
            } else {
                return tmp;
            }
        }
    }

}
