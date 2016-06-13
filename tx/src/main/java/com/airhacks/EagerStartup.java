package com.airhacks;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author airhacks.com
 */
@Startup
@Singleton
@DependsOn("Monitoring")
public class EagerStartup {

    @PostConstruct
    public void init() {
        System.out.println("--------eager starter");
    }

}
