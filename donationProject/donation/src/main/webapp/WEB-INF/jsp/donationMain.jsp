<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	type="text/javascript"></script>
<title>Spring Boot Application with JSP</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/map.css.css">
<!-- <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAfbrmtWZMqps-QqdiPTJz8ZiUHfg43CKU&callback=initMap&region=kr"></script> -->

<!-- <script src="/static/js/map.utils.js"></script> -->
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAfbrmtWZMqps-QqdiPTJz8ZiUHfg43CKU&libraries=places"></script>
<script src="/static/js/map.script.js"></script>

<div>
	<input type="text" id="addrSearch" value="">
	<button id="addrConf">검색</button>
	<button id="popOpen">등록하기</button>
</div>

<!-- layer Setting -->
<div id="popup">
  <div class="popup-wrap text-popup">
    <div class="popup-content">
    <p class="btn-close">X</p>
    <div class="title">Map Conf layer</div>
    <div class="info-text">
    	<div id="map-canvas_2" style="height: 300px;"></div>
    </div>
    </div>
  </div>
</div>


<div id="map-canvas" style="height: 300px; display: none;"></div>
