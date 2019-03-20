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
		super.request.getSession().invalidate(); // ��sessionʧЧ
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
					//msg = "�������ӳɹ���";
					return "/success.jsp";
				}else {
					msg = "�û�����ʧ�ܣ�";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			}else {
				msg = "����Ա���ݲ���Ϊ�գ�";
			}
		super.request.setAttribute("msg", msg);
		super.request.setAttribute("url", "/register.jsp");
		return "/pages/forward.jsp";
	}
}
