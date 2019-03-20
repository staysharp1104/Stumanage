package com.unis.dao;

import java.util.List;

import com.unis.vo.CourseVO;

public interface ICourseDAO {

	public int addCourse(CourseVO vo);

	public int updateCourse(CourseVO vo);

	public int delectCourse(CourseVO vo);

	public List<CourseVO> selectAll();

	public List<CourseVO> selectByName(CourseVO vo);

	public CourseVO selectById(CourseVO vo);

}
