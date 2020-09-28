package org.projet.restjdr.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Classe pour la gestion d'un utilisateur
 * Contient un nom d'utilisateur, un mot de passe ansi
 * qu'un boolean indiquant si l'utilisateur est administrateur.
 */
@Data
@Entity
public class User {
    @Id
    private String username;
    @Getter(AccessLevel.NONE)
    private String password;
    private boolean admin;

    /**
     * Cette fonction permet de vérifier si un mot de passe passé
     * en paramètres est le même que le mot de passe de l'utilisateur.
     * @param pass Le mot de passe à vérifier.
     * @return Si oui ou non le mot de passe en paramètre est la même que celui
     * de l'utilisateur.
     */
    public boolean isRightPassword (String pass) {return pass.equals(password);}
}
