package com.vip.movie.header.bean;

/**
 * Created by TA on 2017/12/7.
 */

public class EventBusStickMessage {
    public final String message;

    public EventBusStickMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
