package com.example.demo.common;

import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.stereotype.Component;
//@Component
public final class ProjectTimeZone {

	  public static  DateTimeZone getProjectTimeZone() {

		  return DateTimeZone
                  .forTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));

	    }

	  public static  long getProjectTimeZoneCurrentMillis() {
	        return new DateTime(getProjectTimeZone()).getMillis();
	    }
}
