package autocom.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CommonFuncs {
	/**
	 * get datetime
	 * 
	 * @param format
	 */
	public String getDateTime(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		String dateTime = dateFormat.format(cal.getTime());
		return dateTime;
	}
	
}
