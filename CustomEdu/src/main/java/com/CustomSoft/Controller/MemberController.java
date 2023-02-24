package com.CustomSoft.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CustomSoft.Mapper.MemberMapper;
import com.CustomSoft.Service.MemberService;
import com.CustomSoft.db.vo.MemberVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	

	
	MemberVO member ;
	
	@Autowired
	private MemberService memberservice;
	
	@Autowired
	private MemberMapper membermapper;
	
	@RequestMapping(value = "login", method= {RequestMethod.GET, RequestMethod.POST})
	public String Login() {
		// jsp 페이지 호출
		return "member/login";
	}
	
	
	
	@RequestMapping(value = "signup", method=RequestMethod.GET)
	public String Signup() {
		// jsp 페이지 호출
		return "member/signup";
	}
	
	
	
	@PostMapping("nickCheck")
	@ResponseBody
	public int nickCheck(@RequestParam("nick") String nick) {
		int cnt = memberservice.nickCheck(nick);
		return cnt;
	}
	
	@PostMapping("signIn")
	public String loginCheck(MemberVO vo, HttpServletRequest req) {
		
		/* boolean result = MemberService. */
		HttpSession session = req.getSession();
		MemberVO signIn = membermapper.signIn(vo);
		if (signIn != null) {
			session.setAttribute("signIn", signIn);
			return "redirect:/index";
		} else {
			session.setAttribute("signIn", null);
			return "redirect:/login";
		}
	}
	
	@RequestMapping("logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	


}
