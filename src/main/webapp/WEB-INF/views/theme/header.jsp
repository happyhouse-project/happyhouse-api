<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<div class="logo">
		<a href="index"><img class="logo-img" alt="logo"
			src="${pageContext.request.contextPath}/static/images/happyhouse_logo.png"></a>
	</div>
	<div class="menu">
		<ul>
			<li><a href="map?act=apartment">아파트</a></li>
			<li><a href="map?act=house">연립다세대 주택</a></li>
			<li><a href="localInfo.html">동네 상가정보 확인</a></li>
			<c:if test="${!empty member and member.auth eq 2}">
				<li><a href="member?act=memberList">회원관리</a></li>
			</c:if>
		</ul>
	</div>
	<div class="login">
		<c:if test="${empty member}">
			<button type="button" class="btn btn-primary"
				onclick="location.href = 'member?act=login'">로그인</button>
		</c:if>
		<c:if test="${!empty member}">
		${member.lastname}${member.firstname}님 환영합니다
		<button type="button" class="btn btn-primary"
				onclick="location.href = 'member?act=logout'">로그아웃</button>
		</c:if>
	</div>
</header>