package com.project.donation.dao;

import java.util.List;

import com.project.donation.excelModel.ajaxTestData;

public interface BaseDonationDAO {

	public List<ajaxTestData> select(ajaxTestData ajaxTestData) throws Exception;
	
	public int insert(ajaxTestData ajaxTestData) throws Exception;

	public int update(ajaxTestData ajaxTestData) throws Exception;
	
	public int delete(ajaxTestData ajaxTestData) throws Exception;
}
