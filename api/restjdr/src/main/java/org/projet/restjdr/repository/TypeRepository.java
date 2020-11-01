package org.projet.restjdr.repository;

import org.projet.restjdr.entity.Type;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TypeRepository extends CrudRepository<Type, Integer>
{
    @Query("select t from Type t")
    List<Type> queryAllType();
}
