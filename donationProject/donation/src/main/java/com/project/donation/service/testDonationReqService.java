package com.project.donation.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.project.donation.dao.DonationDAO;
import com.project.donation.excelModel.ajaxTestData;
import com.project.donation.excelModel.barcodeModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class testDonationReqService{

	@Autowired
	private DonationDAO dao;
	
	public Map<String, Object> getUploadTest(MultipartHttpServletRequest request) throws Exception{
		
		log.info("Service IN------------------------------------------");
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
                   
                    if(columnindex == 0) {
                    	barcodeVo.setPrdtNo(value);
                    }else if(columnindex == 1) {
                    	barcodeVo.setPrdtNm(value);
                    }else {
                    	barcodeVo.setSourceNm(value);
                    }
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
	
	public Map<String, Object> getTestAjax(ajaxTestData data) throws Exception{
		Map<String ,Object> getTestAjax =dao.selectData(data);
		
		return getTestAjax;
	}
}
