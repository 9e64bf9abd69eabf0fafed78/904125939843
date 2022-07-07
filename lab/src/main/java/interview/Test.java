package interview;

import java.security.Key;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @date :  19.5.23  10:25
 */
public class Test {
    protected static String string = "输出结果为:";

    private static void foo(int a) throws Exception {
        int i = Integer.MAX_VALUE;
        long now = System.currentTimeMillis();
        Map<Key, Value> map = new LinkedHashMap<>();
        try {
            string += "1";
            if (map instanceof Collection || Math.min(i, now) > i + 1000) {
                throw new Exception();
            }
        } catch (Exception e) {
            string += "2";
            throw e;
        } finally {
            string += "3";
        }
        string += "4";
    }


    public static void main(String[] args) throws Exception {
//                            public static void main(String[] args) {      //throws Exception{
        foo(1);
        try {
            foo(0);
        } catch (Exception e) {
            System.out.print(string);
        }
    }
}
