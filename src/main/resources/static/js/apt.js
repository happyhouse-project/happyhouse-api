var mapContainer = document.getElementById('map'), // 지도를 표시할 div
mapOption = {
	center : new kakao.maps.LatLng(37.5743822, 126.9688505), // 지도의 중심좌표
	level : 3
// 지도의 확대 레벨
};

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 마우스 드래그로 지도 이동이 완료되었을 때 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'dragend', function() {

	// 지도 영역정보를 얻어옵니다 
    var bounds = map.getBounds();
    
    // 영역정보의 남서쪽 정보를 얻어옵니다 
    var swLatlng = bounds.getSouthWest();
    
    // 영역정보의 북동쪽 정보를 얻어옵니다 
    var neLatlng = bounds.getNorthEast();

	var message = '' + swLatlng.toString() + ', ';
	message += neLatlng.toString();
	console.log(message);

});

// 지도 확대 축소를 제어할 수 있는 줌 컨트롤을 생성합니다
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

// 지도가 확대 또는 축소되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'zoom_changed', function() {

	// 지도의 현재 레벨을 얻어옵니다
	var level = map.getLevel();
	
	// 지도 영역정보를 얻어옵니다 
    var bounds = map.getBounds();
    
    // 영역정보의 남서쪽 정보를 얻어옵니다 
    var swLatlng = bounds.getSouthWest();
    
    // 영역정보의 북동쪽 정보를 얻어옵니다 
    var neLatlng = bounds.getNorthEast();

	var message = '' + swLatlng.toString() + ', ';
	message += neLatlng.toString() + " level : " + level;
	console.log(message);

});