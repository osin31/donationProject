package com.project.donation.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.project.donation.service.testDonationReqService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping(value="/donation")
public class testDonationReq {

	@Autowired
	testDonationReqService service = new testDonationReqService();
	
	@GetMapping(value="/excelTest")
	public String testCreateUpload() {
		return "/test";
	}
	
	@GetMapping(value="/main")
	public String testDonation() {
		return "/donationMain";
	}
	
	@PostMapping(value="/uploadTest")
	@ResponseBody
	public Map<String, Object> testUploadTest(MultipartHttpServletRequest request) throws Exception {
		Map<String, Object> retrn = new HashMap();
		
		retrn = service.getUploadTest(request);
		log.info("return Map Data >>>>>>>>>>>>>>>>>>>>>" + retrn.get("excelData"));
		return retrn;
	}
	
}
