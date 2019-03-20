package com.unis.factory;



import com.unis.dao.ICourseDAO;
import com.unis.dao.ISelectDAO;
import com.unis.dao.IStudentDAO;
import com.unis.dao.impl.CourseDAOImpl;
import com.unis.dao.impl.SelectDAOImpl;
import com.unis.dao.impl.StudentDAOImpl;




public class DAOFactory {
	public static IStudentDAO getIStudentDAOInstance() {
		return new StudentDAOImpl();
	}
	
	public static ICourseDAO getICourseDAOInstance() {
		return new CourseDAOImpl();
	}
	
	public static ISelectDAO getISelectDAOInstance() {
		return new SelectDAOImpl();
	}
	
}
