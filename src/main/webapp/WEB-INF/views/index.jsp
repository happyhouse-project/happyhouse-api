<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/index.css">
<link rel="stylesheet" type="text/javascript" href="${pageContext.request.contextPath}/static/js/index.js">
<jsp:include page="theme/library.jsp"/>

<title>HappyHouse에 오신 것을 환영합니다</title>
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/static/assets/img/favicon.ico" />
</head>
<body>
	<jsp:include page="theme/header.jsp"/>
	<div class="container-fluid p-0">
		<div class="main">
			<!--1. carousel 들어가는 div -->
			<div id="happyhouseCarousel" class="carousel slide"
				data-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="${pageContext.request.contextPath}/static/images/bg-image.jpg" class="d-block w-100"
							alt="...">
					</div>
					<div class="carousel-item">
						<img src="${pageContext.request.contextPath}/static/images/bg-image2.jpg" class="d-block w-100"
							alt="...">
					</div>
					<div class="carousel-item">
						<img src="${pageContext.request.contextPath}/static/images/bg-image3.jpg" class="d-block w-100"
							alt="...">
					</div>
				</div>
				<a class="carousel-control-prev" href="#happyhouseCarousel"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#happyhouseCarousel"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
			<div class="search">
				<form action="#">
					<input type="text" placeholder="원하시는 아파트명, 주택명을 입력해주세요"
						name="search">
					<button type="button" onclick="location.href = 'apt.html'">
						<i class="fa fa-search"></i>
					</button>
				</form>
			</div>
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="intro">
							<span class="title">소개할게요</span>
							<hr>
							<img class="intro-img" alt="소개 이미지"
								src="${pageContext.request.contextPath}/static/images/숭인동숭인한양LEEPS.jfif">
						</div>
					</div>
					<div class="col">
						<script>
						$(document).ready(function(){
							$.get("${pageContext.request.contextPath}/news/mainNewsList"
									,function(data, status){
										$.each(data, function(index, vo) {
											$(".news").append("<div class='notice-link'><a href='"+vo.link+"'>"+vo.title+"</a></div>");
										});//each
									}//function
									, "json"
							);//get
						});//ready
						</script>
						<div class="news">
							<span class="title">뉴스</span>
							<button class="addBtn news-add-btn" type="button"
								onclick="location.href = 'news/list'">더보기</button>
							<hr>
						</div>
					</div>
					<div class="col">
						<script>
						$(document).ready(function(){
							$.get("${pageContext.request.contextPath}/notice/mainNoticeList"
									,{act:"mainNoticeList"}
									,function(data, status){
										$.each(data, function(index, vo) {
											$(".notice").append("<div class='notice-link'><a href='notice?act=detail&id="+vo.id+"'>"+vo.title+"</a></div>");
										});//each
									}//function
									, "json"
							);//get
						});//ready
						</script>
						<div class="notice">
							<span class="title">공지사항</span>
							<button class="addBtn notice-add-btn" type="button"
								onclick="location.href = 'notice/list'">더보기</button>
							<hr>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="theme/footer.jsp"></jsp:include>
	</div>
	
</body>
</html>
