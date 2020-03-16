package com.project.donation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/donation")
public class testDonationReq {

	@GetMapping(value="/test")
	public String testDonation() {
		return "/test";
	}
}
