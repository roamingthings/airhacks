package com.airhacks;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author airhacks.com
 */
@Startup
@Singleton
public class Monitoring {

    @PostConstruct
    public void initialize() {
        System.out.println("Before app becomes available");
    }

    @Schedule(minute = "*", second = "*/2", hour = "*")
    public void repeatedAction() {
        System.out.println("-- invoked " + new Date());
    }

}
