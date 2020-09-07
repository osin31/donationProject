const Grid = tui.Grid;
const Pagination = tui.Pagination;


$(function() {
  
    var gridData = [];

      $.ajax({
				type : "POST",
				url  : "/donation/toastGridTest",
				contentType : "application/json",
				dataType : "json"
			})
			.done(function (data, textStatus, xhr) {

          for(var i=0; i<data.data.length; i++){

          gridData.push({
            trkCnt: data.data[i].trkCnt,
            trkGn: data.data[i].trkGn,
            trkNum: data.data[i].trkNum,
            trkNm: data.data[i].trkNm,
            trkAddr: data.data[i].trkAddr
            });

          }
            const grid = new tui.Grid({
                    el: document.getElementById('grid'),
                    data: gridData,
                    columns: [
                        {
                            header: 'No',
                            name: 'trkCnt',
                            validation: {
                    dataType: 'number',
                    required: true
                  }
                        },
                        {
                            header: '저녁/새벽',
                            name: 'trkGn'
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

			})
			.fail(function(data, textStatus, errorThrown){
			     console.log("fail in get addr");
      });
      

   



    const container = document.getElementById('tui-pagination-container');

    const options = {
        totalItems: 10,
        itemsPerPage: 10,
        visiblePages: 10,
        page: 10,
        centerAlign: false,
        firstItemClassName: 'tui-first-child',
        lastItemClassName: 'tui-last-child',
        template: {
          page: '<a href="#" class="tui-page-btn">'+10+'</a>',
          currentPage: '<strong class="tui-page-btn tui-is-selected">'+10+'</strong>',
          moveButton:
            '<a href="#" class="tui-page-btn tui-move">' +
              '<span class="tui-ico-move">'+'M'+'</span>' +
            '</a>',
          disabledMoveButton:
            '<span class="tui-page-btn tui-is-disabled tui-disabled">' +
              '<span class="tui-ico-disabled">'+'D'+'</span>' +
            '</span>',
          moreButton:
            '<a href="#" class="tui-page-btn tui-more-is-ellip">' +
              '<span class="tui-ico-ellip">...</span>' +
            '</a>'
        }
      };

    const instance = new Pagination(container, options);
})