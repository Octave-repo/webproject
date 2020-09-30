package org.projet.restjdr.utils;

import java.util.Arrays;
import java.util.HashMap;

public class FinalKeyMap<K, V> extends HashMap<K, V> {
    public FinalKeyMap (HashMap<K, V> m)
    {
        super(m);
    }

    @Override
    public V put(K key, V value) {
        if (this.containsKey(key))
            return super.put(key, value);
        else
            return null;
    }

    @Override
    public boolean remove(Object key, Object value){ return false;}

    @Override
    public V remove(Object key) { return null;}
}
