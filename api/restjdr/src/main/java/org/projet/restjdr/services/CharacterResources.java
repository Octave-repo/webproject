package org.projet.restjdr.services;

import org.projet.restjdr.entity.Campaign;
import org.projet.restjdr.entity.Character;
import org.projet.restjdr.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("character")
public class CharacterResources
{
    @Autowired
    CharacterRepository characterRepository;

    @Path("create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response creerCharacter(Character c)
    {
        characterRepository.save(c);
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Character> getCharacter()
    {
        return characterRepository.queryAllCharacter();
    }

    @Path("users/{username}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Character> getCharacterByUsername(@PathParam("username") String username)
    {
        return characterRepository.findCharacterByMj(username);
    }


}
