package interview;

public class Value {
    private String s = "spring";
    private char[] c = {'2', '0', '0', '6'};

    public static void main(String[] args) {
        Value v = new Value();
        v.swap(v.s, v.c);
        System.out.print(v.s);
        System.out.print(v.c);
    }

    private void swap(String s, char[] c) {
        c[c.length - 2] = '1';
        c[c.length - 1] = '9';
        s = new String("boot");
    }
}
