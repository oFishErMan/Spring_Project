package com.CustomSoft.Mapper;


import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberMapper {
	//회원가입 중 닉네임 중복체크
	public int nickCheck(String nick);

	//회원가입
	public void join(Map<Object, Object> map) throws Exception;
	
	//로그인
	public int loginCheck(Map<Object, Object> map) throws Exception;
	
}
