package com.vtiger.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtlity {

	public int getRandomNumber() {

	Random random=new Random();
	int randomNum=random.nextInt(999);
	return randomNum;
	}
	
	public String getSystemDate() {
		Date d=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		String date=sd.format(d);
		
		return date;
		
	}
	
	public String getRequireddate(int days) {
		Date d=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		sd.format(d);
		Calendar calendar = sd.getCalendar();
		calendar.add(Calendar.DAY_OF_MONTH,days);
		String reqDate=sd.format(calendar.getTime());
		return reqDate;
	}
}
