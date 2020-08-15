package com.pracdev.emanager.handlers;

import com.pracdev.emanager.utils.DBManager;
import com.pracdev.emanager.utils.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Qualifier("managerService")
public class EventManager implements EventService {

    @Autowired
    private DBManager dbManager;
    private int eventCount = 0;

    @Override
    public String addEvent(String eventName, String eventDate, String eventManager, String eventLocation) throws IOException {
        String newEventId = this.getNewEventId();
        Event event = new Event(newEventId, eventName, eventDate, eventManager, eventLocation);
        dbManager.writeEvent(event);
        return newEventId;
    }

    @Override
    public List<Event> listEvents() throws IOException {
        return dbManager.getEventList();
    }

    @Override
    public Event getEvent(String eventId) throws Exception {
        return dbManager.getEvent( eventId);
    }

    @Override
    public boolean rescheduleEvent(String eventId, String newEventDate) throws IOException {
        try {
            Event event = dbManager.getEvent(eventId);
            event.setDate(newEventDate);
            return dbManager.replaceEvent(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeEvent(String eventId) throws IOException {
        try {
            Event event = dbManager.getEvent(eventId);
            return dbManager.deleteEvent(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getNewEventId() {
        return String.valueOf(++this.eventCount);
    }
}
