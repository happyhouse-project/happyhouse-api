<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/index.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/noticeList.css">
<title>공지사항</title>
</head>
<body>
	<div class="container-fluid p-0">
		<jsp:include page="../theme/header.jsp" />
		<div class="main">
			<div class="infolist">
				<h3>공지사항 등록</h3>
				<hr class="hr-main">
				<center>
					<form method='post' action='./registerProcess'>
						<table>
							<tr>
								<td><h1>새글쓰기</h1></td>
							</tr>
							<tr>
								<td>제목 : <input
									type=input name='title' size=42></td>
							</tr>
							<tr>
								<td colspan=2>내용 : <textarea rows=10 cols=50 name='content'></textarea></td>
							</tr>
							<tr>
								<td><center>
										<input type=submit value=전송><input type=reset
											value=취소>
									</center></td>
							</tr>
						</table>
					</form>
					<p>
						<a href="./list">공지사항 리스트</a>&nbsp;&nbsp;&nbsp;
				</center>
			</div>
		</div>
		<jsp:include page="../theme/footer.jsp" />
	</div>
	<jsp:include page="../theme/library.jsp" />
</body>
</html>