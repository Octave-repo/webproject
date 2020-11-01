package org.projet.restjdr.services;

import org.projet.restjdr.entity.Type;
import org.projet.restjdr.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("type")
public class TypeResources
{
    @Autowired
    private TypeRepository typeRepository;

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response creerType(Type t)
    {
        typeRepository.save(t);
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Type> getType()
    {
        return typeRepository.queryAllType();
    }
}
