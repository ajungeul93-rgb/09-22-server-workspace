package com.kh.java.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogoutController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 로그아웃을 구현 해야함
		// 로그아웃이란 뭘까??
		// session의 userInfo라는 속성을 null이거나 지우거나
		//request.getSession().removeAttribute("userInfo");

		// session만료 시키는 방법 (== 무효화한다.)
		request.getSession().invalidate(); // session에 있는걸 다 날려버림
		request.getSession().setAttribute("alertMsg", "잘가쇼~");

		// 응답데이터 => 웰컴파일
		// sendRedirect()
		//System.out.println(request.getContextPath());
		request.setAttribute("alertMsg", "로그인에 성공~🎉🎉");
		response.sendRedirect(request.getContextPath());



	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
