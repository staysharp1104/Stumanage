package com.unis.factory;


import com.unis.service.IAdminService;
import com.unis.service.IStudentService;
import com.unis.service.IUserService;
import com.unis.service.impl.AdminServiceImpl;
import com.unis.service.impl.StudentServiceImpl;
import com.unis.service.impl.UserServiceImpl;



public class ServiceFactory {
	public static IUserService getIUserServiceInstance() {
		return new UserServiceImpl();
	}
	
	public static IStudentService getIStudentServiceInstance() {
		return new StudentServiceImpl();
	}
	
	public static IAdminService getIAdminServiceInstance() {
		return new AdminServiceImpl();
	}
}
