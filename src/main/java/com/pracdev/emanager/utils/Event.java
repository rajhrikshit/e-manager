package com.pracdev.emanager.utils;

import java.sql.Date;
import java.util.List;

public class Event {

    private String eventId;
    private String name;
    private String date;
    private String manager;
    private String location;

    public Event() {
    }

    public Event(String eventId, String name, String date, String manager, String location) {
        this.eventId = eventId;
        this.name = name;
        this.date = date;
        this.manager = manager;
        this.location = location;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object obj) {
        Event e = (Event) obj;
        return this.getEventId().equals(e.getEventId());
    }
}
