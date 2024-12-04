package autocom.common;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
	
	public static final String convertToDateStringByFormat(String format, LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        
        // Format the current date and time
        String formattedDateTime = date.format(formatter);
        return formattedDateTime;
	}
	
	public static final LocalDate convertToDateByFormat(String format, String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return LocalDate.parse(dateString, formatter);
	}
	
	
	public static final String getJson(Object object) {
		Gson gson = new Gson();
        String json = gson.toJson(object);
		return json;
	}
	
	public static final long tinhThanhTien(int soluong, long dongia) {
		return soluong * dongia;
	}
	
	public static final long tinhTienThue(int soluong, long dongia, int thueGTGT) {
		return (soluong*dongia*thueGTGT)/100;
	}
	
	public static final String formatLongToString(long value) {
		DecimalFormat df = new DecimalFormat("#,###,###");
        return df.format(value);
	}
	
	public static final long convertStringToLong(String value) {
		value = value.replaceAll("[^0-9]", "");
        if (value == "") return 0;
        return Long.parseLong(value);
	}
	
	public static final int convertStringToInt(String value) {
		value = value.replaceAll("[^0-9]", "");
		if (value == "") return 0;
        return Integer.parseInt(value);
	}
	
	public static final String convertNumberToTextVND(long total, String currency)
    {
        try
        {
            String rs = "";
            String[] ch = { "không", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín" };
            String[] rch = { "lẻ", "mốt", "", "", "", "lăm" };
            String[] u = { "", "mươi", "trăm", "nghìn", "", "", "triệu", "", "", "tỷ", "", "", "ngàn", "", "", "triệu" };
            String nstr = String.valueOf(total);
            long[] n = new long[nstr.length()];
            int len = n.length;
            for (int i = 0; i < len; i++)
            {
            	n[len - 1 - i] = Long.valueOf(nstr.substring(i, i+1));
            }
            for (int i = len - 1; i >= 0; i--)
            {
                if (i % 3 == 2)// số 0 ở hàng trăm
                {
                    if (n[i] == 0 && n[i - 1] == 0 && n[i - 2] == 0) continue;//nếu cả 3 số là 0 thì bỏ qua không đọc
                }
                else if (i % 3 == 1) // số ở hàng chục
                {
                    if (n[i] == 0)
                    {
                        if (n[i - 1] == 0) { continue; }// nếu hàng chục và hàng đơn vị đều là 0 thì bỏ qua.
                        else
                        {
                            rs += " " + rch[(int)n[i]]; continue;// hàng chục là 0 thì bỏ qua, đọc số hàng đơn vị
                        }
                    }
                    if (n[i] == 1)//nếu số hàng chục là 1 thì đọc là mười
                    {
                        rs += " mười"; continue;
                    }
                }
                else if (i != len - 1)// số ở hàng đơn vị (không phải là số đầu tiên)
                {
                    if (n[i] == 0)// số hàng đơn vị là 0 thì chỉ đọc đơn vị
                    {
                        if (i + 2 <= len - 1 && n[i + 2] == 0 && n[i + 1] == 0) continue;
                        rs += " " + (i % 3 == 0 ? u[i] : u[i % 3]);
                        continue;
                    }
                    if (n[i] == 1)// nếu là 1 thì tùy vào số hàng chục mà đọc: 0,1: một / còn lại: mốt
                    {
                        rs += " " + ((n[i + 1] == 1 || n[i + 1] == 0) ? ch[(int)n[i]] : rch[(int)n[i]]);
                        rs += " " + (i % 3 == 0 ? u[i] : u[i % 3]);
                        continue;
                    }
                    if (n[i] == 5) // cách đọc số 5
                    {
                        if (n[i + 1] != 0) //nếu số hàng chục khác 0 thì đọc số 5 là lăm
                        {
                            rs += " " + rch[(int)n[i]];// đọc số 
                            rs += " " + (i % 3 == 0 ? u[i] : u[i % 3]);// đọc đơn vị
                            continue;
                        }
                    }
                }
                rs += (rs == "" ? " " : ", ") + ch[(int)n[i]];// đọc số
                rs += " " + (i % 3 == 0 ? u[i] : u[i % 3]);// đọc đơn vị
            }
            if (rs.charAt(rs.length() - 1) != ' ')
                rs += " " + currency;
            else
                rs += currency;

            if (rs.length() > 2)
            {
                String rs1 = rs.substring(0, 2);
                rs1 = rs1.toUpperCase();
                rs = rs.substring(2);
                rs = rs1 + rs;
            }
            return rs.trim().replace(",", "");
        }
        catch(Exception ex)
        {
        	ex.printStackTrace();
            return "";
        }
    }

	public static final int convertMonthStringToInt(String monthName) {
		try {
			Date date = new SimpleDateFormat("MMMM", Locale.ENGLISH).parse(monthName);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			return cal.get(Calendar.MONTH) + 1;
		}catch(Exception ex)
        {
        	ex.printStackTrace();
            return 0;
        }
	}
	
	public static final String convertMonthIntToString(int num) {
		num = num - 1;
	    String month = "wrong";
	    DateFormatSymbols dfs = new DateFormatSymbols();
	    String[] months = dfs.getMonths();
	    if (num >= 0 && num <= 11) {
	        month = months[num];
	    }
	    return month;
	}
	
	public static final Date convertDate(int day, int month, int year) {
		Calendar calendar = Calendar.getInstance();
        
        // Set a specific date (Year, Month (0-based), Day, Hour, Minute, Second)
        calendar.set(year, month-1, day, 0, 0, 0);

        // Convert to Date
        Date specificDate = calendar.getTime();
        return specificDate;
	}
	
}
