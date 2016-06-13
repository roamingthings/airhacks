package com.airhacks;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Path("magic")
public class MagicResource {

    @GET
    public String get() {
        return "deep magic";
    }

}
