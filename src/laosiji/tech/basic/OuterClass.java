package laosiji.tech.basic;

public class OuterClass {

    public class NormallInnerClass {
        public void call() {
            fun();
        }
    }

    public static class StaticInnerClass {
        public void ask() {
//            fun(); //compile error
        }
    }

    public void fun() {

    }

    public static void main(String[] arg) {
        new OuterClass().new NormallInnerClass().call();
        new StaticInnerClass().ask();
        String s = "";
    }
}
