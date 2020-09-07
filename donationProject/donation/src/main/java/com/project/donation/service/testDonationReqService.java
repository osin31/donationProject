package com.project.donation.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.project.donation.dao.DonationDAO;
import com.project.donation.excelModel.ajaxTestData;
import com.project.donation.excelModel.ajaxTestDatas;
import com.project.donation.excelModel.barcodeModel;
import com.project.donation.excelModel.locationData;
import com.project.donation.excelModel.pagination;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class testDonationReqService{

	@Autowired
	private DonationDAO dao;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	ajaxTestDatas datas = new ajaxTestDatas();
	
	public Map<String, Object> getUploadTest(MultipartHttpServletRequest request) throws Exception{
		
		//TODO : 임의로 만들어놓음 수정해야함
		Map<String ,Object> uploadData = new HashMap<String, Object>();
		List<barcodeModel> barcodeModel = new ArrayList();
		
		MultipartFile file = null;
		Iterator<String> fileName = request.getFileNames();
		
		if(fileName.hasNext()) {
		      file = request.getFile(fileName.next());
		}
		OPCPackage opcPackage = OPCPackage.open(file.getInputStream());
	    XSSFWorkbook wb = new XSSFWorkbook(opcPackage);
		
	    int rowindex=0;
        int columnindex=0;
        //시트 수 (첫번째에만 존재하므로 0을 준다)
        //만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
        XSSFSheet sheet= wb.getSheetAt(0);
        //행의 수
        int rows=sheet.getPhysicalNumberOfRows(); //행
        log.info
        ("rows>>"+ rows);
        for(rowindex=0;rowindex<rows;rowindex++){
        	barcodeModel barcodeVo = new barcodeModel();
            //행을읽는다
        	log.info("rowIndex >>" + rowindex);
            XSSFRow row=sheet.getRow(rowindex);  // row 가져오는곳 
            if(row !=null){
                int cells=row.getPhysicalNumberOfCells(); //열
               
                for(columnindex=0;columnindex<cells;columnindex++){
                    XSSFCell cell=row.getCell(columnindex); // cell 가져오는곳
                    String value="";
                    DataFormatter df = new DataFormatter();
                    //셀이 빈값일경우를 위한 널체크!
                    if(cell==null){
                        continue;
                    }else{
                        //엑셀 내용  타입별로 읽기
                        switch (cell.getCellType()){
                        case XSSFCell.CELL_TYPE_FORMULA:
                            value=cell.getCellFormula();
                            break;
                        case XSSFCell.CELL_TYPE_NUMERIC:
                        	value = df.formatCellValue(cell);
                            break;
                        case XSSFCell.CELL_TYPE_STRING:
                            value=cell.getStringCellValue()+"";
                            break;
                        case XSSFCell.CELL_TYPE_BLANK:
                            value=cell.getBooleanCellValue()+"";
                            break;
                        case XSSFCell.CELL_TYPE_ERROR:
                            value=cell.getErrorCellValue()+"";
                            break;
                        }
                    }
                   
//                    if(columnindex == 0) {
//                    	barcodeVo.setPrdtNo(value);
//                    }else if(columnindex == 1) {
//                    	barcodeVo.setPrdtNm(value);
//                    }else {
//                    	barcodeVo.setSourceNm(value);
//                    }
                }
                log.info("barcodeVo >>"+ barcodeVo);
                barcodeModel.add(barcodeVo);
            }   
            
            
            if(!barcodeModel.isEmpty()) {
            	log.info("Excel Data : " + barcodeModel);
                uploadData.put("excelData", barcodeModel);
                uploadData.put("resultData", "success");
            }else {
            	uploadData.put("resultData", "fail");
            }
        }
        
        log.info("Excel Data : " + barcodeModel);
        uploadData.put("excelData", barcodeModel);
		return uploadData;
	}
	
	public Map<String, Object> getTestAjax(ajaxTestData trkNm) throws Exception{
		
		String trkNms = trkNm.getTrkNm();
		List<ajaxTestData> getTestAjax =dao.selectData(trkNm);
		List<ajaxTestDatas> getTestAjaxs =dao.selectDatas(trkNms);
		
		for(ajaxTestData data_s : getTestAjax){
			getTestAjaxs.stream().filter(a -> data_s.getTrkNm().equals("강남구")).collect(Collectors.toList());
			
			log.info("data_log:::"+getTestAjaxs);	
		}
		
		Map<String, Object> bb = new HashMap<String, Object>();
		bb.put("data", getTestAjax);
		return bb;
	}
	
	public List<ajaxTestData> ajaxTest(ajaxTestData data) throws Exception{
		
		//Map<String , List<ajaxTestData>> newT = dao.ajaxTest(data);
		List<ajaxTestData> newT = dao.ajaxTest(data);
		
//		newT = newT.stream().filter(a->a.getTrkMsg().isEmpty()).collect(Collectors.toList());
//		newT = newT.stream().filter(a->a.getTrkMsg().equals(null)).collect(Collectors.toList());
		return newT;
	}
	
	public List<locationData> mainLocation(locationData data) throws Exception{
		
		List<locationData> locationRtn = dao.mainLocation(data);
		
		return locationRtn;
	}
	
	//2020년 8월31일 TOAST GRID 
	public Map<String, Object> toastGridTest(ajaxTestData trkNm) throws Exception{
		
//		String trkNms = trkNm.getTrkNm();
		List<ajaxTestData> getTestAjax =dao.selectData(trkNm);
		
		IntSummaryStatistics totalCount = getTestAjax.stream().mapToInt(ajaxTestData::getTotalCount).summaryStatistics();
		int totalCnt = (int) totalCount.getCount();
		log.info("getTestAjax : >>" + totalCnt);
		getTestAjax.get(0).setTotalCount(totalCnt);
		Map<String, Object> bb = new HashMap<String, Object>();
		Map<String, Object> aa = new HashMap<String, Object>();
		pagination pagination = new pagination();
		pagination.setTotalCnt(totalCnt);
		pagination.setPage(1);
		
		
		aa.put("contents", getTestAjax);
		aa.put("pagination", pagination);	
		bb.put("data", aa);
		bb.put("result", true);
		return bb;
	}
	
}
