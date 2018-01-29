package com.isamorodov.utils.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by xaxtix on 29.01.18.
 */
public class MultiHashSet<T> extends Multiset<T> {

    @Override
    protected Map<T, Integer> createMap() {
        return new HashMap<>();
    }
}
