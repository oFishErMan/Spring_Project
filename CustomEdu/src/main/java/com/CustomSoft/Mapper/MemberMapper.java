package com.CustomSoft.Mapper;


import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.CustomSoft.db.vo.MemberVO;


@Mapper
public interface MemberMapper {
	public int nickCheck(String nick);

	public void join(Map<Object, Object> map) throws Exception;
	
	public MemberVO signIn(MemberVO vo);
	
}
