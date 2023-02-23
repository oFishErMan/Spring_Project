package com.CustomSoft.Service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CustomSoft.Mapper.MemberMapper;

@Service
@Transactional
public class MemberServiceImple implements MemberService {

	@Autowired
	private MemberMapper mapper;

	@Override
	public int nickCheck(String nick) {
		int cnt = mapper.nickCheck(nick);
		return cnt;
	}

	@Override
	public void join(Map<Object, Object> map) throws Exception {
		int i =0;
		System.out.println("service");

		mapper.join(map);
		//return i;
	}
	

}
