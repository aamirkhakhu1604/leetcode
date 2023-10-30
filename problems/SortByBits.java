/*
Sort Integers by The Number of 1 Bits

You are given an integer array arr. Sort the integers in the array in ascending order 
by the number of 1's in their binary representation and in case of two or more integers 
have the same number of 1's you have to sort them in ascending order.

Return the array after sorting it.
*/

import java.io.*;
import java.util.*;

class SortByBits {
    public int[] sortByBits(int[] arr) {

        Integer[] intArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        // custom comparator to sort by bit and then numerically
        Comparator<Integer> comparator = new BitCountComparator();

        Arrays.sort(intArr, comparator);

        return Arrays.stream(intArr).mapToInt(Integer::intValue).toArray();
    }

     
}

class BitCountComparator implements Comparator<Integer> {

    private int findBitCount(Integer n) {
        int count = 0;
        while (n > 0) {
            count = count + (n & 1);
            n = n >> 1;
        }
        return count;
    }

    @Override
    public int compare(Integer a, Integer b) {

        int bitCountA = findBitCount(a);
        int bitCountB = findBitCount(b);

        // if bit count is same then compare numerically
        if (bitCountA == bitCountB) {
            return a - b;
        } 
        return bitCountA - bitCountB;
    }
}
