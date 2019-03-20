package com.unis.service.impl;

import java.util.List;

import com.unis.factory.DAOFactory;
import com.unis.service.IAdminService;
import com.unis.vo.CourseVO;
import com.unis.vo.SelectVO;
import com.unis.vo.StudentVO;

public class AdminServiceImpl implements IAdminService{


	@Override
	public List<StudentVO> getStudentList() {

		return DAOFactory.getIStudentDAOInstance().selectAll();
	}

	@Override
	public List<StudentVO> getStudentListByName(StudentVO vo) {

		return DAOFactory.getIStudentDAOInstance()
				.selectByName(vo);
	}

	@Override
	public List<CourseVO> getCourseList() {

		return DAOFactory.getICourseDAOInstance().selectAll();
	}

	@Override
	public List<CourseVO> getCourseByName(CourseVO vo) {

		return DAOFactory.getICourseDAOInstance()
				.selectByName(vo);
	}

	@Override
	public CourseVO getCourseById(CourseVO vo) {

		return DAOFactory.getICourseDAOInstance().selectById(
				vo);
	}

	@Override
	public int addCourse(SelectVO vo) {
		return DAOFactory.getISelectDAOInstance()
				.addSelect(vo);
	}

	@Override
	public int deleteCourse(SelectVO vo) {
		return DAOFactory.getISelectDAOInstance()
				.delectSelect(vo);
	}

	@Override
	public int updateCourse(CourseVO vo) {
		return DAOFactory.getICourseDAOInstance()
				.updateCourse(vo);
	}

	@Override
	public List<SelectVO> getSelectList(SelectVO vo) {
		return DAOFactory.getISelectDAOInstance()
				.selectByCondition(vo);
	}
}
