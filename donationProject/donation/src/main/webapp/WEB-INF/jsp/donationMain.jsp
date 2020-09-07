<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	type="text/javascript"></script>
	<%-- 
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
 --%>
 
    <head>
        <meta charset="utf-8">

        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

        <!-- Toast Pagenation -->
        <script type="text/javascript" src="https://uicdn.toast.com/tui.code-snippet/v1.5.0/tui-code-snippet.js"></script>
		<script type="text/javascript" src="https://uicdn.toast.com/tui.pagination/v3.3.0/tui-pagination.js"></script>
 		<link rel="stylesheet" href="https://uicdn.toast.com/tui.pagination/latest/tui-pagination.css" />
 		<!-- Toast Data Grid -->
        <link rel="stylesheet" href="https://uicdn.toast.com/grid/latest/tui-grid.css" />
        <script src="https://uicdn.toast.com/grid/latest/tui-grid.js"></script>
<!-- IBSheet Setting  Start-->
		<script type="text/javascript" src="/static/ibsheet/ibleaders.js"></script>
		<script type="text/javascript" src="/static/ibsheet/ibsheet.js"></script>
		<script type="text/javascript" src="/static/ibsheet/ibsheetinfo.js"></script>
		<script type="text/javascript" src="/static/ibsheet/ibsheetcommon.js"></script>

    </head>

    <body>	
        <h1>Toast Grid Example</h1>
        <div class="container">
            <div class="container-grid">
                <div id="grid"></div>
            </div>
            <div class="container-pagenation">
                <div id="tui-pagination-container" class="tui-pagination"></div>
            </div>
        </div>
        <h2>IBSheet Grid Example</h2>
<!-- 		<input type="hidden" id="pageCount" value="10"/> -->
		<div id="orderListGrid"></div>
	
			<!-- S : ibsheet-wrap -->
			<div class="ibsheet-wrap">
				<div id="orderGrid" style="width:100%; height:429px;">
				</div>
			</div>
			<!-- E : ibsheet-wrap -->
	    </body>

</html>

<!-- IBSheet Setting  End-->
        <script src="/static/js/toastscript.js?v=<%=System.currentTimeMillis() %>"></script>
        <script src="/static/js/ibsheetscript.js?v=<%=System.currentTimeMillis() %>"></script>