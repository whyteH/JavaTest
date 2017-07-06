package laosiji.tech.algorithm.sort;


import laosiji.tech.algorithm.sort.utils.StdOut;
import laosiji.tech.algorithm.sort.utils.StdRandom;
import laosiji.tech.algorithm.sort.utils.Stopwatch;

public class SortCompare {

    public static double time(String alg, Double[] a) {
        Stopwatch sw = new Stopwatch();
        if (alg.equals("SelectionSort"))
            SelectionSort.sort(a);
        else if (alg.equals("InsertionX"))
            InsertionX.sort(a);
        else if (alg.equals("Insertion"))
            Insertion.sort(a);
        else if (alg.equals("Bubbling"))
            Bubbling.sort(a);
        else if (alg.equals("Shell"))
            Shell.sort(a);
        else if (alg.equals("Merge"))
            Merge.sort(a);
        else if (alg.equals("MergeBU"))
            MergeBU.sort(a);
        else if (alg.equals("Quick"))
            Quick.sort(a);
        else
            throw new IllegalArgumentException("Invalid algorithm" + alg);
        Runtime.getRuntime().totalMemory();
        return sw.elapsedTime();
    }

    // Use alg to sort T random arrays of length N.
    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++)
                a[j] = StdRandom.uniform();
            total += time(alg, a);
        }
        return total;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int N = 1000;
        int T = 1000;
        String alg1 = "Insertion";
        String alg2 = "SelectionSort";
        String alg3 = "Bubbling";
        String alg4 = "InsertionX";
        String alg5 = "Shell";
        String alg6 = "Merge";
        String alg7 = "MergeBU";
        String alg8 = "Quick";
        double time1 = timeRandomInput(alg1, N, T);
        StdOut.println("For " + N + " random Doubles traversal " + T
                + " example:\n" + alg1 + " is times:" + time1);
        double time2 = timeRandomInput(alg2, N, T);
        StdOut.println(alg2 + " is times:" + time2);
        double time3 = timeRandomInput(alg3, N, T);
        StdOut.println(alg3 + " is times:" + time3);
        double time4 = timeRandomInput(alg4, N, T);
        StdOut.println(alg4 + " is times:" + time4);
        double time5 = timeRandomInput(alg5, N, T);
        StdOut.println(alg5 + " is times:" + time5);
        double time6 = timeRandomInput(alg6, N, T);
        StdOut.println(alg6 + " is times:" + time6);
        double time7 = timeRandomInput(alg7, N, T);
        StdOut.println(alg7 + " is times:" + time7);
        double time8 = timeRandomInput(alg8, N, T);
        StdOut.println(alg8 + " is times:" + time8);
        // StdOut.printf("For %d random Doubles\n %s is", N, alg1);
        // StdOut.printf(" %f.if times faster than %s\n", time2 / time1, alg2);
    }
}
