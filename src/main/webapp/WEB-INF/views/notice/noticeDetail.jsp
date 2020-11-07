<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/index.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/noticeList.css">
<title>공지사항</title>
</head>
<body>
	<div class="container-fluid p-0">
		<jsp:include page="../theme/header.jsp" />
		<div class="main">
			<div class="infolist">
				<h3>${notice.title}</h3>
				<hr class="hr-main">
				<center>
					<TABLE BORDER=2 CELLSPACING=2 CELLPADDING=2>
						<TR>
							<TH WIDTH=200>공지번호</TH>
							<TD width=300 align=center>${notice.id}</TD>
							<TH WIDTH=300>NAME</TH>
							<TD width=300 align=center>${notice.writer}</TD>
						</TR>
						<TR>
							<TH WIDTH=200>DATE</TH>
							<TD width=300 align=center>${notice.writeDate}</TD>
							<TH WIDTH=300>COUNT</TH>
							<TD width=300 align=center>124</TD>
						</TR>
						<TR>
							<TH WIDTH=200>TITLE</TH>
							<TD COLSPAN=3>${notice.title}</TD>
						</TR>
						<TR>
							<TH WIDTH=200>CONTENT</TH>
							<TD COLSPAN=3><textarea readonly cols=120 rows=20>${notice.content}</textarea></TD>
						</TR>
					</TABLE>
					<br> <br> <a href="notice?act=delete&id=${notice.id}">삭제하기</a>&nbsp;&nbsp;&nbsp;
					<br>
				</center>
				<jsp:include page="../theme/footer.jsp" />
			</div>
			<jsp:include page="../theme/library.jsp" />
</body>
</html>