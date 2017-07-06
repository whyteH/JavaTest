package laosiji.tech.algorithm.sort;

import laosiji.tech.algorithm.sort.utils.SmallUtils;
import laosiji.tech.algorithm.sort.utils.StdRandom;

import java.util.Arrays;


public class Quick {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] a = {"b", "s", "a", "c", "r", "h", "g", "d"};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(Comparable[] a) {
        try {
            StdRandom.shuffle(a);
            sort(a, 0, a.length - 1);
            assert SmallUtils.isSorted(a);
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
        assert SmallUtils.isSorted(a, lo, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {

            //find item on lo to swap
            while (SmallUtils.less(a[++i], v))
                if (i == hi) break;

            //find item on hi to swap
            while (SmallUtils.less(v, a[--j]))
                if (j == lo) break;

            //check if pointers cross
            if (i >= j) break;
            SmallUtils.exch(a, i, j);
        }

        //put partitioning item v at a[j]
        SmallUtils.exch(a, lo, j);

        //now,a[lo .. j+1] <= a[j] <= a[j+1 .. hi]
        return j;
    }
}
