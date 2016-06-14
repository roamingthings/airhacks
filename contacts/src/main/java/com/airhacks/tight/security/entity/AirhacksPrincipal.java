package com.airhacks.tight.security.entity;

/**
 *
 * @author airhacks.com
 */
public class AirhacksPrincipal {

    private String name;
    private String entitlements;

    public AirhacksPrincipal(String name, String entitlements) {
        this.name = name;
        this.entitlements = entitlements;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "AirhacksPrincipal{" + "name=" + name + ", entitlements=" + entitlements + '}';
    }

    public boolean isAllowed(String entitlement) {
        return this.entitlements.contains(entitlement);
    }

}
