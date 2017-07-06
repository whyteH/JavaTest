package laosiji.tech.algorithm.sort;


import laosiji.tech.algorithm.sort.utils.SmallUtils;

public class InsertionX {
    public static void main(String[] args) {

    }

    private InsertionX() {
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = N - 1; i > 0; i--)
            if (SmallUtils.less(a[i], a[i - 1]))
                SmallUtils.exch(a, i, i - 1);
        for (int i = 2; i < N; i++) {
            Comparable v = a[i];
            int j = i;
            while (SmallUtils.less(v, a[j - 1])) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = v;
        }
        assert SmallUtils.isSorted(a);
    }
}
