package com.unis.servlet;


import java.io.UnsupportedEncodingException;

import javax.servlet.annotation.WebServlet;


import com.unis.factory.ServiceFactory;

import com.unis.util.servlet.DispathcerServlet;
import com.unis.util.validate.ValidateUtils;
import com.unis.vo.StudentVO;


@WebServlet(urlPatterns = "/UserServlet/*")
public class UserServlet extends DispathcerServlet {

	private static final long serialVersionUID = -1384487409177509742L;

	//登陆
	public String login() {
		super.request.getSession().invalidate(); // 让session失效
		String msg = "";
		String url = "";
		String uid = super.request.getParameter("userid");
		String password = super.request.getParameter("password");
		if (ValidateUtils.validateEmpty(uid)
				&& ValidateUtils.validateEmpty(password)) {
			StudentVO vo = null;
			try {
				vo = ServiceFactory.getIUserServiceInstance().userLogin(uid,
						password);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (vo != null) {				
				if(vo.getSt_flag()==1){
					super.request.getSession().setAttribute("admin", vo);
					msg = "管理员登录成功！";
					url = "/AdminServlet/getStudentList";
				}else if(vo.getSt_flag()==0){
					super.request.getSession().setAttribute("student", vo);
					msg = "学生登录成功！";
					url = "/index.jsp";
				}else{
					msg = "用户名或密码错误！";
					url = "/login.jsp";
				}
			} else {
				msg = "用户名或密码错误！";
				url = "/login.jsp";
			}
		} else {
			msg = "密码或用户名不能为空！";
			url = "/login.jsp";
		}
		super.request.setAttribute("msg", msg);
		super.request.setAttribute("url", url);
		return "/pages/forward.jsp";
	}

	public String regist() throws UnsupportedEncodingException{
		super.request.getSession().invalidate(); // 让session失效
		String msg = "";
		String userid = request.getParameter("userid");
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		String password = request.getParameter("password");
		if(ValidateUtils.validateEmpty(userid) && 
				ValidateUtils.validateEmpty(name)
				&& ValidateUtils.validateEmpty(password)){
				
			StudentVO vo = new StudentVO();
			vo.setSt_id(userid);
			vo.setSt_name(name);
			vo.setSt_password(password);
			try {
				System.out.println(name+"------");
				if(ServiceFactory.getIUserServiceInstance().userRegist(vo)>0) {					
					super.request.setAttribute("registerName", name);
					//msg = "数据增加成功！";
					return "/success.jsp";
				}else {
					msg = "用户增加失败！";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			}else {
				msg = "管理员数据不能为空！";
			}
		super.request.setAttribute("msg", msg);
		super.request.setAttribute("url", "/register.jsp");
		return "/pages/forward.jsp";
	}

}
