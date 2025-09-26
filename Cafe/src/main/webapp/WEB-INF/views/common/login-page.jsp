<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<link rel="stylesheet" href="resources/css/login.css">

</head>
<body>

	<div class="login-container">
		<h2>로그인</h2>
		<form action="login" method="post">
			<div class="input-group">
				<label for="id">ID</label>
				<input type="text" id="id" name="id" required>
			</div>
			<div class="input-group">
				<label for="password">Password</label> <input type="password" id="password" name="password" required>
			</div>
			<button type="submit">로그인</button>
			<div class="lnks">
				<a href="join">회원가입</a>
				<span>|</span>
				<a href="#">비밀번호 찾기</a>
			</div>
		</form>
	</div>

    <%
    	String msg = (String)request.getAttribute("msg");
    	if(msg != null) {
    %>
    <script>
        alert('<%= msg %>');
    </script>
    <%
    	}
    %>

</body>
</html>