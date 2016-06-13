package com.airhacks;

import javax.enterprise.inject.Produces;

/**
 *
 * @author airhacks.com
 */
public class StringFactory {

    @Produces
    public String configurable() {
        return " a string from a method" + System.currentTimeMillis();
    }

}
