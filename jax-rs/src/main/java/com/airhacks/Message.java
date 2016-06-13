package com.airhacks;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author airhacks.com
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Message {

    private String message;
    private int prio;

    public Message(String message, int prio) {
        this.message = message;
        this.prio = prio;
    }

    public Message() {
    }

}
