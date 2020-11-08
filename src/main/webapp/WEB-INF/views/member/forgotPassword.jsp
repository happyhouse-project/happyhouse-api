<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/forgot_password.css" />
    <title>비밀번호 찾기</title>
  </head>
  <jsp:include page="../theme/library.jsp"/>
  <body>
    <div class="container">
      <div class="row">
        <div class="col-md-4 col-md-offset-4">
          <div class="panel panel-default" style="margin-top:20%;">
            <div class="panel-body">
              <div class="text-center">
                <h3><i class="fa fa-lock fa-4x"></i></h3>
                <h2 class="text-center">비밀번호 찾기</h2>
                <p>등록하신 이메일로 비밀번호 초기화 링크를 보내드립니다</p>
                <div class="panel-body">
                  <form
                    id="register-form"
                    role="form"
                    autocomplete="off"
                    class="form"
                    method="post"
                  >
                    <div class="form-group">
                      <div class="input-group">
                        <span class="input-group-addon"
                          ><i
                            class="glyphicon glyphicon-envelope color-blue"
                          ></i
                        ></span>
                        <input
                          id="email"
                          name="email"
                          placeholder="이메일 주소를 입력해 주세요"
                          class="form-control"
                          type="email"
                        />
                      </div>
                    </div>
                    <div class="form-group">
                      <input
                        name="recover-submit"
                        class="btn btn-lg btn-primary btn-block"
                        value="링크 전송"
                        type="submit"
                      />
                    </div>

                    <input
                      type="hidden"
                      class="hide"
                      name="token"
                      id="token"
                      value=""
                    />
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
