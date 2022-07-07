package test;

import java.util.HashMap;


public class MapTest {
    public static void main(String[] args) {
        HashMap<String, Double> m = new HashMap<>(16) {{
            put("field_!", 913.9);
            put("掐爱C阿斯顿", 9113.9);
            put("乌恰大所", 9103.9);
            put("QWERTY", 913.9);
            put("as大多", 919.3);
            put("算嗲球球", 9513.9);
        }};
        for (String s : m.keySet()) {
            System.out.println(s + "---------------------------" + m.get(s));
        }
    }
}
