<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="../theme/library.jsp"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/index.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/noticeList.css">
<title>아파트·주택 관련 뉴스</title>
</head>
<body>
	<div class="container-fluid p-0">
		<jsp:include page="header.jsp" />
		<div class="news-main">
			<form action="./news/registerProcess" method="post">
				<div class="infolist">
					<h3>뉴스</h3>
					<hr class="hr-main">
					<c:forEach items="${list}" var="news">
						<p>
							<a href="${news.link}" target="_blank">${news.title}</a>
							<input type="checkbox" name="newsInfo" value="${news.title}###${news.link}###${news.category}###${news.id}">
						</p>
						<hr>
					</c:forEach>
				</div>
				<div>
					<button type="submit" class="btn btn-success">Success</button>
				</div>
			</form>
			<div class="navbar">
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<c:if test="${param.page ne 1}">
							<li class="page-item"><a class="page-link"
								href="./news/newsInfo?page=${param.page-1}">Previous</a></li>
						</c:if>
						<li class="page-item"><a class="page-link"
							href="./news/newsInfo?page=${param.page+1}">${param.page+1}</a></li>
						<li class="page-item"><a class="page-link"
							href="./news/newsInfo?page=${param.page+2}">${param.page+2}</a></li>
						<li class="page-item"><a class="page-link"
							href="./news/newsInfo?page=${param.page+3}">${param.page+3}</a></li>
						<li class="page-item"><a class="page-link"
							href="./news/newsInfo?page=${param.page+4}">Next</a></li>
					</ul>
				</nav>
			</div>
		</div>
		<jsp:include page="../theme/footer.jsp"/>
	</div>
</body>
</html>