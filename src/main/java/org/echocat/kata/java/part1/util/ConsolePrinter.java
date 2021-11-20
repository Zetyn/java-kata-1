package org.echocat.kata.java.part1.util;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsolePrinter {
    public <P> void print(P object) {
        if (object != null) {
            System.out.println(object);
        } else {
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
