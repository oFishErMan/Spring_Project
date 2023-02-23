package com.CustomSoft.Mapper;


import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberMapper {
	public int nickCheck(String nick);

	public void join(Map<Object, Object> map) throws Exception;
	
}
