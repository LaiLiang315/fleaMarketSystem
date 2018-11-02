package com.fleaMarket.loginRegister.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.fleaMarket.domain.user;
import com.fleaMarket.loginRegister.service.LoginRegisterService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 登陆注册的Action层
 * 
 * @author LL
 *
 */
public class LoginRegisterAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	/**
	 * service层注入
	 */
	private LoginRegisterService loginRegisterService;

	public LoginRegisterService getLoginRegisterService() {
		return loginRegisterService;
	}

	public void setLoginRegisterService(LoginRegisterService loginRegisterService) {
		this.loginRegisterService = loginRegisterService;
	}

	private user newUser;

	public user getNewUser() {
		return newUser;
	}

	public void setNewUser(user newUser) {
		this.newUser = newUser;
	}

	/**
	 * 实现request和response
	 */
	private HttpServletResponse response;

	private HttpServletRequest request;

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * 实现结束
	 */
	/**
	 * 登陆
	 * 
	 * @throws IOException
	 */
	public String login() throws IOException {
		System.out.println("222222");
	/*	String result = "";*/
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		response.setContentType("text/html;charset=utf-8");
		/**
		 * 设置session
		 */
		HttpSession session = ServletActionContext.getRequest().getSession();
		/**
		 * 得到service层返回的对象
		 */
		user user = loginRegisterService.login(newUser);
		if (user == null) {
			System.out.println("a");
			/*result = "error";
			response.getWriter().write(result);
			response.getWriter().close();*/
			return "fail";

		}
		else {
			session.setAttribute("user_session", session);
			System.out.println("b");
			/*result = "success";
			response.getWriter().write(result);
			response.getWriter().close();*/
			return "ok"; 
		}
		
	}

	public String userRegister() {
		System.out.println("fd"); 
		String result = "";
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		response.setContentType("text/html;charset=utf-8");
		user user = loginRegisterService.userRegister(newUser);
		if(user==null) {
			result = "注册成功";
			return "login";
			
		}else {
			result ="该用户已存在";
		}
		return result;
		
		
		
		/*try {
			response.getWriter().write("" + loginRegisterService.userRegister(newUser));
		result = loginRegisterService.userRegister2(newUser);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
