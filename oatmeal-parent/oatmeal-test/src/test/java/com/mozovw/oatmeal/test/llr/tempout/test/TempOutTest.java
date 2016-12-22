package com.mozovw.oatmeal.test.llr.tempout.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.mozovw.oatmeal.poi.excel.tempreplace.entity.ExcelHandleDataVO;
import com.mozovw.oatmeal.poi.excel.tempreplace.util.ExcelTempHandleUtil;
import com.mozovw.oatmeal.root.test.log.JUnit4ClassRunner;
import com.mozovw.oatmeal.test.llr.tempout.dao.TempOutDao;
import com.mozovw.oatmeal.test.llr.tempout.entity.MeTempDataEntity;
import com.mozovw.oatmeal.test.llr.tempout.entity.MeTempKnowledgeEntity;

@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:com/mozovw/oatmeal/test/llr/tempout/configs/spring-tempout.xml" })
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TempOutTest {
	
	@Autowired(required = true)
	TempOutDao tempOutDao;

	@Test
	public void test() {
		System.out.println(tempOutDao);
	}
	@Test
	public void queryAllTempDate() throws Exception {
		MeTempDataEntity meTempDataEntity = tempOutDao.queryAllTempDate("");
		List<ExcelHandleDataVO> list = new ArrayList<ExcelHandleDataVO>();
		setDataVo(list, "llrCode", meTempDataEntity.getLlrCode());
		setDataVo(list, "title", meTempDataEntity.getTitle());
		setDataVo(list, "caseName", meTempDataEntity.getCaseName());
		setDataVo(list, "employeeNo", meTempDataEntity.getEmployeeNo());
		setDataVo(list, "userName", meTempDataEntity.getUserName());
		setDataVo(list, "冲压科", meTempDataEntity.getOrgName());
		setDataVo(list, "tel", meTempDataEntity.getTel());
		setDataVo(list, "2016-01-01", meTempDataEntity.getCreateDate());
		setDataVo(list, "2016-01-02", meTempDataEntity.getOccurDate());
		setDataVo(list, "PQCP", meTempDataEntity.getSourceName());
		setDataVo(list, "projectName", meTempDataEntity.getProjectName());
		setDataVo(list, "partCode", meTempDataEntity.getPartCode());
		setDataVo(list, "partName", meTempDataEntity.getPartName());
		setDataVo(list, "项目方案阶段", meTempDataEntity.getPointName());
		setDataVo(list, "caseDescription", meTempDataEntity.getCaseDescription());
		setDataVo(list, "causeAnalysis", meTempDataEntity.getCauseAnalysis());
		setDataVo(list, "tmpMeasures", meTempDataEntity.getTmpMeasures());
		setDataVo(list, "longTermMeasure", meTempDataEntity.getLongTermMeasure());
		setDataVo(list, "directive", meTempDataEntity.getDirective());
		setDataVo(list, "是", meTempDataEntity.getIsVerify());
		setDataVo(list, "directorName", meTempDataEntity.getDirectorName());
		setDataVo(list, "油漆科", meTempDataEntity.getDeptName());
		setDataVo(list, "项目", meTempDataEntity.getVerifyModeName());
		setDataVo(list, "质量", meTempDataEntity.getTypeName());
		setDataVo(list, "quota", meTempDataEntity.getQuota());
		setDataVo(list, "targetEffect", meTempDataEntity.getTargetEffect());
		setDataVo(list, "2016-01-03", meTempDataEntity.getPlanDate());
		setDataVo(list, "2016-01-04", meTempDataEntity.getActualDate());
		List<MeTempKnowledgeEntity> entitys = meTempDataEntity.getEntitys();
		int row = 13;
		for (MeTempKnowledgeEntity meTempKnowledgeEntity : entitys) {
			setDataIndexVo(list, row,2, meTempKnowledgeEntity.getDocType());
			setDataIndexVo(list, row,3, meTempKnowledgeEntity.getDocName());
			setDataIndexVo(list, row,5, meTempKnowledgeEntity.getDocType());
			setDataIndexVo(list, row,8, meTempKnowledgeEntity.getOutputModeName());
			setDataIndexVo(list, row,9, meTempKnowledgeEntity.getContent());
			setDataIndexVo(list, row,16, meTempKnowledgeEntity.getvDirectorName());
			setDataIndexVo(list, row,17, meTempKnowledgeEntity.getPlanCompletionTime());
			setDataIndexVo(list, row,18, meTempKnowledgeEntity.getActualCompletionTime());
			row++;
		}
		ExcelTempHandleUtil.replaceModel(list, 
				"src/test/resources/com/mozovw/oatmeal/test/llr/tempout/excel/aa.xlsx", 
				"src/test/resources/com/mozovw/oatmeal/test/llr/tempout/excel/bb.xlsx");
	}
	
	private List<ExcelHandleDataVO> setDataVo(List<ExcelHandleDataVO> list,String key,Object value){
		ExcelHandleDataVO e = new ExcelHandleDataVO();
		e.setKey(key);
		e.setValue(value);
		list.add(e);
		return list;
	}
	private List<ExcelHandleDataVO> setDataIndexVo(List<ExcelHandleDataVO> list,Integer row,Integer column, Object value){
		ExcelHandleDataVO e = new ExcelHandleDataVO();
		e.setRow(row);
		e.setColumn(column);
		e.setValue(value);
		list.add(e);
		return list;
	}
}
