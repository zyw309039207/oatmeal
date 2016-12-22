package com.mozovw.oatmeal.poi.excel.tempreplace.entity;

/**
 * @ClassName: ExcelHandleDataVO 
 * @Description: Excel替换内容存储对象 
 * @author Frank
 */
public class ExcelHandleDataVO {
	private Integer row;// Excel单元格行
	private Integer column;// Excel单元格列
	private String key;
	private Object value;// 替换的文本

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Integer getColumn() {
		return column;
	}

	public void setColumn(Integer column) {
		this.column = column;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
}
