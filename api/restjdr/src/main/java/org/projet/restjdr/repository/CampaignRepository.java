package org.projet.restjdr.repository;

import org.projet.restjdr.entity.Campaign;
import org.projet.restjdr.entity.Character;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CampaignRepository extends CrudRepository<Campaign, Integer>
{
    @Query("select u from Campaign u")
    List<Campaign> queryAllCampaign();
    @Query("select c from Campaign c where c.mj.username = :username")
    List<Campaign> findCampaignsByMj(@Param("username") String username);
}
