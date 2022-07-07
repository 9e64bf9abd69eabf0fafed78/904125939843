package interview;

/**
 * @date :  19.4.10  13:25
 */
@SuppressWarnings("all")
public class DataTypeInit {
    public static void main(String[] args) {
        Integer a = 18, b = 18;
        int c = 18;
        Integer d = 2019, e = 2019;
        Integer f = new Integer(18);
        System.out.println(a == b);                                                 //  true 在-128~127直接的数值, 会有缓存机制
        System.out.println(b == f);                                                 // false 通过构造创建的对象均是新对象
        System.out.println(a == c);                                                // true 与基本类型比较时只比值
        System.out.println(d == e);                                              // false 超过范围, 底层通过构造创建
        String s1 = "mp", s2 = "mp";
        String s3 = new String("mp");
        String s4 = new String("mp");
        String s5 = "m" + "p";
        System.err.println(s1 == s5);                                                 //  true JVM做了优化 : 会先做合并, 然后JVM发现已存在值相等的String对象, 直接指向
        System.err.println(s1 == s3);                                                 //  false JVM创建了一个新的"mp"
        System.err.println(s2 == s1);                                                // true 同理, 指向已存在的同值对象
        System.err.println(s3 == s4);                                                // false 通过构造创建的对象均是新对象
    }
}
