package com.airhacks;

import javax.ws.rs.GET;

/**
 *
 * @author airhacks.com
 */
public class MessageResource {

    private final long id;

    public MessageResource(long id) {
        this.id = id;
    }

    @GET
    public String get() {
        return "sub-resource locator with id: " + id;
    }

}
