package com.airhacks;

/**
 *
 * @author airhacks.com
 */
public class CargoCult {

    @NoMagic("deep")
    String message;

    @NoMagic(value = "midrange", priority = 10)
    String wizard;

    String anotherNotAnnotated;

    @NoMagic("light")
    public void doSomething() {

    }

}
