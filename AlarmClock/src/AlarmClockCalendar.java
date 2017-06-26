import java.text.SimpleDateFormat;
import java.util.Calendar;


public class AlarmClockCalendar {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
	Calendar calendar; 
	
	/**
	 * class constructor--initializes calendar
	 */
	public AlarmClockCalendar()
	{
		calendar = Calendar.getInstance(); 
	}
	
	/**
	 * gets calendar reference
	 * @return
	 */
	public Calendar getAlarmClockCalendar()
	{
		return calendar;
	}
	
	/**
	 * gets current date-time
	 * @return
	 */
	public String getCurrentDateTime()
	{
		return sdf.format(calendar.getTime());
	}
	
}
