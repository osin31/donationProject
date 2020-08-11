package com.project.donation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.project.donation.excelModel.ajaxTestData;
import com.project.donation.excelModel.locationData;
import com.project.donation.service.testDonationReqService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/donation")
public class testDonationReq {

	@Autowired
	private testDonationReqService service;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping(value = "/excelTest")
	public String testCreateUpload() {
		return "/test";
	}

	@GetMapping(value = "/main")
	public String testDonation() {
		return "/donationMain";
	}

	@PostMapping(value = "/uploadTest")
	@ResponseBody
	public Map<String, Object> testUploadTest(MultipartHttpServletRequest request) throws Exception {
		Map<String, Object> retrn = new HashMap();

		retrn = service.getUploadTest(request);
		//log.info("return Map Data >>>>>>>>>>>>>>>>>>>>>" + retrn.get("excelData"));
		return retrn;
	}

	@PostMapping(value = "/ajaxTestData")
	@ResponseBody
	public Map<String, Object> testAjax(ajaxTestData data) throws Exception {
		
		Map<String, Object> retrn = service.getTestAjax(data);

		return retrn;
	}
	
	@PostMapping(value = "/commonAjaxTest")
	@ResponseBody
	public Map<String , List<ajaxTestData>> ajaxTest(ajaxTestData data) throws Exception{

		Map<String , List<ajaxTestData>> newT = new HashMap<String , List<ajaxTestData>>();
		List<ajaxTestData> newS = service.ajaxTest(data);
		
		newT.put("clen", newS);
		return newT;
	}
	
	@PostMapping(value = "/mainLocation")
	@ResponseBody
	public Map<String , List<locationData>> mainLocation(locationData data) throws Exception{

		Map<String , List<locationData>> newT = new HashMap<String , List<locationData>>();
		List<locationData> newS = service.mainLocation(data);
		
		newT.put("clen", newS);
		return newT;
	}

}
