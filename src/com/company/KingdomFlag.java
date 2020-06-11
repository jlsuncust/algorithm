package com.company;

import java.util.Arrays;

public class KingdomFlag {

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 2, 3, 1};
        sort(null);
        sort(arr);
    }

    static void sort(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }

        int i = 0;
        int j = 0;
        int k = arr.length - 1;

        // [0,i)   1
        // [i,j)   2
        // [j,k]   ?
        // (k,N-1] 3
        while (j <= k) {
            if (arr[j] == 1) {
                swap(arr, i, j);
                i++;
                j++;
            } else if (arr[j] == 2) {
                j++;
            } else if (arr[j] == 3) {
                swap(arr, j, k);
                k--;
            } else {
                throw new RuntimeException("参数错误");
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
