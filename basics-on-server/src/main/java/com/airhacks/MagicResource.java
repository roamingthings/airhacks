package com.airhacks;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Path("magic")
public class MagicResource {

    @Inject
    CargoCult cult;

    @Inject
    CargoCult backup;

    @GET
    public String get() {
        System.out.println("--- Cargo cult is: " + cult.getClass().getName());
        return cult.getSomeMagic() + " <-> " + backup.getSomeMagic();
    }

}
