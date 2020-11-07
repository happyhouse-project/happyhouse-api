<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.wrap {
	position: absolute;
	left: 0;
	bottom: 40px;
	width: 288px;
	height: 132px;
	margin-left: -144px;
	text-align: left;
	overflow: hidden;
	font-size: 12px;
	font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;
	line-height: 1.5;
}

.wrap * {
	padding: 0;
	margin: 0;
}

.wrap .info {
	width: 286px;
	height: 120px;
	border-radius: 5px;
	border-bottom: 2px solid #ccc;
	border-right: 1px solid #ccc;
	overflow: hidden;
	background: #fff;
}

.wrap .info:nth-child(1) {
	border: 0;
	box-shadow: 0px 1px 2px #888;
}

.info .title {
	padding: 5px 0 0 10px;
	height: 30px;
	background: #eee;
	border-bottom: 1px solid #ddd;
	font-size: 18px;
	font-weight: bold;
}

.info .close {
	position: absolute;
	top: 10px;
	right: 10px;
	color: #888;
	width: 17px;
	height: 17px;
	background:
		url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');
}

.info .close:hover {
	cursor: pointer;
}

.info .body {
	position: relative;
	overflow: hidden;
}

.info .desc {
	position: relative;
	margin: 13px 0 0 90px;
	height: 75px;
}

.desc .ellipsis {
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

.desc .jibun {
	font-size: 11px;
	color: #888;
	margin-top: -2px;
}

.info .img {
	position: absolute;
	top: 6px;
	left: 5px;
	width: 73px;
	height: 71px;
	border: 1px solid #ddd;
	color: #888;
	overflow: hidden;
}

.info:after {
	content: '';
	position: absolute;
	margin-left: -12px;
	left: 50%;
	bottom: 0;
	width: 22px;
	height: 12px;
	background:
		url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')
}

.info .link {
	color: #5085BB;
}
</style>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/index.css">
<link rel="stylesheet" type="text/css" href="../css/apt.css">
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f087ab8dc364c56b8e9a5b62eac24ac8&libraries=services"></script>

<title>아파트 매매 / 전·월세</title>

</head>
<body>
	<div>
		<jsp:include page="header.jsp" />
	</div>
	<div>
		<script>
				let colorArr = ['table-primary','table-success','table-danger'];
				$(document).ready(function(){
					$.get("${pageContext.request.contextPath}/happy/map"
						,{act:"sido"}
						,function(data, status){
							$.each(data, function(index, vo) {
								$("#sido").append("<option value='"+vo.sido_code+"'>"+vo.sido_name+"</option>");
							});//each
						}//function
						, "json"
					);//get
				});//ready
				$(document).ready(function(){
					$("#sido").change(function() {
						$.get("${pageContext.request.contextPath}/happy/map"
								,{act:"gugun", sido:$("#sido").val()}
								,function(data, status){
									$("#gugun").empty();
									$("#gugun").append('<option value="0">선택</option>');
									$.each(data, function(index, vo) {
										$("#gugun").append("<option value='"+vo.gugun_code+"'>"+vo.gugun_name+"</option>");
									});//each
								}//function
								, "json"
						);//get
					});//change
					$("#gugun").change(function() {
						$.get("${pageContext.request.contextPath}/happy/map"
								,{act:"dong", gugun:$("#gugun").val()}
								,function(data, status){
									$("#dong").empty();
									$("#dong").append('<option value="0">선택</option>');
									$.each(data, function(index, vo) {
										$("#dong").append("<option value='"+vo.dong+"'>"+vo.dong+"</option>");
									});//each
								}//function
								, "json"
						);//get
					});//change
					$("#dong").change(function() {
						$.get("${pageContext.request.contextPath}/happy/map"
								,{act:"apt", dong:$("#dong").val()}
								,function(data, status){
									$("#targetTbody").empty();
									hideMarkers();
									//console.log(${pageContext.request.contextPath}/map);
									$.each(data, function(index, vo) {
										let str = "<tr class="+colorArr[index%3]+">"
										+ "<td>" + vo.no + "</td>"
										+ "<td>" + vo.dong + "</td>"
										+ "<td>" + vo.aptName + "</td>"
										+ "<td>" + vo.jibun + "</td>"
										+ "<td>" + vo.deal + "</td></tr>";
										$("tbody").append(str);
										//$("#targetTbody").append(vo.dong+" "+vo.aptName+" "+vo.jibun+"<br>");
									});//each
									geocode(data);
								}//function
								, "json"
						);//get
					});//change
					
					$("#deal").click(function() {
						$.get("${pageContext.request.contextPath}/happy/map"
								,{act:"deal", dong:$("#dong").val(), lower_bound:$("#lower_bound").val(), upper_bound:$("#upper_bound").val()}
								,function(data, status){
									$("#targetTbody").empty();
									hideMarkers();
									//console.log(${pageContext.request.contextPath}/map);
									$.each(data, function(index, vo) {
										let str = "<tr class="+colorArr[index%3]+">"
										+ "<td>" + vo.no + "</td>"
										+ "<td>" + vo.dong + "</td>"
										+ "<td>" + vo.aptName + "</td>"
										+ "<td>" + vo.jibun + "</td>"
										+ "<td>" + vo.deal + "</td></tr>";
										$("tbody").append(str);
										$("#searchResult").append(vo.dong+" "+vo.aptName+" "+vo.jibun+"<br>");
									});//each
									geocode(data);
								}//function
								, "json"
						);//get
					});//change
				});//ready
				var points=[];
				var bounds = new kakao.maps.LatLngBounds();
				var marker_list=[];
				var lat_mid=0;
				var lng_mid=0;
				function geocode(jsonData) {
					console.log(jsonData);
					
					let idx = 0;
					$.each(jsonData, function(index, vo) {
						reset_var();
						// 마커가 표시될 위치입니다 
						var markerPosition = new kakao.maps.LatLng(vo.lat,
								vo.lng);
						points.push(markerPosition);
						// 마커를 생성합니다
						var marker = new kakao.maps.Marker({
							position : markerPosition
						});
						marker_list.push(marker);
						// 커스텀 오버레이 재원
						console.log(vo);
						var content = '<div class="wrap">' + 
            '    <div class="info">' + 
            '        <div class="title">' + 
            vo.aptName             + 
            '            <div class="close" onclick="closeOverlay()" title="닫기"></div>' + 
            '        </div>' + 
            '        <div class="body">' + 
            '            <div class="img">' +
            '                <img src="https://cfile181.uf.daum.net/image/250649365602043421936D" width="73" height="70">' +
            '           </div>' + 
            '            <div class="desc">' + 
            '                <div class="ellipsis">'+vo.dong+" "+ vo.jibun+'</div>' + 
            '                <div class="jibun ellipsis">'+vo.deal+'</div>' + 
            '                <div><a href="#" target="_blank" class="link">홈페이지</a></div>' + 
            '            </div>' + 
            '        </div>' + 
            '    </div>' +    
            '</div>';
            var overlay = new kakao.maps.CustomOverlay({
                content: content,
                map: map,
                position: marker.getPosition()       
            });
         // 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
            kakao.maps.event.addListener(marker, 'click', function() {
                overlay.setMap(map);
            });
         // 커스텀 오버레이를 닫기 위해 호출되는 함수입니다 
            function closeOverlay() {
                overlay.setMap(null);     
            }
        
         
						
						// 마커가 지도 위에 표시되도록 설정합니다
						marker.setMap(map);
						// 
						bounds.extend(markerPosition);
						lat_mid+=vo.lat;
						lng_mid+=vo.lng;
					});//each
					setBounds_modified();
				}
				function setBounds() {
				    // LatLngBounds 객체에 추가된 좌표들을 기준으로 지도의 범위를 재설정합니다
				    // 이때 지도의 중심좌표와 레벨이 변경될 수 있습니다
				    map.setBounds(bounds);
				    zoomIn();
				}
				function reset_var(){
					points=[];
					bounds = new kakao.maps.LatLngBounds();
					marker_list=[];
					lat_mid=0;
					lng_mid=0;
				}
				function setBounds_modified(){
					map.setCenter(new kakao.maps.LatLng(lat_mid/points.length, lng_mid/points.length))
					map.setLevel(2,{animate:true, anchor:new kakao.maps.LatLng(lat_mid/points.length, lng_mid/points.length)})
					console.log(bounds);
					map.setBounds(bounds);
				}
				function setMarkers(map) {
				    for (var i = 0; i < marker_list.length; i++) {
				    	marker_list[i].setMap(map);
				    }            
				}
				// "마커 감추기" 버튼을 클릭하면 호출되어 배열에 추가된 마커를 지도에서 삭제하는 함수입니다
				function hideMarkers() {
				    setMarkers(null);    
				}
				function zoomIn() {        
				    // 현재 지도의 레벨을 얻어옵니다
				    var level = map.getLevel();
				    
				    // 지도를 1레벨 내립니다 (지도가 확대됩니다)
				    map.setLevel(1);
				}   
				</script>
		시도 : <select id="sido">
			<option value="0">선택</option>
		</select> 구군 : <select id="gugun">
			<option value="0">선택</option>
		</select> 읍면동 : <select id="dong">
			<option value="0">선택</option>
		</select> <br> 최저가 : <input type="text" id="lower_bound"
			style="width: 80px"> 최고가 : <input type="text"
			id="upper_bound" style="width: 80px">
		<button id="deal">검색</button>

	</div>
	<div class="row">

		<div class="mapArea">
			<div id="map"></div>

			<script>
					var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
					mapOption = {
						center : new kakao.maps.LatLng(37.5743822, 126.9688505), // 지도의 중심좌표
						level : 3
					// 지도의 확대 레벨
					};

					var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

					// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
					// marker.setMap(null);
					
					
					
				</script>
		</div>
		<div class="aptInfoArea">
			<table class="table mt-2">
				<thead>
					<tr>

						<th>번호</th>
						<th>법정동</th>
						<th>아파트이름</th>
						<th>지번</th>
						<th>가격</th>

					</tr>
				</thead>
				<tbody id="targetTbody">
				</tbody>
			</table>

		</div>
	</div>
	<jsp:include page="library.html"/>
</body>
</html>