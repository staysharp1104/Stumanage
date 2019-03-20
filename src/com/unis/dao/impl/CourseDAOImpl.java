package com.unis.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.unis.dao.ICourseDAO;
import com.unis.util.dbc.DatabaseConnection;
import com.unis.vo.CourseVO;


public class CourseDAOImpl implements ICourseDAO{
	QueryRunner qr = new QueryRunner(DatabaseConnection.getDataSource());


	@Override
	public int addCourse(CourseVO vo) {
		int count=0;
		String sql = "INSERT INTO [test].[dbo].[mis_course] (course_name,course_mode,course_credit,course_display) VALUES(?,?,?,?)";
		Object[] obj = {vo.getCourse_name(),vo.getCourse_mode(),vo.getCourse_credit(),1};
		try {
			count=qr.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public int updateCourse(CourseVO vo){
		int count=0;
		String sql = "UPDATE [test].[dbo].[mis_course]"
		                                   +" SET course_name = ?"
		                                    	     +" , course_mode = ?"
		                                    	     +" , course_credit = ?"
		                                    	+" WHERE course_id = ?";
		Object[] obj = {vo.getCourse_name(),vo.getCourse_mode(),vo.getCourse_credit(),vo.getCourse_id()};
		try {
			count=qr.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return count;
		
	}
	
	@Override
	public int delectCourse(CourseVO vo){
		int count=0;
		String sql = "UPDATE [test].[dbo].[mis_course]"
		                                   +" SET course_display = ?"
		                                    	+" WHERE st_id = ?";
		Object[] obj = {0,vo.getCourse_id()};
		try {
			count=qr.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public List<CourseVO> selectAll(){
		List<CourseVO> list = new ArrayList<CourseVO>();
		String sql = "SELECT course_id"
		       +" ,course_name"
		       +" ,course_mode"
		       +" ,course_credit"
		       +" ,course_display"
		   +" FROM [test].[dbo].[mis_course] WHERE course_display=?";
		try {
			list = qr.query(sql, new BeanListHandler<CourseVO>(CourseVO.class),1);
		} catch (SQLException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<CourseVO> selectByName(CourseVO vo){
		List<CourseVO> list = new ArrayList<CourseVO>();
		String sql = "SELECT course_id"
		       +" ,course_name"
		       +" ,course_mode"
		       +" ,course_credit"
		   +" FROM [test].[dbo].[mis_course] WHERE course_display=? and course_name like ?";
		try {
			Object[] obj = {1,vo.getCourse_name()};
			list = qr.query(sql, new BeanListHandler<CourseVO>(CourseVO.class),obj);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public CourseVO selectById(CourseVO vo){
		CourseVO myvo = new CourseVO();
		String sql = "SELECT course_id"
			       +" ,course_name"
			       +" ,course_mode"
			       +" ,course_credit"
			   +" FROM [test].[dbo].[mis_course] WHERE st_display=? and course_id=?";
		Object[] obj = {1,vo.getCourse_id()};
		try {
			myvo = qr.query(sql, new BeanHandler<CourseVO>(CourseVO.class),obj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myvo;
	}
}
