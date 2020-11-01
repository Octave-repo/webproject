package org.projet.restjdr.entity;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.projet.restjdr.utils.ImmutableKeyMap;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Data
@Entity
/**
 * Ce DTO représente une fiche de personnage;
 */
public class Character {
    //On regroupe pour plus de lisibilité
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int idCharacter;
   @ManyToOne(targetEntity = Campaign.class)
   private Campaign campagne;
   @ManyToOne(targetEntity = User.class)
   private User createur;
   private String nom;


   private int gold;
   private int force;
   private int intelligence;
   private int dexterite;
   private int charisme;
   private int constitution;
   private int niveau;
   private int exp;
   private int maxHp;
   private int hp;



   private String classe;
   private String race;
   private String description;
   private HashMap<String, Integer> competences;

}
