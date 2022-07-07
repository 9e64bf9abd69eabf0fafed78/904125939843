package test;

import java.util.Random;

/**
 * @date :  19.4.2  14:00
 */
public class RandomTest {
    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            int j = new Random().nextInt(900000) + 100000;
            if (j > 999999 || j < 100000) {
                System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!");
            }
            System.out.println(j);
        }
    }

}
