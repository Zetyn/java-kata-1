package main.java.org.echocat.kata.java.part1;

import java.util.List;

public class ConsolePrinter {
    public <P> void print(P object) {
        if (object != null) {
            System.out.println(object);
        } else  {
            System.out.println("Null");
        }
    }
    public <P> void print(List<P> list) {
        if (list != null) {
            System.out.println(list);
        } else {
            System.out.println("Null");
        }
    }

}
