package com.bytedance.heap;

import java.util.Arrays;

/**
 * @program: algorithm
 * @description:
 * @author: wl.zhou
 * @create: 2021-03-13 17:23
 **/
public class HeapSort {

    public static void main(String[] args){
        Integer[] a = {1, 4, 2, 5, 3,6};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(Comparable[] a){
        int N = a.length;
        for (int k = N / 2 - 1; k >= 0; k--){
            sink(a, k,N-1);
        }
        int n = N - 1;
        while (n >= 1){
            swap(a,0, n--);
            sink(a,0, n);
        }
    }

    private static void sink(Comparable[] a, int k, int N){
        while (k * 2 + 1<= N){
            int j = k * 2 + 1;
            if (j+1 <= N && less(a,j, j+1)){
                j++;
            }
            if (!less(a, k, j)){
                break;
            }
            swap(a,k,j);
            k = j;
        }
    }

    private static boolean less(Comparable[] a, int i, int j){
        return a[i].compareTo(a[j]) < 0;
    }

    private static void swap(Comparable[] a, int i, int j){
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
