package com.airhacks;

import javax.enterprise.inject.Produces;

/**
 *
 * @author airhacks.com
 */
public class AnotherFactory {

    @Produces
    @Highly
    private String another = "who wins";
}
