//var xhr = null;
//
//$(document).ready(function() {
//	// ajax요청처리
//	$.ajax({
//		url:'http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev?LAWD_CD=11110&DEAL_YMD=201512&serviceKey=T2OoHRovEOCsMp%2FrBLSwZ6%2BO43CJTtXf%2FujATfAhkOc25X3MAg9wnmDcYaLFXP8Db5oPRqMpfo%2Fjf%2F%2FUnQGltQ%3D%3D',
//		success:function(result) {
//			alert(result);
//		}
//	});
//	
//});


//function process() {
//	if (xhr.readyState == 4 && xhr.status == 200) {
//		var result = document.getElementById('result');
//		var responseXml = xhr.responseXML;
//		var subjects = responseXml.getElementsByTagName("subject");
//
//		var msg = "";
//		for (var i = 0; i < subjects.length; i++) {
//			var subject = subjects[i];
//
//			var nums = subject.getElementsByTagName('num');
//			var titles = subject.getElementsByTagName('title');
//			var rooms = subject.getElementsByTagName('room');
//
//			var num = nums.item(0).firstChild.nodeValue;
//			var title = titles.item(0).firstChild.nodeValue;
//			var room = rooms.item(0).firstChild.nodeValue;
//			msg = msg + num + " : " + title + " : " + room + "<hr>";
//		}
//	}
//
//	result.innerHTML = msg;
//}