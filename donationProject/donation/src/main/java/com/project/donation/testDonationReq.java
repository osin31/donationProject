package com.project.donation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testDonationReq {

	@RequestMapping("/")
	public String testDonation() {
		return "ㄴㄴ";
	}
}
