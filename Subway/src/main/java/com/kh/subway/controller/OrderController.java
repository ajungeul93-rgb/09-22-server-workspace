package com.kh.subway.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.subway.model.service.SubwayService;
import com.kh.subway.model.vo.Subway;

@WebServlet("/order.do")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 0) 요청 전송 방식이 뭐지?
		// GET / POST

		// 1) 요청 시 전달값이 있는가?
		// => 값 뽑기
		// request.getParameter("키값")
		// request.getParameterValue("키캆")

		// 값을 뽑아서 변수에 대입
		// 주문자 정보
		String name = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String message = request.getParameter("message");

		// 주문 정보
		String sandwich = request.getParameter("sandwich");
		String[] vegetable = request.getParameterValues("vegetable");
		String[] sauce = request.getParameterValues("sauce");
		String[] cookie = request.getParameterValues("cookie");
		String payment = request.getParameter("payment");

		// 2) 가공 -> VO클래스를 객체로 생성해서 필드에 담기

		Subway order = new Subway();
		order.setName(name);
		order.setPhone(phone);
		order.setAddress(address);
		order.setRequest(message);
		order.setSandwich(sandwich);
		order.setVegetable(vegetable != null ? String.join(",", vegetable) : "선택안함");
		order.setCookie(cookie != null ? String.join(",", cookie) : "선택안함");
		order.setSauce(sauce != null ? String.join(",", sauce) : "선택안함");
		order.setPayment(payment != null ? String.join(",", payment) : "선택안함");

		//System.out.println(order);

		// 3) 요청 처리
		int result = new SubwayService().insertOrder(order);

		if(result > 0) {
			response.getWriter().append("succes~ ;)");
		} else {
			response.getWriter().append("fail ;ㅆ;");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
