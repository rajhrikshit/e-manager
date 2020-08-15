package com.pracdev.emanager.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Component
public class DBManager {

    private final ObjectMapper objectMapper;
    private final File eventDB;
    private List<Event> eventList;

    public DBManager() throws IOException {
        this.objectMapper = new ObjectMapper();
        this.eventDB = ResourceUtils.getFile("classpath:events.json");
    }

    public List<Event> getEventList() throws IOException {
        if(this.eventList == null) {
            this.jsonToPOJO();
        }
        return this.eventList;
    }

    public void updateEventList() throws IOException {
        objectMapper.writeValue(eventDB, eventList);
    }

    public void writeEvent(Event event) throws IOException {
        if(this.eventList == null) {
            this.jsonToPOJO();
        }
        this.eventList.add(event);
        this.updateEventList();
    }

    public void jsonToPOJO() throws IOException {
        this.eventList = new LinkedList<>(Arrays.asList(objectMapper.readValue(eventDB, Event[].class)));
    }

    public Event getEvent(String eventId) throws Exception {
        if(this.eventList == null) {
            this.jsonToPOJO();
        }
        for (Event event : this.eventList) {
            if (event.getEventId().equals(eventId)) {
                return event;
            }
        }
        throw new Exception("Event does not exist.");
    }

    public boolean deleteEvent(Event event) throws IOException {
        if(this.eventList == null) {
            this.jsonToPOJO();
        }
        for (Event e : this.eventList) {
            if (e.equals(event)) {
                this.eventList.remove(event);
                this.updateEventList();
                return true;
            }
        }
        return false;
    }

    public boolean replaceEvent(Event event) throws IOException {
        if(this.eventList == null) {
            this.jsonToPOJO();
        }
        for (Event e : this.eventList) {
            if (e.equals(event)) {
                this.eventList.set(this.eventList.indexOf(e), event);
                this.updateEventList();
                return true;
            }
        }
        return false;
    }
}