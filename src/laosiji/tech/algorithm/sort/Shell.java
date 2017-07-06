package laosiji.tech.algorithm.sort;

import laosiji.tech.algorithm.sort.utils.SmallUtils;

import java.util.Arrays;


public class Shell {
    private Shell() {
    }

    public static void main(String[] args) {
        String[] a = {"b", "f", "a", "e", "h", "d", "c"};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3)
            h = 3 * h + 1;//1,4,13,40,121,364,1093,3280....
        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && SmallUtils.less(a[j], a[j - h]); j -= h) {
                    SmallUtils.exch(a, j, j - h);
                }
            }
            assert SmallUtils.isHsorted(a, h);
            h /= 3;
        }
        assert SmallUtils.isSorted(a);
    }
}
