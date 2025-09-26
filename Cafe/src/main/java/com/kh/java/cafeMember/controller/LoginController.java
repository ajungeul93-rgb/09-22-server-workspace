package com.kh.java.cafeMember.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.java.cafeMember.model.service.CafeMemberService;
import com.kh.java.cafeMember.model.vo.CafeMember;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }

    /**
     * GET 요청 처리: 로그인 페이지로 단순 포워딩 (페이지 표시 역할)
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// GET 요청 시, 파라미터나 서비스 호출 없이 바로 로그인 페이지를 보여줍니다.
		request.getRequestDispatcher("/WEB-INF/views/common/login-page.jsp").forward(request, response);
	}

    /**
     * POST 요청 처리: 로그인 정보 검증 및 처리 (데이터 처리 역할)
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1. 인코딩 설정 (가장 먼저 실행)
		request.setCharacterEncoding("UTF-8");

        // 2. 파라미터 추출 (JSP의 name 속성인 "id", "password" 사용)
		String userId = request.getParameter("id");
		String userPwd = request.getParameter("password");

        // 3. VO에 담기
		CafeMember member = new CafeMember();
		member.setUserId(userId);
		member.setUserPwd(userPwd);

        // 4. Service 호출
		CafeMember loginMember = new CafeMemberService().login(member);

		if(loginMember != null) {
			// 5. 로그인 성공: 세션에 저장 후 메인 페이지로 리다이렉트
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", loginMember);

			// sendRedirect를 사용해야 URL이 /index.jsp로 바뀌며 메인 페이지로 이동합니다.
			response.sendRedirect(request.getContextPath() + "/index.jsp");

		} else {
			// 5. 로그인 실패: 메시지를 담아 로그인 페이지로 포워딩
			request.setAttribute("msg", "아이디 또는 비밀번호를 다시 확인해주세요.");
			request.getRequestDispatcher("/WEB-INF/views/common/login-page.jsp").forward(request, response);
		}
	}

}
