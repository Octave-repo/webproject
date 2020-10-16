package org.projet.restjdr.entity;

import lombok.Data;
import org.projet.restjdr.utils.ImmutableKeyMap;

import javax.persistence.Entity;

@Data
@Entity
/**
 * Ce DTO représente une fiche de personnage;
 */
public class Character {
    //On regroupe pour plus de lisibilité

   private int idCampagne;
   private String nomCreateur;
   private String nom, classe, race;
   private int or, niveau, exp, maxHp, hp;
   private int force, intelligence, dexterite, charisme, constitution;
   private String description;
   private ImmutableKeyMap<String, Integer> competences;
}
