package org.projet.restjdr.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@Data
@Entity
/**
 * Ce DTO représente un type de campagne.
 */
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idType;
    private String nom;
    //Vérifier comment ça rend avec le JSON !!
    //TODO
    private Set<String> template;
}
