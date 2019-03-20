package com.unis.service;

import java.util.List;

import com.unis.vo.CourseVO;
import com.unis.vo.SelectVO;
import com.unis.vo.StudentVO;



public interface IStudentService {

	public int updateMyData(StudentVO vo);

	public List<CourseVO> getCourseList();

	public List<SelectVO> myCourseList(SelectVO vo);

	public int addCourse(SelectVO vo);

	public int deleteCourse(SelectVO vo);

	



}
