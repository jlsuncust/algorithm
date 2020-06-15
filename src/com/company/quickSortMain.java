package com.company;

import java.util.Arrays;

public class quickSortMain {
    public static void main(String[] args) {
//        int[] a = new int[]{47, 53, 63, 20, 93};
//        System.out.println(Arrays.toString(quickSort(a)));

        int i = 0;
        boolean right = true;
        while (i++ < 10000) {
            int[] arr = new int[10];
            for (int j=0;j<10;j++){
                arr[j] = (int)(Math.random()*100);
            }
            int[] copy = Arrays.copyOf(arr, arr.length);

            quickSort(arr);
            Arrays.sort(copy);

            if(!Arrays.toString(arr).equals(Arrays.toString(copy))){
                System.out.println(Arrays.toString(arr));
                System.out.println(Arrays.toString(copy));
                right = false;
            }
        }



        if(right){
            System.out.println("right");
        }
    }

    static int[] quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        sort(arr, 0, arr.length- 1);

        return arr;
    }

    static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int[] res = partition(arr, left, right);
            sort(arr, left, res[0]-1);
            sort(arr, res[1], right);
        }
    }

    static int[] partition(int[] arr, int left, int right) {
        int base = arr[right];

        //   ,i)   <
        // [i,j)   =
        // [j,k]   ?
        // (k, >
        int i = left;
        int j = left;
        int k = right;

        while (j <= k) {
            if (arr[j] < base) {
                swap(arr, j, i);
                i++;
                j++;
            } else if (arr[j] == base) {
                j++;
            } else {
                swap(arr, j, k);
                k--;
            }
        }

        return new int[]{i, j};
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
}
