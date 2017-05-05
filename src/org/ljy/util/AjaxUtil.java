package org.ljy.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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

	/**
	 * 创建一个默认的HashMap<String,String>()
	 * @return ajaxMap
	 */
	public static Map<String,String> createDefaultAjaxMap(){
		return new HashMap<String,String>();
	}

	/**
	 * 返回状态码和一条信息给前端页面
	 * @param response
	 * @param status
	 * @param message
	 */
	public static void makeResponse(HttpServletResponse response,int status,String message){
		response.setCharacterEncoding("utf-8");
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("status", status);
			map.put("message", message);
			String responseStr = JSONObject.toJSONString(map);
			pw.write(responseStr);
		} catch (IOException e) {
			LOG.warn(e.getMessage(),e);
		}finally{
			pw.flush();
			pw.close();
		}
	}
	
	/**
	 * 返回状态码和JSONObject给前端页面
	 * @param response
	 * @param status
	 * @param jsonMessage
	 */
	public static void makeResponse(HttpServletResponse response,int status,JSONObject jsonMessage){
		response.setCharacterEncoding("utf-8");
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			String jsonStr = JSONObject.toJSONString(jsonMessage);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("status", status);
			map.put("message", jsonStr);
			String responseStr = JSONObject.toJSONString(map);
			pw.write(responseStr);
		} catch (IOException e) {
			LOG.warn(e.getMessage(),e);
		}finally{
			pw.flush();
			pw.close();
		}
	}

}
