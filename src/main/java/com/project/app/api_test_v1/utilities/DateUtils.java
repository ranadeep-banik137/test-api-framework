package com.project.app.api_test_v1.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;

public class DateUtils {
	
	private Logger LOGGER = Logger.getLogger(DateUtils.class.getName());

	public DateUtils() {}
	
	public Calendar setCalenderDateFormat(final String date, final String dateFormat) {
		Calendar calendarObject = Calendar.getInstance();
		SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);
		try {
			calendarObject.setTime(dateFormatter.parse(date));
		} catch (ParseException exceptionObject) {
			LOGGER.info(exceptionObject.getMessage());
		}
		return calendarObject;
	}
	
	public boolean isWeekDay(final Calendar calendarObject) {
		int dayNum =  calendarObject.get(Calendar.DAY_OF_WEEK);
		return (dayNum == 1 || dayNum == 7) ? false : true;
	}
}
