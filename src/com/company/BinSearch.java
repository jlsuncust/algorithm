package com.company;

import java.util.Arrays;

public class BinSearch {
    public static void main(String[] args) {
        System.out.println(-1 + " " + binSearch(new int[]{0,1,2,3}, -1));
        System.out.println(0 + " " + binSearch(new int[]{0,1,2,3}, 0));
        System.out.println(1 + " " + binSearch(new int[]{0,1,2,3}, 1));
        System.out.println(2 + " " + binSearch(new int[]{0,1,2,3}, 2));
        System.out.println(3 + " " + binSearch(new int[]{0,1,2,3}, 3));
        System.out.println(4 + " " + binSearch(new int[]{0,1,2,3}, 4));

        System.out.println("================");

        System.out.println(-1 + " " + leftBound(new int[]{0,0,1,1,1,2,3}, -1));
        System.out.println(0 + " " + leftBound(new int[]{0,0,1,1,1,2,3}, 0));
        System.out.println(1 + " " + leftBound(new int[]{0,0,1,1,1,2,3}, 1));
        System.out.println(2 + " " + leftBound(new int[]{0,0,1,1,1,2,3}, 2));
        System.out.println(3 + " " + leftBound(new int[]{0,0,1,1,1,2,3}, 3));
        System.out.println(4 + " " + leftBound(new int[]{0,0,1,1,1,2,3}, 4));
    }

    static int binSearch(int[] arr, int k) {
        if (arr == null || arr.length < 1) {
            return -1;
        }

        int lo = 0;
        int hi = arr.length - 1; // [  ]  0 ~ N-1
        while (lo <= hi) {  // lo > hi 就是空了
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] > k) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }

    static int leftBound(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1; // [ ]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < k) {
                left = mid + 1;
            } else if (arr[mid] == k) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }

        if(left >= arr.length || arr[left] != k) {
            return -1;
        }

        return left;
    }

    static int rightBound(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1; // [ ]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < k) {
                left = mid + 1;
            } else if (arr[mid] == k) {
                right = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if(right < 0 || arr[right] != k) {
            return -1;
        }

        return right;
    }
}
