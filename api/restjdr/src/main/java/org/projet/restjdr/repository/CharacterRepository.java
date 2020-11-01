package org.projet.restjdr.repository;

import org.projet.restjdr.entity.Campaign;
import org.projet.restjdr.entity.Character;
import org.projet.restjdr.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CharacterRepository extends CrudRepository<Character, Integer>
{
    @Query("select u from Character u")
    List<Character> queryAllCharacter();
    @Query("select c from Character c where c.createur.username = :username")
    List<Character> findCharacterByMj(@Param("username") String username);
}
