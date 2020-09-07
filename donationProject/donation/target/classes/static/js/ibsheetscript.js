var obj ={
		init  :function(){
		
		var initOrderSheet = {};
		var pageCount = $('#pageCount').val();

		initOrderSheet.Cfg = {SearchMode:smServerPaging2, Page:pageCount, DeferredVScroll:1, AutoFitColWidth: 'init'};
		initOrderSheet.HeaderMode = {Sort:1, ColMove:1, ColResize:1};

		initOrderSheet.Cols = [
			{Header:"No",					Type:"Text",			SaveName:"trkCnt",								Width: 10,	Align:"Center",	Edit:0}
		  , {Header:"저녁/새벽", 	    		Type:"Text",			SaveName:"trkGn",								Width:10,	Align:"Center",	Edit:0}
		  , {Header:"회원번호", 	    		Type:"Text",			SaveName:"trkNum",								Width:10,	Align:"Center",	Edit:0}
		  , {Header:"회원이름",				Type:"Text",			SaveName:"trkNm",								Width:10,	Align:"Center",	Edit:0}
		  , {Header:"회원주소",				Type:"Text",			SaveName:"trkAddr",								Width:10,	Align:"Center",	Edit:0} 
		];


		var pageCount = $('#pageCount').val();
		/**
		var param = { url : "/donation/toastGridTest"
			, onePageRow : pageCount
			, sheet : "orderSheet" };
		**/
		//DataSearchPaging(param);

		//IBSheet init
		createIBSheet2(document.getElementById("orderListGrid"), "orderSheet", "100%", "400px");


		IBS_InitSheet(orderSheet , initOrderSheet);
		
		
		// Grid width 자동 조절
		// FitColWidth();
		
			obj.event.doAction();
		},
//event start
		event : {
		    doAction: function() { 
		    
		    		 $.ajax({
					 	type : "POST",
					 	url  : "/donation/toastGridTest",
					 	contentType : "application/json",
					 	dataType : "json"
					 })
					 .done(function (data, textStatus, xhr) {
						console.log('data:'+data.data.contents);
						orderSheet.LoadSearchData(data.data.contents);
					 })
					 .fail(function(data, textStatus, errorThrown){
					      console.log("fail in get addr");
					 });
					  
		        orderSheet.LoadSearchData(this.data, {
		        });
		        
		    }
		},
//event end
//bind start
		bind : {
			ibsheetSearch : function(){

			}
		}
//bind end

}


$(function(){
	obj.init();	
})
