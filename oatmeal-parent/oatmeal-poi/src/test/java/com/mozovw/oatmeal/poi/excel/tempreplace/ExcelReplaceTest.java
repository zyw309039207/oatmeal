package com.mozovw.oatmeal.poi.excel.tempreplace;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mozovw.oatmeal.poi.excel.tempreplace.entity.ExcelHandleDataVO;
import com.mozovw.oatmeal.poi.excel.tempreplace.util.ExcelTempHandleUtil;
import com.mozovw.oatmeal.root.test.BaseTestCase;

public class ExcelReplaceTest extends BaseTestCase{

	@Test
	public void testTeplaceModel() {

		List<ExcelHandleDataVO> datas = new ArrayList<ExcelHandleDataVO>();
		ExcelHandleDataVO vo1 = new ExcelHandleDataVO();
		vo1.setKey("dd");
		vo1.setValue("XXX有限公司");
		ExcelHandleDataVO vo2 = new ExcelHandleDataVO();
		vo2.setRow(1);
		vo2.setColumn(5);
		vo2.setValue("aa替换的内容aa");
		datas.add(vo1);
		datas.add(vo2);
		ExcelTempHandleUtil
				.replaceModel(
						datas,
						"src/test/resources/com/mozovw/oatmeal/poi/excel/tempreplace/excel/2k7.xlsx",
						"src/test/resources/com/mozovw/oatmeal/poi/excel/tempreplace/excel/2k7-2.xlsx");
	}

	@Test
	public void testTeplaceModel2() {
		List<ExcelHandleDataVO> datas = new ArrayList<ExcelHandleDataVO>();
		ExcelHandleDataVO vo1 = new ExcelHandleDataVO();
		vo1.setKey("修订");
		vo1.setValue("新增");
		datas.add(vo1);
		ExcelTempHandleUtil
				.replaceModel(
						datas,
						"src/test/resources/com/mozovw/oatmeal/poi/excel/tempreplace/excel/aa.xlsx",
						"src/test/resources/com/mozovw/oatmeal/poi/excel/tempreplace/excel/bb.xlsx");
	}
}