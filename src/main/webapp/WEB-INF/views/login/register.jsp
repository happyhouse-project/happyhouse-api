<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../theme/library.jsp" />
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/register.css" />	
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:400,700" />
<title>회원 가입</title>
</head>
<body>
	<div class="signup-form">
		<form action="./registerProcess" method="post">
			<h2>Register</h2>
			<p class="hint-text">간단한 정보만으로도 회원가입을 할 수 있습니다.</p>
			<div class="form-group">
				<input type="email" class="form-control" name="email"
					placeholder="이메일 주소" required="required" />
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="name"
					placeholder="이름" required="required" />
			</div>

			<div class="form-group">
				<input type="password" class="form-control" name="password"
					placeholder="비밀번호" required="required" />
			</div>
			<div class="form-group">
				<input type="password" class="form-control" name="confirm_password"
					placeholder="비밀번호 재입력" required="required" />
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="phone"
					placeholder="전화번호" required="required" />
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="address"
					placeholder="주소" required="required" />
			</div>
			<div class="form-group">
				<label class="form-check-label"><input
					type="checkbox" required="required" /> 회원가입 시 <a href="#">Terms
						of Use</a> &amp; <a href="#">Privacy Policy</a> 를 동의합니다 </label>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-success btn-lg btn-block">
					회원 가입</button>
			</div>
		</form>
		<div class="text-center">
			이미 계정이 있다면 <a href="./login">로그인</a>
		</div>
	</div>
</body>
</html>
