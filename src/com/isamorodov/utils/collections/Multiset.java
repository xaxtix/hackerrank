package com.isamorodov.utils.collections;

import java.util.Map;
import java.util.Set;

/**
 * Created by xaxtix on 29.01.18.
 */
public abstract class Multiset<T> {

    Map<T,Integer> map;

    protected abstract Map<T,Integer> createMap();

    public Multiset() {
        this.map = createMap();
    }

    public void add(T key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    public void delete(T key) {
        Integer value = map.get(key);
        if (value == null)
            return;
        if (value == 1) {
            map.remove(key);
            return;
        }

        map.put(key, map.get(key) - 1);
    }

    public int get(T key) {
        Integer i = map.get(key);
        return i == null ? 0 : i;
    }

    public Set<T> getSet(){
        return map.keySet();
    }
}
