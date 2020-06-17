package com.company;

public class AtoiMain {
    public static void main(String[] args) {

    }

    static int atoi(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int idx = 0;
        while (idx < n && chars[idx] == ' ') {
            idx++;
        }
        if (idx == n) {
            return 0;
        }

        boolean negative = false;
        if (chars[idx] == '-') {
            negative = true;
            idx++;
        } else if (chars[idx] == '+') {
            idx++;
        } else if (!Character.isDigit(chars[idx])) {
            return 0;
        }

        int ans = 0;
        while (idx < n && Character.isDigit(chars[idx])) {
            int d = chars[idx] - '0';
            // ans * 10 + d > Integer.MAX_VALUE
            if (ans > (Integer.MAX_VALUE - d) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + ans;
        }
        return negative ? -ans : ans;
    }
}
