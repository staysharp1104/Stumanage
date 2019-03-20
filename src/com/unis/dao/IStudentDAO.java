package com.unis.dao;

import java.util.List;

import com.unis.vo.StudentVO;

public interface IStudentDAO {

	public StudentVO userLogin(String uid, String pwd);

	public int userRegist(StudentVO vo);

	public int updateStudent(StudentVO vo);

	public int delectStudent(StudentVO vo);

	public List<StudentVO> selectAll();
	public List<StudentVO> selectByName(StudentVO vo);
	public StudentVO selectById(StudentVO vo);

}
