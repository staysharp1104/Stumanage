package com.unis.service.impl;

import com.unis.factory.DAOFactory;
import com.unis.service.IUserService;
import com.unis.vo.StudentVO;

public class UserServiceImpl implements IUserService {

	@Override
	public StudentVO userLogin(String uid, String pwd) {
		StudentVO uv = DAOFactory.getIStudentDAOInstance().userLogin(uid, pwd);
		return uv;
	}

	@Override
	public int userRegist(StudentVO vo) {

		return DAOFactory.getIStudentDAOInstance().userRegist(vo);
	}

}
