package com.fleaMarket.loginRegister.action;

import java.io.IOException;
import java.io.PrintWriter;

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
import com.opensymphony.xwork2.ActionContext;
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
		System.out.println("222222"+newUser);
		String result = "";
		
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
			result = "error";
			System.out.println("B"+result);
			response.getWriter().write(result);
			response.getWriter().close();
			

		}
		else {
			session.setAttribute("user_session", user);
			System.out.println("b");
			result = "success";
			System.out.println("A"+result);
			response.getWriter().write(result);
			response.getWriter().close();
			 
		}
		
		return null;
		
	}
	
	//得到session的值
	public void getSes() throws IOException {
		 HttpSession session = ServletActionContext.getRequest().getSession();
		 GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.setPrettyPrinting();// 格式化json数据
			Gson gson = gsonBuilder.create();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(gson.toJson(session));
	}
	
//用户注册
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

	//跟据用户名得到用户
	public void getUserByUserName() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		response.setContentType("text/html;charset=utf-8");
		user user = loginRegisterService.getUserByUserName(newUser);
		response.getWriter().write(gson.toJson(user));
	}
	//用户退出登录
	public void logout() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setContentType("text/html;charset=utf-8");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		ActionContext.getContext().getSession().remove("user_session");
		System.out.println("执行退出=------");
		pw.write("logoutSuccess");
		
	}
}
