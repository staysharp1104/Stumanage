package com.unis.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.unis.dao.ISelectDAO;
import com.unis.util.dbc.DatabaseConnection;
import com.unis.util.validate.ValidateUtils;
import com.unis.vo.SelectVO;

public class SelectDAOImpl implements ISelectDAO{

	QueryRunner qr = new QueryRunner(DatabaseConnection.getDataSource());

	@Override
	public int addSelect(SelectVO vo) {
		int count = 0;
		String sql = "INSERT INTO [test].[dbo].[mis_select] (student_id,course_id) VALUES(?,?)";
		Object[] obj = { vo.getStudent_id(), vo.getCourse_id() };
		try {
			count = qr.update(sql, obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int delectSelect(SelectVO vo) {
		int count = 0;
		String sql = "delete from [test].[dbo].[mis_select]" + " WHERE select_id = ?";
		try {
			count = qr.update(sql, vo.getSelect_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<SelectVO> selectByCondition(SelectVO vo) {
		List<SelectVO> list = new ArrayList<SelectVO>();
		String sql = "SELECT c.select_id,c.student_id,a.st_name,c.course_id,b.course_name "
				+ "FROM [test].[dbo].[mis_student] a,[test].[dbo].[mis_course] b,[test].[dbo].[mis_select] c "
				+ "WHERE a.st_id=c.student_id and c.course_id=b.course_id ";
		
		if (ValidateUtils.validateEmpty(vo.getSt_name())) {
			sql += " and c.student_id=" + vo.getStudent_id();
		}
		if (ValidateUtils.validateEmpty(vo.getSt_name())) {
			sql += " and c.st_name=" + vo.getSt_name();
		}

		if (ValidateUtils.validateEmpty(vo.getCourse_name())) {
			sql += " and c.course_name=" + vo.getCourse_name();
		}

		try {
			list = qr.query(sql, new BeanListHandler<SelectVO>(SelectVO.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
