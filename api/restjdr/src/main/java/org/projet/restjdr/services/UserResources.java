package org.projet.restjdr.services;

import org.projet.restjdr.entity.User;
import org.projet.restjdr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("users")
public class UserResources
{
    @Autowired
    private UserRepository userRepository;
    @Path("create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response creerUtilisateur(User u)
    {
        if(userRepository.findUserByUsername(u.getUsername()).isEmpty()) {
            userRepository.save(u);
            return Response.status(Response.Status.CREATED).build();
        }
        return Response.status(Response.Status.CONFLICT).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers()
    {
        return userRepository.queryAllUser();
    }

    @GET
    @Path("authentification")
    public Response authentification(@QueryParam("username") String username, @QueryParam("password") String password)
    {
        List<User> test =userRepository.findUserByUsername(username);
        if(test.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        if(test.get(0).isRightPassword(password))
            return Response.status(Response.Status.ACCEPTED).build();
        else
            return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
