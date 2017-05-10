package org.ljy.util;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class AjaxUtil{
	private static Logger LOG = Logger.getLogger(AjaxUtil.class);
	/**
	 * 成功，1
	 */
	public static int SUCCESS=1;
	/**
	 * 失败，0
	 */
	public static int FAILURE=0;

	public static Map<String,String> generateResponseAjax(String status,String msg){
		Map<String,String> ajaxMap = new HashMap<String,String>();
		ajaxMap.put("status",status);
		ajaxMap.put("msg",msg);
		return ajaxMap;
	}
}
