package com.CustomSoft.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CustomSoft.Service.MemberService;

@Controller
public class MemberController {
	
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String Login() {
		// jsp 페이지 호출
		return "member/login";
	}
	
	
	
	@RequestMapping(value = "/signup", method=RequestMethod.GET)
	public String Signup() {
		// jsp 페이지 호출
		return "member/signup";
	}
	
	@Autowired
	private MemberService memberservice;
	
	@PostMapping("/nickCheck")
	@ResponseBody
	public int nickCheck(@RequestParam("nick") String nick) {
		int cnt = memberservice.nickCheck(nick);
		return cnt;
	}
	
//	@PostMapping("/join")
//	public String join() {
//		return null;
//	}

}
