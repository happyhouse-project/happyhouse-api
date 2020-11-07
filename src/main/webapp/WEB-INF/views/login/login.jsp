<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="../theme/library.jsp"/>
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <title>로그인</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css" />
  </head>
  
  <body>
    <div class="login-form">
      <form action="./loginProcess" method="post">
        <h2 class="text-center">로그인</h2>
        <div class="form-group">
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">
                <span class="fa fa-user"></span>
              </span>
            </div>
            <input
              type="email"
              class="form-control"
              name="email"
              placeholder="이메일을 입력해 주세요"
              required="required"
            />
          </div>
        </div>
        <div class="form-group">
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">
                <i class="fa fa-lock"></i>
              </span>
            </div>
            <input
              type="password"
              class="form-control"
              name="password"
              placeholder="비밀번호를 입력해 주세요"
              required="required"
            />
          </div>
        </div>
        <div class="form-group">
          <button type="submit" class="btn btn-primary login-btn btn-block">
            	로그인
          </button>
        </div>
        <div class="clearfix">
          <label class="float-left form-check-label"
            ><input type="checkbox" /> 아이디 저장
          </label>
          <a href="forgot_password.html" class="float-right">비밀번호 찾기</a>
        </div>
        <div class="or-seperator"><i>or</i></div>
        <p class="text-center">SNS 계정으로 로그인 하기</p>
        <div class="text-center social-btn">
          <a href="#" class="btn btn-secondary"
            ><i class="fa fa-facebook"></i>&nbsp; Facebook</a
          >
          <a href="#" class="btn btn-info"
            ><i class="fa fa-twitter"></i>&nbsp; Twitter</a
          >
          <a href="#" class="btn btn-danger"
            ><i class="fa fa-google"></i>&nbsp; Google</a
          >
        </div>
      </form>
      <p class="text-center small">
        계정이 없으신가요? <a href="./register">회원가입</a>
      </p>
    </div>
  </body>
</html>
