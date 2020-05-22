package com.project.donation.dao;

import java.util.List;

import com.project.donation.excelModel.ajaxTestData;

public interface DonationDAO {

	public List<ajaxTestData> selectData(ajaxTestData data) throws Exception;
}
