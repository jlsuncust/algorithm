package com.company;

import java.util.*;

public class BigSumMain {
    public static void main(String[] args) {
        String a = sum("1017", "3028");
        System.out.println(a);
    }

    static String sum(String a, String b) {
        if (a == null || b == null || a.length() == 0 || b.length() == 0) {
            return "";
        }

        int aLen = a.length();
        int bLen = b.length();
        int maxLen = Math.max(a.length(), b.length()) + 1;
        char[] res = new char[maxLen];
        Arrays.fill(res, '0');

        for (int i = 1; i < maxLen; i++) {
            int temp = (res[maxLen - i] - '0');
            if (aLen >= i) {
                temp += (a.charAt(aLen - i) - '0');
            }
            if (bLen >= i) {
                temp += (b.charAt(bLen - i) - '0');
            }

            int c = temp % 10 + '0';
            int d = temp / 10 + '0';

            res[maxLen - i] = (char)c;
            res[maxLen - i - 1] = (char)d;
        }

        if (res[0] == '0') {
            return String.valueOf(res, 1, maxLen - 1);
        } else {
            return String.valueOf(res, 0, maxLen);
        }
    }
}
