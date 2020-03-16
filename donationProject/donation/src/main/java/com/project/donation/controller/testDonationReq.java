package com.project.donation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testDonationReq {

	@RequestMapping(value="/")
	public String testDonation() {
		return "/test";
	}
}
