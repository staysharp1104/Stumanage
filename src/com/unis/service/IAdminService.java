package com.unis.service;

import java.util.List;

import com.unis.vo.CourseVO;
import com.unis.vo.SelectVO;
import com.unis.vo.StudentVO;

public interface IAdminService {


	public List<StudentVO> getStudentList();

	public List<StudentVO> getStudentListByName(StudentVO vo);

	public List<CourseVO> getCourseList();

	public List<CourseVO> getCourseByName(CourseVO vo);

	public CourseVO getCourseById(CourseVO vo);

	public int addCourse(SelectVO vo);

	public int deleteCourse(SelectVO vo);

	public int updateCourse(CourseVO vo);

	public List<SelectVO> getSelectList(SelectVO vo);

}
