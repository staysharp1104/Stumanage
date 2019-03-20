package com.unis.service.impl;

import java.util.List;

import com.unis.factory.DAOFactory;
import com.unis.service.IStudentService;
import com.unis.vo.CourseVO;
import com.unis.vo.SelectVO;
import com.unis.vo.StudentVO;

public class StudentServiceImpl implements IStudentService{
	
	@Override
	public int updateMyData(StudentVO vo) {
		int result = DAOFactory.getIStudentDAOInstance().updateStudent(vo);
		return result;
	}

	@Override
	public List<CourseVO> getCourseList() {
		
		return DAOFactory.getICourseDAOInstance().selectAll();
	}
	
	@Override
	public List<SelectVO> myCourseList(SelectVO vo) {
		return DAOFactory.getISelectDAOInstance()
				.selectByCondition(vo);
	}
	
	@Override
	public int addCourse(SelectVO vo){
		return DAOFactory.getISelectDAOInstance().addSelect(vo);
	}
	
	@Override
	public int deleteCourse(SelectVO vo){
		return DAOFactory.getISelectDAOInstance().delectSelect(vo);
	}

	
	
	

}
