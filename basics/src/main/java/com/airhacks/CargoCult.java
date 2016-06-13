package com.airhacks;

/**
 *
 * @author airhacks.com
 */
public class CargoCult {

    @NoMagic("deep")
    String message;

    String anotherNotAnnotated;

    @NoMagic("light")
    public void doSomething() {

    }

}
