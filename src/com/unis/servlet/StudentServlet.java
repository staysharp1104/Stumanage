package com.unis.servlet;

import java.io.UnsupportedEncodingException;

import javax.servlet.annotation.WebServlet;

import com.unis.factory.ServiceFactory;
import com.unis.util.servlet.DispathcerServlet;
import com.unis.util.validate.ValidateUtils;
import com.unis.vo.StudentVO;

@WebServlet(urlPatterns = "/StudentServlet/*")
public class StudentServlet  extends DispathcerServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7182507382264527417L;

	public String getMyInfo() throws UnsupportedEncodingException{
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
