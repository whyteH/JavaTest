package laosiji.tech.object;

public class inheritance {

    /**
     * @param args
     */
    public static void main(String[] args) {
        C b = new C();
        b.show();
    }
}

class C {
    public C() {

    }

    void show() {
        System.out.println("SuperClass");
    }
}

class D extends C {
    @Override
    void show() {
        // TODO Auto-generated method stub
        super.show();
    }
}
