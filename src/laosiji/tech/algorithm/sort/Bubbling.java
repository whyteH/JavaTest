package laosiji.tech.algorithm.sort;

import laosiji.tech.algorithm.sort.utils.SmallUtils;

import java.util.Arrays;


public class Bubbling {
    public static void main(String[] args) {
        String[] a = {"d", "a", "b", "t", "s", "h", "r", "c", "g"};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private Bubbling() {
    }

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (SmallUtils.less(a[j], a[j + 1])) {
                    SmallUtils.exch(a, j, j + 1);
                }
            }
        }
    }
}
