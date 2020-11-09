<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/index.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/apt.css">
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5cc03bac0d3510a482068b50dd6e3612&libraries=services"></script>
<jsp:include page="../theme/library.jsp" />
<title>아파트 매매 / 전·월세</title>
</head>
<body>
	<div>
		<jsp:include page="../theme/header.jsp" />
	</div>
	<div class="row">
		<div class="mapArea">
			<div id="map"></div>
		</div>
	</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/apt.js"></script>
</html>