const Grid = tui.Grid;
const Pagination = tui.Pagination;

		  var gridData = [];


   const  dataSource  =  {
		  api : { 
		    readData : {  url : '/donation/toastGridTest' ,  method : 'POST' } 
      		//createData: { url: '/api/create', method: 'POST' },
      		//updateData: { url: '/api/update', method: 'PUT' },
      		//deleteData: { url: '/api/delete', method: 'DELETE' },
      		//modifyData: { url: '/api/modify', method: 'POST' }
		  } 
   };
		
	            
	            const grid = new Grid({
				      el: document.getElementById('grid'),
				      data: dataSource,
				      scrollX: false,
				      scrollY: false,
				      minBodyHeight: 30,
				      rowHeaders: ['rowNum'],
				      pageOptions : { 
					    perPage : 10,
					    useClient:true
					  },
					columns: [
	      			{
	                    header: '저녁/새벽',
	                    name: 'trkGn',
	                    validation: {
				            dataType: 'number',
				            required: true
			        	}
	                },
	                {
	                    header: '회원번호',
	                    name: 'trkNum'
	                },
	                {
	                    header: '회원이름',
	                    name: 'trkNm'
	                },
	                {
	                    header: '회원주소',
	                    name: 'trkAddr'
	                }
					]
				});
				//callback
	//grid.on('successResponse', function(data) {
	// When a response has been received regardless of success.
	//	var totalCntMv = JSON.parse(data.xhr.response);
	//	 totalCntMv = totalCntMv.data.pagination.totalCnt;
	//	totalCntMvFlw(totalCntMv);
//});
	function totalCntMvFlw (totalCntMv){
	
		var pagination = new tui.Pagination('tui-pagination-container', {
        	totalItems: totalCntMv
   		});
   		
   		pagination.on('beforeMove', function(eventData) {
        	return confirm('Go to page ' + eventData.page + '?');
	    });

	    pagination.on('afterMove', function(eventData) {
	        alert('The current page is ' + eventData.page);
	    });
   				
	}
				

    
    

    