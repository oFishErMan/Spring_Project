package com.CustomSoft.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CustomSoft.Mapper.JqgridMapper;
import com.CustomSoft.db.MemberDto;

@Service
public class JqgridService {
	@Autowired
	JqgridMapper mapper;

	public List<MemberDto> Jqgrid() {
		return mapper.Jqgrid();
	}
}
