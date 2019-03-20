package com.unis.dao;

import java.util.List;

import com.unis.vo.SelectVO;

public interface ISelectDAO {

	public int addSelect(SelectVO vo);

	public int delectSelect(SelectVO vo);

	public List<SelectVO> selectByCondition(SelectVO vo);
	

}
