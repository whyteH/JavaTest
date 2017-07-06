package laosiji.tech.basic;

public class EnumTest {

    /**
     * int to enum
     *
     * @param args
     */
    public static void main(String[] args) {
        handle(Type.valueOf(1));
    }

    public static void handle(Type type) {
        switch (type) {
            case NORMAL:

                break;
            case LOW:

                break;
            case MIDDLE:

                break;
            case HIGH:

                break;
        }
    }

    public enum Type {
        NORMAL(1), LOW(2), MIDDLE(3), HIGH(4);

        public static Type valueOf(int type) {
            switch (type) {
                case 1:
                    return NORMAL;
                case 2:
                    return LOW;
                case 3:
                    return MIDDLE;
                case 4:
                    return HIGH;
                default:
                    return null;
            }
        }

        private Type(int value) {
            this.value = value;
        }

        private int value;

        public int getValue() {
            return value;
        }
    }
}
