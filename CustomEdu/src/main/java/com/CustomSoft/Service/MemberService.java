package com.CustomSoft.Service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CustomSoft.Mapper.MemberMapper;

import jakarta.servlet.http.HttpSession;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper mapper;

	//닉네임 중복 체크
	public int nickCheck(String nick) {
		int cnt = mapper.nickCheck(nick);
		return cnt;
	}

	//회원가입
	public void join(Map<Object, Object> map) throws Exception {
		mapper.join(map);
	}

	//로그인
	public int loginCheck(Map<Object, Object> map, HttpSession session) throws Exception {
		int cnt = mapper.loginCheck(map);
		return cnt;
	}
	//로그아웃
	public void logOut(HttpSession session) {
		session.invalidate();
	}

}
