package com.mozovw.oatmeal.easypoi.excel.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.result.ExcelImportResult;
import org.jeecgframework.poi.util.PoiPublicUtil;
import org.junit.Test;

import com.mozovw.oatmeal.easypoi.excel.utils.entity.ExcelVerifyEntity;
import com.mozovw.oatmeal.easypoi.excel.utils.entity.Guy;
import com.mozovw.oatmeal.root.test.BaseTestCase;

public class ExcelImportUtilTest extends BaseTestCase {

	@Test
	public void testImportExcelBySax() {
		try {
			ImportParams params = new ImportParams();
			params.setTitleRows(1);
			List<Object> list = ExcelImportUtil
					.importExcelBySax(
							new FileInputStream(
									new File(
											PoiPublicUtil
													.getWebRootPath("com/mozovw/oatmeal/easypoi/excel/utils/excelimport.xlsx"))),
							Guy.class, params);
			showList(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testImportExcel() {
		try {
			ImportParams params = new ImportParams();
			params.setTitleRows(1);
			List<Map<String, Object>> list = ExcelImportUtil
					.importExcel(
							new File(
									PoiPublicUtil
											.getWebRootPath("com/mozovw/oatmeal/easypoi/excel/utils/excelimport.xlsx")),
							Map.class, params);
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testImportExcelVerify() {
		try {
			ImportParams params = new ImportParams();
			params.setNeedVerfiy(true);
			ExcelImportResult<Object> result = ExcelImportUtil
					.importExcelVerify(
							new File(
									PoiPublicUtil
											.getWebRootPath("com/mozovw/oatmeal/easypoi/excel/utils/excelverfiy.xlsx")),
							ExcelVerifyEntity.class, params);
			FileOutputStream fos = new FileOutputStream("src/test/resources/com/mozovw/oatmeal/easypoi/excel/utils/excelverfiy_2.xlsx");
			result.getWorkbook().write(fos);
			fos.close();
			showList(result.getList());
			System.out.println(result.isVerfiyFail());
			System.out.println(result.getList().size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
