package com.airhacks;

import javax.enterprise.inject.Produces;

/**
 *
 * @author airhacks.com
 */
public class StringFactory {

    @Produces
    private String aString = "highly configurable";

}
