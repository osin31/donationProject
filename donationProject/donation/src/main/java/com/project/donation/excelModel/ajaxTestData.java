package com.project.donation.excelModel;

import java.util.List;

import lombok.Data;

@Data
public class ajaxTestData {

	private int totalCount;
	
	private String trkNm;
	
	private List<ajaxTestData> test;
	
	private String frstData;
	
	private String secdData;
	
	private String thrData;
	
	private String trkCnt;
	
	private String month;
	
	private String day;
	
	private String trkGn;
	
	private String trkNum;

	private String trkAddr;
	
	private String trkMsg;
	
	private String page;
}