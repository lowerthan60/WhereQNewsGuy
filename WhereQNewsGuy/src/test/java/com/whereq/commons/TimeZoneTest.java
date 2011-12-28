package com.whereq.commons;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.junit.Test;

public class TimeZoneTest {

	@Test
	public void timezoneTest() {
		String timeZoneCanada = null;
		String timeZone = null;
		// Time zone abbreviation: MST - Mountain Standard Time
		// Calgary
		timeZoneCanada = "Canada/Mountain";
		printTimeZone(timeZoneCanada);

		// Time zone abbreviation: PST - Pacific Standard Time
		// Vancouver
		timeZoneCanada = "Canada/Pacific";
		printTimeZone(timeZoneCanada);
		
		//Time zone abbreviation:	EST - Eastern Standard Time
		//Canada/Eastern
		timeZoneCanada = "Canada/Eastern";
		printTimeZone(timeZoneCanada);

	}

	private void printTimeZone(String timeZone) {
		GregorianCalendar calendar = new GregorianCalendar(
				TimeZone.getTimeZone(timeZone));
		String id = calendar.getTimeZone().getID();
		System.out.println("TimeZone：" + timeZone);
		System.out.println("TimeZone id:" + id);
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone(id));
		String DATE_FORMAT = "yyyy-MM-dd HH-mm-ss";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getTimeZone(id));
		System.out.println("Local Time：" + sdf.format(cal.getTime()));
	}

}
