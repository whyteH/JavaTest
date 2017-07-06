package laosiji.tech.object;

public class MethodLocalVSInner {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new MethodLocalVSInner().go();
    }

    void go() {
        new A().m();
        class A {
            void m() {
                System.out.println("inner");
            }
        }
    }

    class A {
        void m() {
            System.out.println("middle");
        }
    }
}

class A {
    void m() {
        System.out.println("outer");
    }
}
