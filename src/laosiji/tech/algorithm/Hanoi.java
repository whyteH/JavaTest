package laosiji.tech.algorithm;

/**
 * 汉诺塔算法
 */
public class Hanoi {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        hanoi(3, 'A', 'B', 'C');
    }

    private static void hanoi(int n, char x, char y, char z) {
        if (n == 1)
            move(x, n, z);
        else {
            hanoi(n - 1, x, z, y);
            move(x, n, z);
            hanoi(n - 1, y, x, z);
        }
    }

    private static void move(char x, int n, char y) {
        System.out.println("Move:" + n + "\tfrom " + x + " to\t" + y);
    }
}
