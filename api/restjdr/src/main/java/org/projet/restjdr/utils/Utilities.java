package org.projet.restjdr.utils;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Contient plusieurs fonctions statiques utilitaires.
 */
public class Utilities {
    /**
     * Génère une FinalKeyMap à partir d'une 'liste' en CSV.
     * @param cvsString Un string contenant les clés séparées par des virgules.
     * @return Une FinalKeyMap avec chaque clé provenant du paramètre.
     */
    public static FinalKeyMap<String, Integer> hashMapFromCsv (String cvsString){
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String[] split = cvsString.split(",");
        Arrays.asList(split).forEach(s -> map.put(s, 0));
        return new FinalKeyMap<String, Integer>(map);
    }
}
