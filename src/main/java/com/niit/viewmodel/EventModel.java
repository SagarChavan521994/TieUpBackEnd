package com.niit.viewmodel;

import com.niit.model.Event;

public class EventModel {
	private Event event;
	private String calendar;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getCalendar() {
		return calendar;
	}

	public void setCalendar(String calendar) {
		this.calendar = calendar;
	}

}
