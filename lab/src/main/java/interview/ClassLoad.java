package interview;

/**
 * @date :  19.5.22  10:28
 */
public class ClassLoad {
    public static void main(String[] args) {
        System.err.print(Sub.x * 10 + Sub.y);                                                                 //  TODO  10
    }
}

class Sub {
    private static Sub s = new Sub();
    static int x;
    static int y;

    private Sub() {
        x++;
    }
}


