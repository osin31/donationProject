/**
 * 
 */

$(function(){
	
	$(document).ready(function(){
		var trkNm = '송주호';
		$.ajax({
	           method:"POST",
	           url: '/donation/ajaxTestData',
	           data: trkNm,
	           success: function(result){
//				var html = '';
//		     	   for(var j=1; j < result.excelData.length; j++){
//			     	html+= '<div id="prdtInfo_'+j+'">';
//			     	html+= '<label id="prdtNm_'+j+'"></label></br>';
//			     	html+= '<label id="prdtNo_'+j+'"></label>';
//					html+= '<div id="barcodeTarget_'+j+'"></div></br>';
//					html+= '</div>';
//					html+= '<input type="button" id="save_'+j+'" class="save" value="저장하기" onclick="test('+j+')"/>';
//		           }
//		           $('#barcodeTarget').html(html);
//		           
//	        	   for(var i=0;i<result.excelData.length;i++){
//					
//	                  
//	                  $("#prdtNm_"+i).text("상품명 : "+result.excelData[i].prdtNm);
//	                  $("#prdtNo_"+i).text("상품번호 : "+result.excelData[i].prdtNo);
//	            	  $("#barcodeTarget_"+i).barcode(result.excelData[i].sourceNm, "code128");
//	              }
//	              var excelFile = $('#excelFile').val();
//
//	            	if(excelFile != '' || excelFile !='undefined'){
//	            		$('.save').show();
//	                }
//	          	
	           }
		      ,fail : function(e){
		          console.log(e)
		       }
	        });
	});
})