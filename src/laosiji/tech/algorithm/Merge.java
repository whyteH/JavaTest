package laosiji.tech.algorithm;

import java.util.Arrays;

/**
 * 两个已经排好序的数组，快速合并
 */
public class Merge {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6};
        int b[] = {5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(merge(a, b)));
    }

    private static int[] merge(int[] a, int[] b) {

        int pa = 0, pb = 0, pc = 0;
        int m = a.length;
        int n = b.length;
        int[] c = new int[m + n];
        while (pa < m && pb < n) {
            if (a[pa] < b[pb])
                c[pc++] = a[pa++];
            else
                c[pc++] = b[pb++];
        }
        if (pa < m)
            while (pa < m)
                c[pc++] = a[pa++];
        else
            while (pb < n)
                c[pc++] = b[pb++];
        return c;
    }
}
