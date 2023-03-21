package com.CustomSoft.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CustomSoft.Service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberservice;
	
	// jsp 페이지 호출
	@RequestMapping(value = "login", method = { RequestMethod.GET, RequestMethod.POST })
	public String Login() {
		return "member/login";
	}

	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public String Signup() {
		return "member/signup";
	}
	//==========================기능========================================//
	
	
	//회원가입
	@PostMapping("join")
	@ResponseBody
	public void join(@RequestBody Map<Object, Object> map) throws Exception {
		memberservice.join(map);
	}
	
	//실시간 닉네임 중복 확인
	@PostMapping("nickCheck")
	@ResponseBody
	public int nickCheck(@RequestParam("nick") String nick) {
		int cnt = memberservice.nickCheck(nick);
		return cnt;
	}

	
	//로그인
	@GetMapping("signIn")
	@ResponseBody
	public int loginCheck(@RequestParam Map<Object, Object> map, HttpSession session) throws Exception {
		/* boolean result = MemberService. */
		int cnt = memberservice.loginCheck(map, session);
		if (cnt == 1) {
			session.setAttribute("custom_user_email", map.get("custom_user_email"));
		}
		return cnt;
	}
	
	// 로그아웃
	@RequestMapping("logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/member/login";
	}

}
