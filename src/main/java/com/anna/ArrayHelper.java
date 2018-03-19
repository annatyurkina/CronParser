package com.anna;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayHelper {

    public static int[] generate(int start, int end, int step) {

        if(start > end) {
            throw new ArrayIndexOutOfBoundsException("Start integer must be less or equal to end integer. " +
                    "Values received: " + start + " - " + end);
        }

        int length = (end - start)/step + 1;
        int[] result = new int[length];

        for(int i = 0; i < length; i++) {
            result[i] = start + step * i;
        }

        return result;
    }

    public static boolean isSortedArrayInRange(int[] arr, int min, int max) {
        int cur = Integer.MIN_VALUE;
        if(arr[0] < min || arr[arr.length - 1] > max) {
            return false;
        }
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < cur) {
                return false;
            }
            cur = arr[i];
        }
        return true;
    }

    public static String getString(int[] arr) {
        return Arrays.stream(arr).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(" "));
    }
}
