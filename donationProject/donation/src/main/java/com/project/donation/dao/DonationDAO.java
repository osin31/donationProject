package com.project.donation.dao;

import java.util.Map;

import com.project.donation.excelModel.ajaxTestData;

public interface DonationDAO {

	public Map<String, Object> selectData(ajaxTestData data) throws Exception;
}
