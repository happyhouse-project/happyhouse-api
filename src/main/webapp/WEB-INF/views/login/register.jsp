<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Roboto:400,700"
    />
    <title>회원 가입</title>
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
    />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
    />
    <link rel="stylesheet" href="../css/signup.css" />
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="signup-form">
      <form action="member?act=registerProcess" method="post">
        <h2>Register</h2>
        <p class="hint-text">간단한 정보만으로도 회원가입을 할 수 있습니다.</p>
        <div class="form-group">
          <input
            type="email"
            class="form-control"
            name="email"
            placeholder="이메일 주소"
            required="required"
          />
        </div>
        <div class="form-group">
          <div class="row">
            <div class="col">
              <input
                type="text"
                class="form-control"
                name="firstname"
                placeholder="이름"
                required="required"
              />
            </div>
            <div class="col">
              <input
                type="text"
                class="form-control"
                name="lastname"
                placeholder="성"
                required="required"
              />
            </div>
          </div>
        </div>

        <div class="form-group">
          <input
            type="password"
            class="form-control"
            name="password"
            placeholder="비밀번호"
            required="required"
          />
        </div>
        <div class="form-group">
          <input
            type="password"
            class="form-control"
            name="confirm_password"
            placeholder="비밀번호 재입력"
            required="required"
          />
        </div>
        <div class="form-group">
          <input
            type="text"
            class="form-control"
            name="phone"
            placeholder="전화번호"
            required="required"
          />
        </div>
        <div class="form-group">
          <div class="row">
            <div class="col">
              <input
                type="text"
                class="form-control"
                name="si"
                placeholder="도/광역시"
                required="required"
              />
            </div>
            <div class="col">
              <input
                type="text"
                class="form-control"
                name="gu"
                placeholder="시/구/군"
                required="required"
              />
            </div>
            <div class="col">
              <input
                type="text"
                class="form-control"
                name="dong"
                placeholder="동"
                required="required"
              />
            </div>
          </div>
        </div>
        <div class="form-group">
          <label class="form-check-label"
            ><input type="checkbox" required="required" /> 회원가입 시
            <a href="#">Terms of Use</a> &amp;
            <a href="#">Privacy Policy</a>
            를 동의합니다
          </label>
        </div>
        <div class="form-group">
          <button type="submit" class="btn btn-success btn-lg btn-block">
            회원 가입
          </button>
        </div>
      </form>
      <div class="text-center">이미 계정이 있다면 <a href="member?act=login">로그인</a></div>
    </div>
  </body>
</html>
