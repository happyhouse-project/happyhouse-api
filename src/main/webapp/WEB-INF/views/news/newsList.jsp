<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="../css/index.css">
<link rel="stylesheet" type="text/css" href="../css/noticeList.css">
<title>아파트·주택 관련 뉴스</title>
</head>
<body>
	<div class="container-fluid p-0">
		<jsp:include page="header.jsp"/>
		<div class="main">
			<div class="infolist">
				<h3>뉴스</h3>
				<c:if test="${!empty member and member.auth eq 2}">
				<button class="addBtn btn-right" type="button"
								onclick="location.href = './news?act=newsInfo&page=1'">뉴스 추가하기</button></c:if>
				<hr class="hr-main">
				<c:forEach items="${list}" var="news">
					<p><a href="${news.link}">${news.title}</a></p><hr>
				</c:forEach>
			</div>
		</div>
		<jsp:include page="footer.html"/>
	</div>
	<jsp:include page="library.html"/>
</body>
</html>