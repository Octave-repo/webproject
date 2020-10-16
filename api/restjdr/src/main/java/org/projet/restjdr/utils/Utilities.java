package org.projet.restjdr.utils;

import java.util.HashMap;
import java.util.Set;

/**
 * Cette classe contient plusieurs méthode statiques utilitaires.
 */
public class Utilities {

    /**
     *Cette méthode permet de construire une ImmutableKeyMap à partir d'un Set.
     * Elle sera utile pour l'initialisation d'une fiche de personnage.
     * @param skills Un set correspondant à la liste des compétences de la campagne.
     * @return Une ImmutableKeyMap avec comme clé chacune des compétences.
     */
    public static ImmutableKeyMap<String, Integer> generateSkills (Set<String> skills) {
        HashMap<String, Integer> map = new HashMap<>();
        skills.forEach(s -> map.put(s, 0));
        return new ImmutableKeyMap<String, Integer>(map);
    }
}
