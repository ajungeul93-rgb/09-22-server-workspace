package com.kh.java.cafeMember.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.cafeMember.model.dao.CafeMemberDao;
import com.kh.java.cafeMember.model.vo.CafeMember;
import com.kh.java.common.Template;

public class CafeMemberService {

	private CafeMemberDao cd = new CafeMemberDao();

	public CafeMember login(CafeMember member) {

		SqlSession sqlSession = Template.getSqlSession();

		CafeMember loginMember = cd.login(sqlSession,member);

		sqlSession.close();

		return loginMember;
	}

	public int join(CafeMember member) {

		SqlSession sqlSession = Template.getSqlSession();

		int result = cd.join(sqlSession, member);

        // 회원가입 성공 시 트랜잭션 커밋
        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

		return result;
	}
}