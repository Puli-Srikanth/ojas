package practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Date$Time {

	public static void main(String[] args) {
		
	Date d = new Date();
	System.out.println(d);
	
	SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
	String s = sim.format(d);
	System.out.println(s);
	
	Calendar c = sim.getCalendar();
	c.add(Calendar.DAY_OF_MONTH,30);
	String da = sim.format(c.getTime());
	System.out.println(da);
	
	}
}
