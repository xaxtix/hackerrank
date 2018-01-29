package com.isamorodov.utils.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xaxtix on 29.01.18.
 */
public class ArrayMultiSet<T> {

    ArrayList<T> elements = new ArrayList<>();
    HashMap<T, Integer> counts = new HashMap<>();

    public void add(T key) {
        if (counts.containsKey(key)) {
            counts.put(key, counts.get(key) + 1);
        } else {
            elements.add(key);
            counts.put(key, 1);
        }
    }

    public int getCount(T key) {
        return counts.getOrDefault(key, 0);
    }

    public List<T> getElements() {
        return elements;
    }
}
