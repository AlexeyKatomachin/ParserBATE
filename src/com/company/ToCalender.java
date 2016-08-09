package com.company;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;

import java.io.IOException;

public class ToCalender {

    public void ToCalender(String describe, String comand2) throws IOException {

        Event event = new Event()
                .setSummary("FCBATE - " + comand2)
                .setLocation("Borisov")
                .setDescription(describe);

        DateTime startDateTime = new DateTime("2016-" + "09" + "-" + "09" + "T09:" + "00:00" + "-" + "07:00");
        EventDateTime start = new EventDateTime()
                .setDateTime(startDateTime)
                .setTimeZone("America/Los_Angeles");
        event.setStart(start);

        DateTime endDateTime = new DateTime("2016-" + "09" + "-" + "09" + "T09:" + "00:00" + "-" + "07:00");
        EventDateTime end = new EventDateTime()
                .setDateTime(endDateTime)
                .setTimeZone("America/Los_Angeles");
        event.setEnd(end);
        addEvent(Autorize.getCalendarService(), Autorize.calendarID, event);
    }

    public String addEvent(Calendar service, String calendarId, Event event) throws IOException {
        String ret = "";
        DateTime now = new DateTime(System.currentTimeMillis());
        event = service.events().insert(calendarId, event).execute();
        return ret = "Event created: %s\n" + event.getHtmlLink();
    }
}


