package org.projet.restjdr.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Campaign {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Enumerated(EnumType.STRING)
    private int type;
}
