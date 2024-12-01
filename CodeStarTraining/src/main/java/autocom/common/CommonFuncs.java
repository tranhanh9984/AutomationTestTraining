package autocom.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import com.google.gson.Gson;

public class CommonFuncs {
	/**
	 * get datetime
	 * 
	 * @param format
	 */
	public static final String getDateTime(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		String dateTime = dateFormat.format(cal.getTime());
		return dateTime;
	}
	
	public static final String getDateByFormat(String format, LocalDateTime date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        
        // Format the current date and time
        String formattedDateTime = date.format(formatter);
        return formattedDateTime;
	}
	
	
	public static final String getJson(Object object) {
		Gson gson = new Gson();
        String json = gson.toJson(object);
		return json;
	}
}
