package com.CustomSoft.Mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	public int nickCheck(String nick);
	
	
}
