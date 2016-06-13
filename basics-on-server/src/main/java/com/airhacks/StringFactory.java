package com.airhacks;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author airhacks.com
 */
public class StringFactory {

    @Produces
    public String configurable(InjectionPoint ip) {
        Class<?> clazz = ip.getMember().getDeclaringClass();
        String fieldName = ip.getMember().getName();
        return clazz.getName() + "->" + fieldName + " -->" + System.currentTimeMillis();
    }

}
