package com.pracdev.emanager.controllers;

import com.pracdev.emanager.handlers.EventService;
import com.pracdev.emanager.utils.Event;
import com.pracdev.emanager.handlers.Profiler;
import com.pracdev.emanager.utils.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@RestController
public class EController{

    @Autowired
    @Qualifier("managerService") private EventService eventService;

    @RequestMapping(value = "/profile/{userName}", method = RequestMethod.GET)
    public UserProfile getUserProfile(@PathVariable String userName) throws IOException {
        return Profiler.getInstance().getProfile(userName);
    }

    @RequestMapping(value = "/addEvent/{eventName}/{eventDate}/{eventManager}/{eventLocation}", method = RequestMethod.POST)
    public String addEvent(@PathVariable String eventName, @PathVariable String eventDate,
                            @PathVariable String eventManager, @PathVariable String eventLocation) throws IOException {
        String eventId = eventService.addEvent(eventName, eventDate, eventManager, eventLocation);
        return eventId;
    }

    @RequestMapping(value = "/listEvents", method = RequestMethod.GET)
    public List<Event> listEvents() throws IOException {
        List<Event> eventList = eventService.listEvents();
        return eventList;
    }

    @RequestMapping(value = "/getEvent/{eventId}", method = RequestMethod.GET)
    public Event getEvent(@PathVariable String eventId) throws Exception {
        return eventService.getEvent(eventId);
    }

    @RequestMapping(value = "/rescheduleEvent/{eventId}/{newEventDate}", method = RequestMethod.POST)
    public boolean rescheduleEvent(@PathVariable String eventId, @PathVariable String newEventDate) throws IOException {
        return eventService.rescheduleEvent(eventId, newEventDate);
    }

    @RequestMapping(value = "/removeEvent/{eventId}", method = RequestMethod.POST)
    public boolean removeEvent(@PathVariable String eventId) throws IOException {
        return eventService.removeEvent(eventId);
    }
}
