package interview;

/**
 * @date :  19.5.23  10:42
 */
public class Son extends Fa {
    static {
        System.out.print("1");
    }

    {
        System.out.print("2");
    }

    private Son() {
        System.out.print("3");
    }

    public static void main(String[] args) {
        Fa s = new Son();
        System.out.print("4");
        new Son();
        System.out.print("5");                                          // TODO    618723487235
    }
}

class Fa {
    static {
        System.out.print("6");
    }

    Fa() {
        System.out.print("7");
    }

    {
        System.out.print("8");
    }
}


