package laosiji.tech.algorithm.sort.utils;

public class Stopwatch {
    private final long start;

    /*
     * Create a stopwatch object
     */
    public Stopwatch() {
        start = System.nanoTime();
    }

    /*
     * Return elapsed time (in seconds) since this object was created.
     */
    public double elapsedTime() {
        long now = System.nanoTime();
        return (now - start) / 100.0;
    }
}
