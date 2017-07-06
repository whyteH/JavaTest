package laosiji.tech.algorithm.sort;


import laosiji.tech.algorithm.sort.utils.SmallUtils;

public class SelectionSort {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] a = {"d", "g", "b", "c", "a", "e", "h", "f"};
        SelectionSort.sort(a);
        SmallUtils.show(a);
    }

    private SelectionSort() {
    }

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (SmallUtils.less(a[j], a[min]))
                    min = j;
            }
            SmallUtils.exch(a, i, min);
            assert SmallUtils.isSorted(a, 0, i);
        }
        assert SmallUtils.isSorted(a);
    }

}
