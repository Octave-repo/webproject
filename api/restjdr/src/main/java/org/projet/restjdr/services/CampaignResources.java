package org.projet.restjdr.services;

import org.projet.restjdr.entity.Campaign;
import org.projet.restjdr.entity.Character;
import org.projet.restjdr.repository.CampaignRepository;
import org.projet.restjdr.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("campaign")
public class CampaignResources {

    @Autowired
    CampaignRepository campaignRepository;

    @Path("create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response creerCampaign(Campaign c)
    {
        campaignRepository.save(c);
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Campaign> getCampaign()
    {
        return campaignRepository.queryAllCampaign();
    }

    @Path("users/{username}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Campaign> getCampaignByUsername(@PathParam("username") String username)
    {
        return campaignRepository.findCampaignsByMj(username);
    }
}
