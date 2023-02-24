package com.CustomSoft.Service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CustomSoft.Mapper.MemberMapper;
import com.CustomSoft.db.dao.MemberDAO;
import com.CustomSoft.db.vo.MemberVO;

import jakarta.servlet.http.HttpSession;

@Service
@Transactional
public class MemberServiceImple implements MemberService {
	
	
	MemberDAO memberDao;
	
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

	@Override
	public boolean loginCheck(MemberVO vo, HttpSession session) {
		boolean result = memberDao.loginCheck(vo);
		if(result) {
			MemberVO vo2 = viewMember(vo);
			//세션 변수 등록
			session.setAttribute("custom_user_nick", vo2);
		}
		return result;
	}

	@Override
	public MemberVO viewMember(MemberVO vo) {
		return memberDao.viewMember(vo);
	}

	@Override
	public void logOut(HttpSession session) {
		session.invalidate();
	}
	
	
	
	
	/*
	 * @Override public MemberVO signIn(MemberVO vo) { mapper.signIn(vo); return vo;
	 * }
	 */
	
	
	

}
