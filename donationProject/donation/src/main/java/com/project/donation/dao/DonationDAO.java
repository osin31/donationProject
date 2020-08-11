package com.project.donation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.donation.excelModel.ajaxTestData;
import com.project.donation.excelModel.ajaxTestDatas;
import com.project.donation.excelModel.locationData;

@Mapper
public interface DonationDAO extends BaseDonationDAO{

	//
	public List<ajaxTestData> selectData(ajaxTestData trkNm) throws Exception;

	
	public List<ajaxTestDatas> selectDatas(String trkNm) throws Exception;
	
	public List<ajaxTestData> ajaxTest(ajaxTestData data) throws Exception;
	
	public List<locationData> mainLocation(locationData data) throws Exception;

}
