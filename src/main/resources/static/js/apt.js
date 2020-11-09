var swLatlng; // 하단 - 남서
var neLatlng; // 상단 - 북동

$(document).ready(function() {
	sendLocation();		// 시작하자마자 데이터 전송
	sendDragLocation(); // 드래그 시 데이터 전송
	sendZoomLocation(); // 줌 시 데이터 전송
});

// 시작하자마자 데이터 전송	->  코드 통합 필요
function sendLocation() {
	
	// 지도의 현재 레벨을 얻어옵니다
	var level = map.getLevel();

	// 지도 영역정보를 얻어옵니다
	var bounds = map.getBounds();

	// 영역정보의 남서쪽 정보를 얻어옵니다
	swLatlng = bounds.getSouthWest();

	// 영역정보의 북동쪽 정보를 얻어옵니다
	neLatlng = bounds.getNorthEast();

	var message = '' + swLatlng.toString() + ', ';
	message += neLatlng.toString() + " level : " + level;

	console.log(message);
	
	$.ajax({
		url : "./aptDragSearch",
		method : "post",
		contentType : "application/json",	//데이터 전송
		data : JSON.stringify({
			from : swLatlng.toString(),
			to : neLatlng.toString()
		}),
		dataType : "json",	//받는 데이터
		success : function(data) {
			displayInfo(data);
		},
		error : function(xhr, status, msg) {
			console.log("상태값:" + status + " http 에러메세지:" + msg);
		}
	});
}

// 줌 변경 시 데이터 전송
function sendZoomLocation() {
	
	// 지도가 확대 또는 축소되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
	kakao.maps.event.addListener(map, 'zoom_changed', function() {

		// 지도의 현재 레벨을 얻어옵니다
		var level = map.getLevel();

		// 지도 영역정보를 얻어옵니다
		var bounds = map.getBounds();

		// 영역정보의 남서쪽 정보를 얻어옵니다
		swLatlng = bounds.getSouthWest();

		// 영역정보의 북동쪽 정보를 얻어옵니다
		neLatlng = bounds.getNorthEast();

//		var message = '' + swLatlng.toString() + ', ';
//		message += neLatlng.toString() + " level : " + level;
//
//		console.log(message);
		
		$.ajax({
			url : "./aptDragSearch",			//수정필요
			method : "post",
			contentType : "application/json",	//데이터 전송
			data : JSON.stringify({
				from : swLatlng.toString(),
				to : neLatlng.toString(),
				level : level
			}),
			dataType : "json",	//받는 데이터
			success : function(data) {
				
				if(data.length <= 500){	//데이터 너무 많아질 경우 처리
					displayInfo(data);
				}
				
			},
			error : function(xhr, status, msg) {
				console.log("상태값:" + status + " http 에러메세지:" + msg);
			}
		});
	});
}

// 드래그 시 데이터 전송
function sendDragLocation() {
	// 마우스 드래그로 지도 이동이 완료되었을 때 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
	kakao.maps.event.addListener(map, 'dragend', function() {

		// 지도 영역정보를 얻어옵니다
		var bounds = map.getBounds();

		// 영역정보의 남서쪽 정보를 얻어옵니다
		swLatlng = bounds.getSouthWest();

		// 영역정보의 북동쪽 정보를 얻어옵니다
		neLatlng = bounds.getNorthEast();

//		var message = '' + swLatlng.toString() + ', ';
//		message += neLatlng.toString();
//		console.log(message);

		$.ajax({
			url : "./aptDragSearch",
			method : "post",
			contentType : "application/json",	//데이터 전송
			data : JSON.stringify({
				from : swLatlng.toString(),
				to : neLatlng.toString()
			}),
			dataType : "json",	//받는 데이터
			success : function(data) {
				
				if(data.length <= 500){	//데이터 너무 많아질 경우 처리
					displayInfo(data);
				}
				
			},
			error : function(xhr, status, msg) {
				console.log("상태값:" + status + " http 에러메세지:" + msg);
			}
		});
	});
}

function displayInfo(data){
	
	// 인포윈도우를 생성하고 지도에 표시합니다
	$.each(data, function(index, vo){
//		console.log(vo.aptName + ',' + vo.dong);
//		console.log('>>' + vo.deals[0].dealAmount);
		var imageSrc = "/happyhouse/static/images/marker.png", // 마커이미지의 주소입니다    
	    imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
	    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

		// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
		var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
		    markerPosition = new kakao.maps.LatLng(vo.lat, vo.lng); // 마커가 표시될 위치입니다
	
		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
		  position: markerPosition,
		  image: markerImage // 마커이미지 설정 
		});
	
		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);  
	
		// 커스텀 오버레이에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		var content = '<div class="customoverlay">' +
		    '  <a href="https://map.kakao.com/link/map/11394059" target="_blank">' +
		    '    <span class="title">'+vo.aptName+ 
		    '                  <br>' + vo.dong +
		    '                  <br>' + vo.deals[0].dealAmount +'만원</span>' +  
		    '  </a>' +
		    '</div>';
	
		// 커스텀 오버레이가 표시될 위치입니다 
		var position = new kakao.maps.LatLng(vo.lat, vo.lng);  
	
		// 커스텀 오버레이를 생성합니다
		var customOverlay = new kakao.maps.CustomOverlay({
		    map: map,
		    position: position,
		    content: content,
		    yAnchor: 1 
		});
	});//each
}

// ===================================================================

var mapContainer = document.getElementById('map'), // 지도를 표시할 div
mapOption = {
	center : new kakao.maps.LatLng(37.5743822, 126.9688505), // 지도의 중심좌표
	level : 3
// 지도의 확대 레벨
};

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 지도 확대 축소를 제어할 수 있는 줌 컨트롤을 생성합니다
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

