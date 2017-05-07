package org.ljy.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.ljy.common.Constants;
import org.ljy.common.JsonDateValueProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by ljy56 on 2017/5/6.
 */
public class BaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected final static String DATE_FORMATE = "yyyy-MM-dd";

    /**
     * 返回服务端处理结果
     * @param obj 服务端输出对象
     * @return 输出处理结果给前段JSON格式数据
     * @author YANGHONGXIA
     * @since 2015-01-06
     */
    public String responseResult(Object obj){
        JSONObject jsonObj = null;
        if(obj != null){
            logger.info("后端返回对象：{}", obj);
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
            jsonObj = JSONObject.fromObject(obj, jsonConfig);
            logger.info("后端返回数据：" + jsonObj);
            if(Constants.SERVICE_RESPONSE_SUCCESS_CODE.equals(jsonObj.getString(Constants.SERVICE_RESPONSE_RESULT_FLAG))){
                jsonObj.element(Constants.RESPONSE_RESULT_FLAG_ISERROR, false);
                jsonObj.element(Constants.SERVICE_RESPONSE_RESULT_MSG, "");
            }else{
                jsonObj.element(Constants.RESPONSE_RESULT_FLAG_ISERROR, true);
                String errMsg = jsonObj.getString(Constants.SERVICE_RESPONSE_RESULT_MSG);
                jsonObj.element(Constants.SERVICE_RESPONSE_RESULT_MSG, errMsg==null?Constants.SERVICE_RESPONSE_NULL:errMsg);
            }
        }
        logger.info("输出结果：{}", jsonObj.toString());
        return jsonObj.toString();
    }

    /**
     * 返回成功
     * @param obj 输出对象
     * @return 输出成功的JSON格式数据
     */
    public String responseSuccess(Object obj){
        JSONObject jsonObj = null;
        if(obj != null){
            logger.info("后端返回对象：{}", obj);
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
            jsonObj = JSONObject.fromObject(obj, jsonConfig);
            logger.info("后端返回数据：" + jsonObj);
            jsonObj.element(Constants.RESPONSE_RESULT_FLAG_ISERROR, false);
            jsonObj.element(Constants.SERVICE_RESPONSE_RESULT_MSG, "");
        }
        logger.info("输出结果：{}", jsonObj.toString());
        return jsonObj.toString();
    }

    /**
     * 返回成功
     * @param obj 输出对象
     * @return 输出成功的JSON格式数据
     */
    public String responseArraySuccess(Object obj){
        JSONArray jsonObj = null;
        if(obj != null){
            logger.info("后端返回对象：{}", obj);
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
            jsonObj = JSONArray.fromObject(obj, jsonConfig);
            logger.info("后端返回数据：" + jsonObj);
        }
        logger.info("输出结果：{}", jsonObj.toString());
        return jsonObj.toString();
    }

    /**
     * 返回成功
     * @param obj 输出对象
     * @return 输出成功的JSON格式数据
     */
    public String responseSuccess(Object obj, String msg){
        JSONObject jsonObj = null;
        if(obj != null){
            logger.info("后端返回对象：{}", obj);
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
            jsonObj = JSONObject.fromObject(obj, jsonConfig);
            logger.info("后端返回数据：" + jsonObj);
            jsonObj.element(Constants.RESPONSE_RESULT_FLAG_ISERROR, false);
            jsonObj.element(Constants.SERVICE_RESPONSE_RESULT_MSG, msg);
        }
        logger.info("输出结果：{}", jsonObj.toString());
        return jsonObj.toString();
    }

    /**
     * 返回失败
     * @param errorMsg 错误信息
     * @return 输出失败的JSON格式数据
     */
    public String responseFail(String errorMsg){
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(Constants.RESPONSE_RESULT_FLAG_ISERROR, true);
        jsonObj.put(Constants.SERVICE_RESPONSE_RESULT_MSG, errorMsg);
        logger.info("输出结果：{}", jsonObj.toString());
        return jsonObj.toString();
    }
}
