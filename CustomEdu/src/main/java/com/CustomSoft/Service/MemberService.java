package com.CustomSoft.Service;

import java.util.Map;

import com.CustomSoft.db.vo.MemberVO;

import jakarta.servlet.http.HttpSession;


public interface MemberService {
	public int nickCheck(String nick);
	
	public void join(Map<Object, Object> map) throws Exception;
		
	
	public MemberVO viewMember(MemberVO vo);

	boolean loginCheck(MemberVO vo, HttpSession session);	
	
	public void logOut(HttpSession session);
	
}
