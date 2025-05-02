package com.chandan.takeUforward.placementseries.Findtherepeatingandmissingnumbers;
/*
* Problem Statement: You are given a read-only array of N integers with values also in the range [1, N] both inclusive. Each integer appears exactly once except A which appears twice and B which is missing. The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.

Examples

Example 1:
Input Format:  array[] = {3,1,2,5,3}
Result: {3,4)
Explanation: A = 3 , B = 4
Since 3 is appearing twice and 4 is missing

Example 2:
Input Format: array[] = {3,1,2,5,4,6,7,5}
Result: {5,8)
Explanation: A = 5 , B = 8
Since 5 is appearing twice and 8 is missing
* */
public class Solution {
    public static void main(String[] args) {
        int[] a = {3, 1, 2, 5, 4, 6, 7, 5};
        int[] ans = findMissingRepeatingNumbers(a);
        System.out.println("The repeating and missing numbers are: {"
                + ans[0] + ", " + ans[1] + "}");
    }

    public static int[] findMissingRepeatingNumbers(int[] a) {
        long n = a.length; // size of the array
        // Find Sn and S2n:
        long SN = (n * (n + 1)) / 2;
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

        // Calculate S and S2:
        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += a[i];
            S2 += (long)a[i] * (long)a[i];
        }

        //S-Sn = X-Y:
        long val1 = S - SN;

        // S2-S2n = X^2-Y^2:
        long val2 = S2 - S2N;

        //Find X+Y = (X^2-Y^2)/(X-Y):
        val2 = val2 / val1;

        //Find X and Y: X = ((X+Y)+(X-Y))/2 and Y = X-(X-Y),
        // Here, X-Y = val1 and X+Y = val2:
        long x = (val1 + val2) / 2;
        long y = x - val1;

        int[] ans = {(int)x, (int)y};
        return ans;
    }

    public static int[] findMissingRepeatingNumbers1(int[] a) {
        int n = a.length; // size of the array
        int xr = 0;

        //Step 1: Find XOR of all elements:
        for (int i = 0; i < n; i++) {
            xr = xr ^ a[i];
            xr = xr ^ (i + 1);
        }

        //Step 2: Find the differentiating bit number:
        int number = (xr & ~(xr - 1));

        //Step 3: Group the numbers:
        int zero = 0;
        int one = 0;
        for (int i = 0; i < n; i++) {
            //part of 1 group:
            if ((a[i] & number) != 0) {
                one = one ^ a[i];
            }
            //part of 0 group:
            else {
                zero = zero ^ a[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            //part of 1 group:
            if ((i & number) != 0) {
                one = one ^ i;
            }
            //part of 0 group:
            else {
                zero = zero ^ i;
            }
        }

        // Last step: Identify the numbers:
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == zero) cnt++;
        }

        if (cnt == 2) return new int[] {zero, one};
        return new int[] {one, zero};
    }
}
