package com.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;


class Key {
    int id;

    Key(int id) { this.id = id; }

    @Override
    public int hashCode() { return id; }

    @Override
    public boolean equals(Object o) {
        /*if (this == o) return true; // same references
        if (o instanceof Key) {
            Key kk = (Key) o;
            return kk.id == this.id;
        } else return false;*/

        //return ((Key) o).id == this.id;
        return (o instanceof Key) && ((Key) o).id == this.id;
    }
}

public class Test2 {
    public static void main(String[] args) {

        List<Integer> list12 = IntStream.range(0,11).boxed().toList();
        System.out.println("list12: " + list12.toString());
        // list12.add(20);
        List<Integer> list11 = new ArrayList<>(list12);
        list11.add(21);
        System.out.println("list11: " + list11.toString());

        list11.add(10, 15);
        System.out.println("list11: " + list11.toString());

        List<Integer> list111 = new ArrayList<>();
        list111.add(1);
        list111.add(2);
        list111.add(3);

        for (Integer i : list111) {
            if (i == 2)
                list111.remove(i);
        }
        System.out.println(list111);

        Map<Key, String> map = new HashMap<>();
        Key k1 = new Key(1);
        map.put(k1, "Hello");

        System.out.println(map.get(k1));

        k1.id = 2;
        System.out.println(map.get(k1));
    }
}
