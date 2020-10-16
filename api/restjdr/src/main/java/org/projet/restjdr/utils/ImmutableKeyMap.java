package org.projet.restjdr.utils;

import java.util.HashMap;
import java.util.Map;

/**
 *Classe étendue de HashMap empêchant une modification des clés, en revanche,
 * les valeurs peuvent être modifiée.
 * @param <K> Type des clés
 * @param <V> Type des valeurs
 */
public class ImmutableKeyMap<K, V> extends HashMap<K, V> {
    public ImmutableKeyMap(HashMap<K, V> m)
    {
        super(m);
    }
    //Ici on autorise seulement de put si la clé existe déjà
    @Override
    public V put(K key, V value) {
        if (this.containsKey(key))
            return super.put(key, value);
        else
            return null;
    }
    //Ici on empêche la suppression de valeur.
    @Override
    public boolean remove(Object key, Object value){ return false;}

    @Override
    public V remove(Object key) { return null;}
}
