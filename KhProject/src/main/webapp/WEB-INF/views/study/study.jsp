<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
</head>
<body>

	<h1>AJAX</h1>

	<h2>아주 중요!! 별이 다섯개! ★☆★☆★</h2>

	<pre>
		AJAX == Asynchronous JavaScript And XML

		"페이지를 새로고침 하지않고 서버와 데이터를 주고받을 수 있는 기술"
		"비동기 통신"

		우리가 그 동안 개발했던 방식은 동기방식

		동기방식 :
		1. 사용자가 버튼 클릭
		2. 서버가 요청을 받고 전체 HTML데이터를 응답
		3. 브라우저가 전체 페이지 다시 로딩 -> 깜빡임

		비동기방식 :
		1. 사용자가 버튼 클릭
		2. JavaScript를 이용해서 데이터만 서버로 띡 전송
		3. 서버는 JSON/XML 데이터만 응답
		4. JavaScript를 이용해서 필요한 부분만 갱신 -> 부드럽고, 빠름

		<hr>

		<h3>AJAX 장단점</h3>

		장점 : 사용자 경험(U.X) 향상
		      서버 부하 감소
		      네트워크 트래픽 절약
		      실시간성 구현 가능

	    단점 : SEO 취약
	    	  브라우저 히스토리 관리 복잡
	    	  JavaScript 의존성
	    	  보안 취약점 증가 (XSS)
	</pre>

	<pre>
		AJAX 사용방법

		1. XMLHttpRequest객체 사용하기
		2. JQuery사용해서 ajax 메소드 호출하기
		3. fetch API활용해서 fetch 호출하기
		4. React배울 때 Axios 라이브러리 설치해서 사용하기

	</pre>

	<pre>
		* jQuery를 사용한 AJAX 통신
		[ 표현법 ]

		// 자바스크립트에서 값 여러 개 다룰떄 ~

		$.ajax({
			속성명 : 값,
			속성명 : 값,
			속성명 : 값,
			...
		});

		* 주요 속성

		- url : 요청할 URL(필수로 작성) => form태그의 action속성
		- type : 요청 전송방식 (GET/POST ... FETCH, PUT, DELETE, OPTION...)
		        => form태그의 method속성
		- data : 오청 시 전달값 ({키 : 밸류, 키 : 밸류}) => form태그의 input요소 value값
		- success : 통신 성공 시 실행할 콜백함수를 정의
		-------------------------------------------------------------------------
		- error : 통신 실패 시 실행할 콜백함수를 정의
		- complete : 성공하든 실패하든 무조건 끝나면 실행할 콜백함수를 정의

	</pre>

</body>
</html>