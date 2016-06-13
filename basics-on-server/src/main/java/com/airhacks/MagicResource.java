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

    CargoCult backup;

    public MagicResource() {
        this.backup = new CargoCult();
    }

    @GET
    public String get() {
        return cult.getSomeMagic() + " <-> " + backup.getSomeMagic();
    }

}
