package com.mozovw.oatmeal.poi.excel.helper;


import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Excel统一POI处理测试类（针对2003以前和2007以后两种格式的兼容处理）
 * @author	chengesheng
 * @date	2012-5-3 下午03:10:23
 * @note	PoiHelper
 */
public abstract class PoiExcelTest {
	// *************************************************
	// ================以下为测试代码====================
	// *************************************************
	static List<PoiEntity> list = null;
	static int i=0;
	
	public static void main(String[] args){
		String s = "guanli.xlsx";
		// 获取Excel文件的sheet列表
		//testGetSheetList(s);
		
		// 获取Excel文件的第1个sheet的内容
		//testReadExcel(s, 0);
		
		// 获取Excel文件的第2个sheet的第2、4-7行和第10行及以后的内容
		//testReadExcel(s, 1, "2,4-7,10-");
		 testReadExcel(s, 0, "2-");
		 StringBuilder sb = new StringBuilder();
		for (PoiEntity pp : list) {
			sb.append(handleToSql(pp));
			sb.append("\n");
			
		}
		PrintStream pr =null;
		try {
			pr = new PrintStream("t.txt");
			pr.print(sb.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(pr!=null)
			pr.close();
		}
		// 获取Excel文件的第3个sheet中a,b,g,h,i,j等列的所有内容
		//testReadExcel("c:/test.xls", 2, new String[] {"a","b","g","h","i","j"});
		
		// 获取Excel文件的第4个sheet的第2、4-7行和第10行及以后，a,b,g,h,i,j等列的内容
		//testReadExcel("c:/test.xlsx", 3, "2,4-7,10-", new String[] {"a","b","g","h","i","j"});
	}
	
	
	private static String handleToSql(PoiEntity p){
		DecimalFormat de  = new DecimalFormat("00000");
		StringBuilder sb = new StringBuilder();
		sb.append("insert into dbwlhr.t_ehrpe_plan(pk_ehrpe_plan,plancode,planname,planstatus,plantype,planmodel,peyear, pk_peperiod,pk_deptdoc,pk_psndoc,pk_om_job,pk_jobrank,pk_checker,ts,dr,voperatortime,voperator,psncode,psnname,checkercode,recheckercode,pk_rechecker,isequallevel,jobclass)values");
		sb.append("(");
		sb.append("jx_guid('00PL'),");
		sb.append("'PBC-2015-12-14-T"+de.format(i++)+"'");
		sb.append(",'【"+p.getEmpname()+"】2015年下半年考核方案', 8,'0001AA100000000A56J3',1,2015,'1001F1100000000HDR9J',");
		sb.append("(select pk_deptdoc from "
				+ "( select chg.pk_postdoc,chg.pk_jobrank,chg.pk_deptdoc,chg.pk_psndoc "
				+ "from dbwlhr.hi_psndoc_deptchg chg where chg.pk_psnbasdoc in"
				+ "(select psn.pk_psnbasdoc from dbwlhr.bd_psndoc psn where  "
				+ "psn.psncode='"+p.getEmpcode()+"') "
				+ "and chg.lastflag = 'N' order by chg.begindate desc)where rownum = 1),");
		sb.append("(select pk_psndoc from "
				+ "( select chg.pk_postdoc,chg.pk_jobrank,chg.pk_deptdoc,chg.pk_psndoc "
				+ "from dbwlhr.hi_psndoc_deptchg chg where chg.pk_psnbasdoc in"
				+ "(select psn.pk_psnbasdoc from dbwlhr.bd_psndoc psn where  "
				+ "psn.psncode='"+p.getEmpcode()+"') "
				+ "and chg.lastflag = 'N' order by chg.begindate desc)where rownum = 1),");
		sb.append("(select pk_postdoc from "
				+ "( select chg.pk_postdoc,chg.pk_jobrank,chg.pk_deptdoc,chg.pk_psndoc "
				+ "from dbwlhr.hi_psndoc_deptchg chg where chg.pk_psnbasdoc in"
				+ "(select psn.pk_psnbasdoc from dbwlhr.bd_psndoc psn where  "
				+ "psn.psncode='"+p.getEmpcode()+"') "
				+ "and chg.lastflag = 'N' order by chg.begindate desc)where rownum = 1),");
		sb.append("(select pk_jobrank from "
				+ "( select chg.pk_postdoc,chg.pk_jobrank,chg.pk_deptdoc,chg.pk_psndoc "
				+ "from dbwlhr.hi_psndoc_deptchg chg where chg.pk_psnbasdoc in"
				+ "(select psn.pk_psnbasdoc from dbwlhr.bd_psndoc psn where  "
				+ "psn.psncode='"+p.getEmpcode()+"') "
				+ "and chg.lastflag = 'N' order by chg.begindate desc)where rownum = 1),");
		sb.append("(select psn.pk_psndoc from dbwlhr.bd_psndoc psn where psn.psncode ='"+p.getCheckcode()+"' and psn.psnclscope in(0,5)),");
		sb.append("to_char(sysdate,'yyyy-MM-dd hh24:mi:ss'),0,to_char(sysdate,'yyyy-MM-dd'),'0001F110000000B3IS0G',");
		sb.append("'"+p.getEmpcode()+"',");
		sb.append("'"+p.getEmpname()+"',");
		sb.append("'"+p.getCheckcode()+"',");
		sb.append("'"+p.getRecheckcode()+"',");
		sb.append("(select psn.pk_psndoc from dbwlhr.bd_psndoc psn where psn.psncode ='"+p.getRecheckcode()+"' and psn.psnclscope in(0,5)),");
		sb.append("'N','M'");
		sb.append(");");
		return sb.toString();
	}
	
	// 测试获取sheet列表
	private static void testGetSheetList(String filePath) {
		PoiExcelHelper helper = getPoiExcelHelper(filePath);
		
		// 获取Sheet列表
		ArrayList<String> sheets = helper.getSheetList(filePath);
		
		// 打印Excel的Sheet列表
		printList(filePath, sheets);
	}
	
	// 测试Excel读取
	private static void testReadExcel(String filePath, int sheetIndex) {
		PoiExcelHelper helper = getPoiExcelHelper(filePath);
		
		// 读取excel文件数据
		ArrayList<ArrayList<String>> dataList = helper.readExcel(filePath, sheetIndex);
		
		// 打印单元格数据
		printBody(dataList);
	}
	
	// 测试Excel读取
	private static void testReadExcel(String filePath, int sheetIndex, String rows) {
		PoiExcelHelper helper = getPoiExcelHelper(filePath);
		
		// 读取excel文件数据
		ArrayList<ArrayList<String>> dataList = helper.readExcel(filePath, sheetIndex, rows);
		
		// 打印单元格数据
		printBody(dataList);
	}
	
	// 测试Excel读取
	private static void testReadExcel(String filePath, int sheetIndex, String[] columns) {
		PoiExcelHelper helper = getPoiExcelHelper(filePath);
		
		// 读取excel文件数据
		ArrayList<ArrayList<String>> dataList = helper.readExcel(filePath, sheetIndex, columns);
		
		// 打印列标题
		printHeader(columns);
		
		// 打印单元格数据
		printBody(dataList);
	}
	
	// 测试Excel读取
	private static void testReadExcel(String filePath, int sheetIndex, String rows, String[] columns) {
		PoiExcelHelper helper = getPoiExcelHelper(filePath);
		
		// 读取excel文件数据
		ArrayList<ArrayList<String>> dataList = helper.readExcel(filePath, sheetIndex, rows, columns);
		
		// 打印列标题
		printHeader(columns);
		
		// 打印单元格数据
		printBody(dataList);
	}
	
	// 获取Excel处理类
	private static PoiExcelHelper getPoiExcelHelper(String filePath) {
		PoiExcelHelper helper;
		if(filePath.indexOf(".xlsx")!=-1) {
			helper = new PoiExcel2k7Helper();
		}else {
			helper = new PoiExcel2k3Helper();
		}
		return helper;
	}

	// 打印Excel的Sheet列表
	private static void printList(String filePath, ArrayList<String> sheets) {
		System.out.println();
		for(String sheet : sheets) {
			System.out.println(filePath + " ==> " + sheet);
		}
	}

	// 打印列标题
	private static void printHeader(String[] columns) {
		System.out.println();
		for(String column : columns) {
			System.out.print("\t\t" + column.toUpperCase());
		}
	}

	// 打印单元格数据
	private static void printBody(ArrayList<ArrayList<String>> dataList) {
		int index = 0;
		List<PoiEntity> list2 = new ArrayList<PoiEntity>();
		for(ArrayList<String> data : dataList) {
			index ++;
			//System.out.println();
			//System.out.print(index);
			PoiEntity p = new PoiEntity();
			p.setId(String.valueOf(index));
			p.setEmpcode(data.get(0));
			p.setEmpname(data.get(1));
			p.setPlanmodel(data.get(2));
			p.setPeriod(data.get(3));
			p.setYear(data.get(4));
			p.setDeptname(data.get(5));
			p.setJobname(data.get(6));
			p.setCheckcode(data.get(7));
			p.setCheckname(data.get(8));
			p.setRecheckcode(data.get(9));
			p.setRecheckname(data.get(10));
			p.setCorpname(data.get(11));
			list2.add(p);
			for(String v : data) {
				//System.out.print("\t" + v);
			}
		}
		list=list2;
	}
}


class PoiEntity{
	private String id;
	private String empcode;
	private String empname;
	private String planmodel;
	private String period;
	private String year;
	private String deptname;
	private String jobname;
	private String checkcode;
	private String checkname;
	private String recheckcode;
	private String recheckname;
	private String corpname;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmpcode() {
		return empcode;
	}
	public void setEmpcode(String empcode) {
		this.empcode = empcode;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getPlanmodel() {
		return planmodel;
	}
	public void setPlanmodel(String planmodel) {
		this.planmodel = planmodel;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	public String getCheckcode() {
		return checkcode;
	}
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	public String getCheckname() {
		return checkname;
	}
	public void setCheckname(String checkname) {
		this.checkname = checkname;
	}
	public String getRecheckcode() {
		return recheckcode;
	}
	public void setRecheckcode(String recheckcode) {
		this.recheckcode = recheckcode;
	}
	public String getRecheckname() {
		return recheckname;
	}
	public void setRecheckname(String recheckname) {
		this.recheckname = recheckname;
	}
	public String getCorpname() {
		return corpname;
	}
	public void setCorpname(String corpname) {
		this.corpname = corpname;
	}
	
	
	
}
