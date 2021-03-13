package com.bytedance.heap;

/**
 * @program: algorithm
 * @description: 实现一个基于大顶堆的优先队列
 * @author: wl.zhou
 * @create: 2021-03-13 11:45
 **/
public class MaxPQ<T extends Comparable<T>> {

    private T[] pq;

    private int N = 0;

    public MaxPQ(){

    }

    public MaxPQ(int maxN){
        this.pq = (T[]) new Comparable[maxN+1];
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void insert(T val){
        pq[++N] = val;
        swim(N);
    }

    public T delMax(){
        T max = pq[1];
        swap(1, N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

    public void swim(int k){
        while (k > 1 && less(k/2, k)){
            swap(k/2, k);
            k = k / 2;
        }
    }

    public void sink(int k){
        while (k * 2 <= N){
            int j = k * 2;
            if (j + 1 <= N && less(j,j+1)){
                j++;
            }
            if (!less(k, j)) break;
            swap(k,j);
            k = j;
        }
    }

    private boolean less(int i , int j ){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void swap(int i,  int j){
        T tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

}
