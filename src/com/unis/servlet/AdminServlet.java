package com.unis.servlet;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.unis.factory.ServiceFactory;
import com.unis.util.servlet.DispathcerServlet;
import com.unis.util.validate.ValidateUtils;
import com.unis.vo.CourseVO;
import com.unis.vo.SelectVO;
import com.unis.vo.StudentVO;

@WebServlet(urlPatterns = "/AdminServlet/*")
public class AdminServlet extends DispathcerServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7560860716903358100L;

	public String getStudentList() throws UnsupportedEncodingException {
		String st_name = request.getParameter("st_name");
		List<StudentVO> stuList = null;
		if (ValidateUtils.validateEmpty(st_name)) {
			st_name = new String(st_name.getBytes("ISO-8859-1"), "UTF-8");
			request.setAttribute("st_name", st_name);
			StudentVO vo = new StudentVO();
			vo.setSt_name(st_name);
			stuList = ServiceFactory.getIAdminServiceInstance()
					.getStudentListByName(vo);
		} else {
			stuList = ServiceFactory.getIAdminServiceInstance()
					.getStudentList();
		}

		if (stuList != null) {
			request.setAttribute("stuList", stuList);

		}
		return "/pages/admin/student_info.jsp";
	}

	public String getCourseList() throws UnsupportedEncodingException {

		String cs_name = request.getParameter("cs_name");
		List<CourseVO> csList = null;
		if (ValidateUtils.validateEmpty(cs_name)) {
			cs_name = new String(cs_name.getBytes("ISO-8859-1"), "UTF-8");
			request.setAttribute("cs_name", cs_name);
			CourseVO vo = new CourseVO();
			vo.setCourse_name(cs_name);
			csList = ServiceFactory.getIAdminServiceInstance().getCourseByName(
					vo);
		} else {
			csList = ServiceFactory.getIAdminServiceInstance().getCourseList();
		}

		if (csList != null) {
			request.setAttribute("csList", csList);
		}
		return "/pages/admin/course_manage.jsp";
	}

	/*public String addCourse() {
		CourseVO vo = new CourseVO();
		vo.setCourse_display(1);
	}*/
	
	public List<CourseVO> getCourseByName(CourseVO vo) {

		return com.unis.factory.DAOFactory.getICourseDAOInstance()
				.selectByName(vo);
	}

	public CourseVO getCourseById(CourseVO vo) {

		return com.unis.factory.DAOFactory.getICourseDAOInstance().selectById(
				vo);
	}

	

	public int deleteCourse(SelectVO vo) {
		return com.unis.factory.DAOFactory.getISelectDAOInstance()
				.delectSelect(vo);
	}

	public int updateCourse(CourseVO vo) {
		return com.unis.factory.DAOFactory.getICourseDAOInstance()
				.updateCourse(vo);
	}

	public List<SelectVO> getSelectList(SelectVO vo) {
		return com.unis.factory.DAOFactory.getISelectDAOInstance()
				.selectByCondition(vo);
	}
}
