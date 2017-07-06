package laosiji.tech.algorithm.sort;

import laosiji.tech.algorithm.sort.utils.SmallUtils;

import java.util.Arrays;


public class Merge {
    /*
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
        assert SmallUtils.isSorted(a);
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);

    }

    // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    private static void merge(Comparable[] a, Comparable[] aux, int lo,
                              int mid, int hi) {
        assert SmallUtils.isSorted(aux, lo, mid);
        assert SmallUtils.isSorted(a, mid + 1, hi);
        // copy to aux[]
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];// this copying is unnecessary
            else if (j > hi)
                a[k] = aux[i++];
            else if (SmallUtils.less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
        assert SmallUtils.isSorted(aux, lo, hi);
    }

    public static void main(String[] args) {
        Integer[] a = {4, 2, 6, 5, 8, 7, 6, 5, 9, 12, 23, 11, 43, 54, 23, 34,
                89, 67};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
