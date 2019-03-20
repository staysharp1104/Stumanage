package com.unis.service;

import com.unis.vo.StudentVO;

public interface IUserService {
	public StudentVO userLogin(String uid, String pwd);

	public int userRegist(StudentVO vo);
}
