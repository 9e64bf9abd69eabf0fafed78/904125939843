package test;

import java.io.Serializable;
import java.util.List;


public class JsonTest {
    public static void main(String[] args) {
        Integer i = 2;
        Integer x = null;
        System.out.println(x != null ^ i == null);
    }
}

class TaskMessage implements Serializable {
    private List<FileUrl> data;
}

class FileUrl implements Serializable {
    private Long id;
    private String url;
    private String sn;
    private Integer channel;
    private Long birth;
}