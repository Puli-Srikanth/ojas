package practice;

import java.util.Date;

public class ScreenShot_TimeBased {

	public static void main(String[] args) {
		String time = new Date().toString().replace(".", "_").replace(":", "_");
		System.out.println(time);
	}
}
