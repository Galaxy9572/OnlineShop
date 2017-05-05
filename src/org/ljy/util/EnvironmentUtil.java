package org.ljy.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EnvironmentUtil {
	private SimpleDateFormat sdf;
	private Date date;
	public EnvironmentUtil() {
		sdf=new SimpleDateFormat("yyyy-MM-dd");
		date=new Date();
	}
	
	/**
	 * 获得当前的日期 yyyy-MM-dd
	 * @return yyyy-MM-dd
	 */
	public String getDate(){
		return sdf.format(date);
	}
	
}
