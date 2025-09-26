<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>

<link rel="stylesheet" href="resources/css/join.css">

</head>
<body>
<div class="register-container">
		<h2>카페 회원 가입</h2>
        <form action="#" method="post">

            <div class="input-group">
				<label for="user_id">아이디</label>
				<input type="text" id="user_id" name="user_id" maxlength="50" required>
			</div>

            <div class="input-group">
				<label for="user_pwd">비밀번호</label>
				<input type="password" id="user_pwd" name="user_pwd" required>
			</div>


            <hr>

            <div class="input-group">
				<label for="user_name">이름</label>
				<input type="text" id="user_name" name="user_name" maxlength="30" required>
			</div>

            <div class="input-group">
				<label for="phone">휴대폰 번호</label>
                <input type="text" id="phone" name="phone" maxlength="20" placeholder="예: 010-1234-5678" required>
			</div>

            <div class="input-group">
				<label for="email">이메일</label>
				<input type="email" id="email" name="email" maxlength="100" required>
			</div>

            <div class="input-group">
				<label for="birth_date">생년월일</label>
                <input type="date" id="birth_date" name="birth_date" required>
			</div>

			<button type="submit">가입하기</button>
            <p class="links">
                <a href="login">이미 계정이 있으신가요? (로그인)</a>
            </p>
		</form>
	</div>

</body>
</html>