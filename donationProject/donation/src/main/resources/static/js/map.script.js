var obj = {
		init : function() {

		    obj.event();
		},
		
		event : function(){
			//layer popup on
			$("#popOpen").on("click", function() {
				$("#popup").addClass("active");
				//Map Conf
				obj.bind.confMapLocation();
			});
			
			//layer popup off
			$(".btn-close").on("click", function() {
				$("#popup").removeClass("active");
			});
			
			//검색버튼 클릭시 
			$('#addrConf').on('click',function(){
				var addrData = $('#addrSearch').val();
				obj.bind.addressSearch(addrData);
				$('#map-canvas').css('display','');
			});	
			 
		},
		
		bind : {
			addressSearch : function(addrData){
				

			    var mapOptions = {
			        zoom: 14, // 지도를 띄웠을 때의 줌 크기
			        mapTypeId: google.maps.MapTypeId.ROADMAP
			    };
			 
			 
			    var map = new google.maps.Map(document.getElementById("map-canvas"), // div의 id과 값이 같아야 함. "map-canvas"
			                mapOptions);
			 
			    var size_x = 40; // 마커로 사용할 이미지의 가로 크기
			    var size_y = 40; // 마커로 사용할 이미지의 세로 크기
			 
			    // 마커로 사용할 이미지 주소
			    var image = new google.maps.MarkerImage( '마커주소',
			                                new google.maps.Size(size_x, size_y),
			                                '',
			                                '',
			                                new google.maps.Size(size_x, size_y));
			 
			    
				// 주소-좌표 변환 객체를 생성합니다
			    var geocoder = new google.maps.Geocoder();
			    
				// 주소로 좌표를 검색합니다
			    geocoder.geocode( { 'address': addrData }, function(results, status) {
			        console.log(results);
			        if (status == google.maps.GeocoderStatus.OK) {
			            map.setCenter(results[0].geometry.location);
			            marker = new google.maps.Marker({
			                            map: map,
			                            icon: image, // 마커로 사용할 이미지(변수)
			                            //title: '', // 마커에 마우스 포인트를 갖다댔을 때 뜨는 타이틀
			                            position: results[0].geometry.location
			                        });
					/* 
			            var content = "고등어맛집"; // 말풍선 안에 들어갈 내용
			         
			            // 마커를 클릭했을 때의 이벤트. 말풍선 뿅~
			            var infowindow = new google.maps.InfoWindow({ content: content});
			            google.maps.event.addListener(marker, "click", function() {infowindow.open(map,marker);});
					*/
			        } else {
			            alert("Geocode was not successful for the following reason: " + status);
			        }
			    })
			},
			confMapLocation : function(){

			$.ajax({
				type : "POST",
				url  : "/donation/mainLocation",
				contentType : "application/json",
				dataType : "json"
			})
			.done(function (data, textStatus, xhr) {
			     console.log(xhr);
			     console.log('data' + data);
//			     if(data.result_cd == "1"){
//			         alert("success!");
//			     } else {
//			         alert("에러발생["+data.result_cd+"]");
//			         console.log(data.result_msg);
//			         callback(data);
//			     }
			})
			.fail(function(data, textStatus, errorThrown){
			     console.log("fail in get addr");
			});
				
				var mapOptions = {
				        zoom: 14, // 지도를 띄웠을 때의 줌 크기
				        mapTypeId: google.maps.MapTypeId.ROADMAP
				    };
				 
				 
				    var map = new google.maps.Map(document.getElementById("map-canvas_2"), // div의 id과 값이 같아야 함. "map-canvas"
				                mapOptions);
				 
				    var size_x = 40; // 마커로 사용할 이미지의 가로 크기
				    var size_y = 40; // 마커로 사용할 이미지의 세로 크기
				 
				    // 마커로 사용할 이미지 주소
				    var image = new google.maps.MarkerImage( '마커주소',
				                                new google.maps.Size(size_x, size_y),
				                                '',
				                                '',
				                                new google.maps.Size(size_x, size_y));
				 
				    // 주소-좌표 변환 객체를 생성합니다
				    var geocoder = new google.maps.Geocoder();
				 
				    // 주소로 좌표를 검색합니다
				    geocoder.geocode( { 'address': "동대문구"}, function(results, status) {
				        console.log(results);
				        if (status == google.maps.GeocoderStatus.OK) {
				            map.setCenter(results[0].geometry.location);
				            marker = new google.maps.Marker({
				                            map: map,
				                            icon: image, // 마커로 사용할 이미지(변수)
				                            //title: '', // 마커에 마우스 포인트를 갖다댔을 때 뜨는 타이틀
				                            position: results[0].geometry.location
				                        });
				            /*
				            var content = ""; // 말풍선 안에 들어갈 내용
				         
				            // 마커를 클릭했을 때의 이벤트. 말풍선 뿅~
				            var infowindow = new google.maps.InfoWindow({ content: content});
				            google.maps.event.addListener(marker, "click", function() {infowindow.open(map,marker);});
				            */
				        } else {
				            alert("Geocode was not successful for the following reason: " + status);
				        }
				    });
			}
		}
	}
$(function(){

	obj.init();	
})
