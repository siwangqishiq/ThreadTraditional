package com.xinlan.traditional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateDemos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String lastModifyTime ="Fri, 01 Nov 2013 02:57:42 GMT";
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss", Locale.US);
	    try {
			Date lastModifyDate = sdf
					.parse(lastModifyTime);
			System.out.println(lastModifyDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
