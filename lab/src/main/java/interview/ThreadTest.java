package interview;

/**
 * @date :  19.5.23  10:35
 */
public class ThreadTest {
    public static void main(String[] args) {
        new Thread(ThreadTest::hello).run();
        System.out.print("牛奶");
    }

    private static void hello() {
        System.out.print("奶牛");
    }
}
