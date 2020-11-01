package org.projet.restjdr.misc;

import org.glassfish.jersey.server.ResourceConfig;
import org.projet.restjdr.CORSFilter;
import org.projet.restjdr.repository.CharacterRepository;
import org.projet.restjdr.services.CampaignResources;
import org.projet.restjdr.services.CharacterResources;
import org.projet.restjdr.services.TypeResources;
import org.projet.restjdr.services.UserResources;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("jdr")
@Configuration
public class JerseyConfiguration extends ResourceConfig
{
    public JerseyConfiguration()
    {
        register(UserResources.class);
        register(CORSFilter.class);
        register(TypeResources.class);
        register(CharacterResources.class);
        register(CampaignResources.class);
    }
}
