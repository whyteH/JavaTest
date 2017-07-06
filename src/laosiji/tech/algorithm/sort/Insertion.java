package laosiji.tech.algorithm.sort;

import laosiji.tech.algorithm.sort.utils.SmallUtils;

import java.util.Arrays;


public class Insertion {
    public static void main(String[] args) {
        String[] a = {"d", "a", "b", "t", "s", "h", "r", "c", "g"};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private Insertion() {
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && SmallUtils.less(a[j], a[j - 1]); j--) {
                SmallUtils.exch(a, j, j - 1);
            }
            assert SmallUtils.isSorted(a, 0, i);
        }
        assert SmallUtils.isSorted(a);
    }
}
