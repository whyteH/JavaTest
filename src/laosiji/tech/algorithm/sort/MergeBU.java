package laosiji.tech.algorithm.sort;

import laosiji.tech.algorithm.sort.utils.SmallUtils;

import java.util.Arrays;


public class MergeBU {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] s = {"s", "g", "e", "a", "b", "d", "f", "h"};
        sort(s);
        System.out.println(Arrays.toString(s));
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for (int i = 1; i < N; i = i + i) {
            for (int j = 0; j < N - i; j += i + i) {
                int lo = j;
                int m = j + i - 1;
                int hi = Math.min(j + i + i - 1, N - 1);
                merge(a, aux, lo, m, hi);
            }
        }
        assert SmallUtils.isSorted(a);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo,
                              int mid, int hi) {
        // copy to aux[]
        for (int i = 0; i <= hi; i++) {
            aux[i] = a[i];
        }

        // merge back to a[]
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (SmallUtils.less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }

}
