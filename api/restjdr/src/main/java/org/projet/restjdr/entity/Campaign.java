package org.projet.restjdr.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
/**
 * Ce DTO représente une campagne.
 */
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int limite;
    @ManyToOne(targetEntity = Type.class, cascade = CascadeType.MERGE)
    private Type type;
    @ManyToOne(targetEntity = User.class, cascade = CascadeType.MERGE)
    private User mj;
}
