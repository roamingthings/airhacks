package com.airhacks.tight.security.boundary;

import com.airhacks.tight.security.entity.AirhacksPrincipal;

import javax.enterprise.inject.Produces;
import java.security.Principal;

/**
 *
 * @author airhacks.com
 */
public class Authenticator {
    // tag::airhacks_principal_producer[]
    @Produces
    public AirhacksPrincipal expose(Principal principal) {
        String entitlement = go2DBAndFetch(principal.getName());
        return new AirhacksPrincipal(principal.getName(), entitlement);
    }
    // end::airhacks_principal_producer[]

    private String go2DBAndFetch(String name) {
        return "do whatever you want " + name;
    }

}
