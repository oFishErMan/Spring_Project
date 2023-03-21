package com.CustomSoft.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.CustomSoft.db.MemberDto;

@Mapper
public interface JqgridMapper {
	public List<MemberDto> Jqgrid();
}
