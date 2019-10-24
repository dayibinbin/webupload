package com.qiigame.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * 
 * weatherweb Maven Webapp
 *
 * Controller.java
 * 
 * 作者：陈海彬
 *
 * 日期：2015年5月5日 时间：下午4:28:48
 */
public class BaseController {
	private static final Log log = LogFactory.getLog(BaseController.class);
	

	public static final ObjectMapper mapper = new ObjectMapper();
	
	public String jsonResult(BaseResult result, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		String str = "";
		try {
			str = mapper.writeValueAsString(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ajax(str, "text/html", response);
	}
	
	// AJAX输出，返回null
	public String ajax(String content, String type, HttpServletResponse response) {
		try {
			response.setContentType(type + ";charset=UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.getWriter().write(content);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	// josn输出，返回null
    public void returnTextString(HttpServletResponse response, String content) {
        try {
        	response.setContentType("text/plain;charset=UTF-8");
    		response.setCharacterEncoding("UTF-8"); 
    		PrintWriter out=response.getWriter();	     		
    		out.print(content);
    		out.flush();
    		out.close();
        }
        catch (Exception e) {
        	log.error("",e);
            e.printStackTrace();
        }      
    }
    
    // josn输出，返回null
    public void returnJosnString(HttpServletResponse response, String content) {
        try {
        	response.setContentType("application/json;charset=UTF-8");
    		response.setCharacterEncoding("UTF-8"); 
    		PrintWriter out=response.getWriter();	     		
    		out.print(content);
    		out.flush();
    		out.close();
        }
        catch (Exception e) {
        	log.error("",e);
            e.printStackTrace();
        }      
    }
	 
     // josn输出，返回null 
    public void returnJosnInt(HttpServletResponse response, int content) {
        try {
        	response.setContentType("application/json;charset=UTF-8");
    		response.setCharacterEncoding("UTF-8");
    		PrintWriter out=response.getWriter();	    		
    		out.print(content);
    		out.flush();
    		out.close();
        }
        catch (Exception e) {
        	log.error("",e);
            e.printStackTrace();
        }      
    }
    

	public String convertToJson(Object obj){
		String str = "";
		try{
			str = mapper.writeValueAsString(obj);
		}catch(Exception e){
			
		}
		return str;
	}
}
