package com.pracdev.emanager.handlers;

import com.pracdev.emanager.utils.Event;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

public interface EventService {

    public String addEvent(String eventName, String eventDate, String eventManager, String eventLocation) throws IOException;

    public List<Event> listEvents() throws IOException;

    public Event getEvent(String eventId) throws Exception;

    public boolean rescheduleEvent(String eventId, String newEventDate) throws IOException;

    public boolean removeEvent(String eventId) throws IOException;

    public String getNewEventId();
}
