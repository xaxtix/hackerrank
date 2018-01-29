package com.isamorodov.utils.collections;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by xaxtix on 29.01.18.
 */
public class MultiTreeSet<T> extends Multiset<T> {

    @Override
    protected Map<T, Integer> createMap() {
        return new TreeMap<>();
    }
}
