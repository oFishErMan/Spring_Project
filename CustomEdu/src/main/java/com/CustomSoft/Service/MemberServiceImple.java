package com.CustomSoft.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CustomSoft.Mapper.MemberMapper;

@Service
public class MemberServiceImple implements MemberService {

	@Autowired
	private MemberMapper mapper;

	@Override
	public int nickCheck(String nick) {
		int cnt = mapper.nickCheck(nick);
		return cnt;
	}

}
