package test;

import java.util.*;
import java.util.stream.Collectors;


public class ListTest {
    public static void main(String[] args) {
        order();
    }

    public static void retainAll() {
        List<String> origin = new ArrayList<>();
        origin.add("0");
        origin.add("0");
        origin.add("0");
        origin.add("0");
        origin.add("0");
        System.out.println(String.join("-", origin));
        List<Integer> ordered = new ArrayList<>();
        ordered.add(1);
        ordered.add(2);
        ordered.add(6);
        ordered.add(3);
        ordered.add(4);
        ordered.add(0);
//        Set<Integer> unordered = new HashSet<>(origin);
//        unordered.removeAll(ordered);
//        ordered.retainAll(origin);
//        ordered.addAll(unordered);
//        System.out.println(ordered);
    }

    public static void order() {
        List<Man> origin = Arrays.asList(
                new Man(1, "A"),
                new Man(2, "B"),
                new Man(3, "C"),
                new Man(4, "D"),
                new Man(5, "E"));
        origin.stream().map(o -> {
            System.out.println(o.getId());
            return o;
        }).collect(Collectors.toList());
    }

    public static void a() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        Integer integer = 12;
        list1.add(0, integer);
        Collections.reverse(list1);
        System.out.println("".equals(list1.stream().filter(Objects::nonNull).map(Object::toString).collect(Collectors.joining(","))));
        System.out.println(list1.size());
        list1 = list1.subList(2, 4);
        System.out.println(list1);
        /*List< Integer > list2 = new ArrayList<>();
        list2.add( 1 );
        list2.add( 2 );
        list2.add( 3 );
        list2.add( 5 );
//        list1.retainAll( list2 );
        System.err.println( Arrays.toString( list1.toArray() ) );
        System.out.println( Arrays.toString( list2.toArray() ) );
        list2.removeAll( list1 );
        System.out.println( Arrays.toString( list2.toArray() ) );*/
        List<Integer> a = new ArrayList<>();
//        a.add(1);
        a.add(2);
        a.add(3);
//        a.add(4);
        List<Integer> b = new ArrayList<>();
        b.add(5);
//        b.add(2);
//        b.add(3);
        b.add(4);
        b.retainAll(a);
        System.out.println(b);
    }
}

class Man {
    private int id;
    private String name;

    public Man(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}