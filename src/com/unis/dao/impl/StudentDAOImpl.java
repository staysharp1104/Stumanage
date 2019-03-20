package com.unis.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.unis.dao.IStudentDAO;
import com.unis.util.dbc.DatabaseConnection;
import com.unis.vo.StudentVO;


public class StudentDAOImpl implements IStudentDAO{

	QueryRunner qr = new QueryRunner(DatabaseConnection.getDataSource());
	@Override
	public StudentVO userLogin(String uid, String pwd) {
		StudentVO vo = null;
		String sql = "SELECT st_id,st_name,st_sex,st_birth,st_phone,st_password,st_flag FROM [test].[dbo].[mis_student] WHERE st_id=? AND st_password=? ";
		try {
			Object[] obj = {uid,pwd};
			vo = qr.query(sql, new BeanHandler<StudentVO>(StudentVO.class),obj);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return vo;
	
	}


	@Override
	public int userRegist(StudentVO vo) {
		int count=0;
		String sql = "INSERT INTO mis_student ([st_id],[st_name],[st_sex],[st_birth],[st_phone],[st_password],[st_flag],[st_display]) VALUES (?,?,?,?,?,?,?,?)";
		Object[] obj = {vo.getSt_id(),vo.getSt_name(),vo.getSt_sex(),vo.getSt_birth(),vo.getSt_phone(),vo.getSt_password(),0,1};
		try {
			count=qr.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public int updateStudent(StudentVO vo){
		int count=0;
		String sql = "UPDATE [test].[dbo].[mis_student]"
		                                   +" SET st_name = ?"
		                                    	     +" , st_sex = ?"
		                                    	     +" , st_birth = ?"
		                                    	     +" , st_phone = ?"
		                                    	     +" , st_password = ?"
		                                    	+" WHERE st_id = ?";
		Object[] obj = {vo.getSt_name(),vo.getSt_sex(),vo.getSt_birth(),vo.getSt_phone(),vo.getSt_password(),vo.getSt_id()};
		try {
			count=qr.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return count;
		
	}
	@Override
	public int delectStudent(StudentVO vo){
		int count=0;
		String sql = "UPDATE [test].[dbo].[mis_student]"
		                                   +" SET st_display = ?"
		                                    	+" WHERE st_id = ?";
		Object[] obj = {0,vo.getSt_id()};
		try {
			count=qr.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public List<StudentVO> selectAll(){
		List<StudentVO> list = new ArrayList<StudentVO>();
		String sql = "SELECT st_id"
		       +" ,st_name"
		       +" ,st_sex"
		       +" ,st_birth"
		       +" ,st_phone" +
		       ", st_flag"
		   +" FROM [test].[dbo].[mis_student] WHERE st_display=?";
		try {
			list = qr.query(sql, new BeanListHandler<StudentVO>(StudentVO.class),1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<StudentVO> selectByName(StudentVO vo){
		List<StudentVO> list = new ArrayList<StudentVO>();
		String sql = "SELECT st_id"
		       +" ,st_name"
		       +" ,st_sex"
		       +" ,st_birth"
		       +" ,st_phone"
		   +" FROM [test].[dbo].[mis_student] WHERE st_display=? and st_name=?";
		try {
			Object[] obj = {1,vo.getSt_name()};
			list = qr.query(sql, new BeanListHandler<StudentVO>(StudentVO.class),obj);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public StudentVO selectById(StudentVO vo){
		StudentVO myvo = new StudentVO();
		String sql = "SELECT st_id"
		       +" , st_name"
		       +" , st_sex"
		       +" , st_birth"
		       +" , st_phone"
		   +" FROM [test].[dbo].[mis_student]WHERE zw_display=? AND st_id=?";
		System.out.println(sql);
		Object[] obj = {1,vo.getSt_id()};
		try {
			myvo = qr.query(sql, new BeanHandler<StudentVO>(StudentVO.class),obj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myvo;
	}
}
