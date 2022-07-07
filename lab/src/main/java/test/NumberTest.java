package test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @date :  18.11.8  10:47
 */
public class NumberTest {
    public static void main(String[] args) {

       short a=0;
       Integer b=0;
        System.out.println(a==b);
    }

    private static void order() {
        int a = 5;
        System.out.println(a += 10);
        System.out.println(a);

        System.out.println(Math.asin(10 >> 4 / 3)
        );
    }

    private static void y() {
        Integer o = null;
        Integer i = null;
        System.out.println(o == null ^ i == null);
        System.out.println((o != null && i != null) || (o == null && i == null));
    }

    private static void bigDecimal() {
        System.out.println(new BigDecimal(2L * 100.0 / 3).setScale(2, RoundingMode.HALF_UP).toPlainString());
        System.out.println(new BigDecimal(2L * 100.0 / 3).setScale(2, RoundingMode.HALF_UP).toEngineeringString());
        System.out.println(new BigDecimal(2L * 100.0 / 3).setScale(2, RoundingMode.HALF_UP).toString());
    }
}
