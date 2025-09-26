package com.kh.java.cafeMember.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.cafeMember.model.vo.CafeMember;

public class CafeMemberDao {

	public CafeMember login(SqlSession sqlSession, CafeMember member) {
		// 매퍼의 <select id="login">을 호출
		return sqlSession.selectOne("cafeMemberMapper.login", member);
        // 참고: namespace가 cafeMemberMapper이므로, "login" 대신 "cafeMemberMapper.login"을 사용하는 것이 명시적이고 안전합니다.
	}

	public int join(SqlSession sqlSession, CafeMember member) {
		// 매퍼의 <insert id="join">을 호출
		return sqlSession.insert("cafeMemberMapper.join", member);
	}

}