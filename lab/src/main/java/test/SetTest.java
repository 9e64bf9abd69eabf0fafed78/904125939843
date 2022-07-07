package test;

import java.util.HashSet;

public class SetTest {
    public static void main(String[] args) {
        HashSet<String> strings = new HashSet<>() {{
            add("113123124");
            add("kwargs");
            add("next");
            add("7 22:59:57 CST");
            add("Python\\Python39\\lib");
            add("line");
            add("菜");
            add("exception");
        }};
        System.err.println(strings);
        for (String s : strings) {
            System.err.println(s);
            System.out.println(s.hashCode());
        }
    }
}
