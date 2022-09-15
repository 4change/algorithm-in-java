package com.java.algorithm.sort.heap_sort;

public class HeapSort {

    public static void heapSort(int[] arrays) {
        // 遍历过程: 时间复杂度o(n)
        // 不断建堆，然后让数组最后一位与当前堆顶(数组第一位)进行交换即可排序
        for (int i = 0; i < arrays.length; i++) {
            // 建堆过程, 时间复杂度O(log(n)), 每次建堆就可以排除一个元素了
            maxHeapify(arrays, arrays.length - i);

            //交换
            int temp = arrays[0];
            arrays[0] = arrays[arrays.length - 1 - i];
            arrays[arrays.length - 1 - i] = temp;
        }
    }

    // 完成一次建堆, 最大值在堆的顶部(根节点), 从数组最后一个元素来进行建堆
    public static void maxHeapify(int[] arrays, int size) {
        // 从数组的尾部开始，直到第一个元素(角标为0)
        for (int i = size - 1; i >= 0; i--) {
            // 完成第一次建堆之后，我们会发现最大值会在数组的首位
            heapify(arrays, i, size);
        }
    }

    /**
     * 建堆
     *      比较当前父节点是否大于子节点，如果大于就交换，直到一趟建堆完成～
     *
     * @param arrays    堆的底层数组
     * @param currentRootPos 当前父节点位置
     * @param size  当前堆中节点总数
     */
    public static void heapify(int[] arrays, int currentRootPos, int size) {
        int left = 2 * currentRootPos + 1;     // 左子树和右子树的位置
        int right = 2 * currentRootPos + 2;
        int max = currentRootPos;              // 把当前父节点位置看成是最大的

        if (left < size && arrays[max] < arrays[left]) {  // 如果左子树比当前根元素要大，记录它的位置
            max = left;
        }
        if (right < size && arrays[max] < arrays[right]) { //　如果右子树比当前根元素要大，记录它的位置
            max = right;
        }

        // 如果最大的不是根元素位置，那么就交换
        if (max != currentRootPos) {
            int temp = arrays[max];
            arrays[max] = arrays[currentRootPos];
            arrays[currentRootPos] = temp;

            // 继续比较，直到完成一次建堆
            heapify(arrays, max, size);
        }
    }

}
