<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="/static/js/jquery-barcode.js"></script>
<title>Spring Boot Application with JSP</title>
<script src="https://cdn.rawgit.com/eligrey/FileSaver.js/5ed507ef8aa53d8ecfea96d96bc7214cd2476fd2/FileSaver.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.5.0-beta4/html2canvas.js"></script>
<script>


    
$(document).ready(function(){

	$('.save').hide();

	$("#excelUpForm").change(function(){
        var form = $("#excelUpForm")[0];
        var data = new FormData(form);
        $.ajax({
           enctype:"multipart/form-data",
           method:"POST",
           url: '/donation/uploadTest',
           processData: false,   
           contentType: false,
           cache: false,
           data: data,
           success: function(result){
			var html = '';
	     	   for(var j=1; j < result.excelData.length; j++){
		     	html+= '<div id="prdtInfo_'+j+'">';
		     	html+= '<label id="prdtNm_'+j+'"></label></br>';
		     	html+= '<label id="prdtNo_'+j+'"></label>';
				html+= '<div id="barcodeTarget_'+j+'"></div></br>';
				html+= '</div>';
				html+= '<input type="button" id="save_'+j+'" class="save" value="저장하기" onclick="test('+j+')"/>';
	           }
	           $('#barcodeTarget').html(html);
	           
        	   for(var i=0;i<result.excelData.length;i++){
				
                  
                  $("#prdtNm_"+i).text("상품명 : "+result.excelData[i].prdtNm);
                  $("#prdtNo_"+i).text("상품번호 : "+result.excelData[i].prdtNo);
            	  $("#barcodeTarget_"+i).barcode(result.excelData[i].sourceNm, "code128");
              }
              var excelFile = $('#excelFile').val();

            	if(excelFile != '' || excelFile !='undefined'){
            		$('.save').show();
                }
          	
           }
	      ,fail : function(e){
	          console.log(e)
	       }
        });
    });

	

});
function test(index){
	console.log(index);
    html2canvas($("#prdtInfo_"+index), {
        onrendered: function(canvas) {
            canvas.toBlob(function(blob) {
	                saveAs(blob, 'image.png');
            });

        }

    });
}
</script>
<form name="excelUpForm" id="excelUpForm" enctype="multipart/form-data" method="POST" action="./excelDown.do">
    <input type="file" id="excelFile" name="excleFile" value="엑셀 업로드" />
</form>
<div id="barcodeTarget"></div>

