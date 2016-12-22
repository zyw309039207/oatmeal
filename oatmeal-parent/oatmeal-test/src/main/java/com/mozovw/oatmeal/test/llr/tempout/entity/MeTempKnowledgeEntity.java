package com.mozovw.oatmeal.test.llr.tempout.entity;

import com.mozovw.oatmeal.common.base.entity.BaseEntity;

public class MeTempKnowledgeEntity extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7307591278862549708L;
	private String docType;
	private String docName;
	private String docCode;
	private String outputModeName;
	private String content;
	private String vDirectorName;
	private String planCompletionTime;
	private String actualCompletionTime;
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getDocCode() {
		return docCode;
	}
	public void setDocCode(String docCode) {
		this.docCode = docCode;
	}
	public String getOutputModeName() {
		return outputModeName;
	}
	public void setOutputModeName(String outputModeName) {
		this.outputModeName = outputModeName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getvDirectorName() {
		return vDirectorName;
	}
	public void setvDirectorName(String vDirectorName) {
		this.vDirectorName = vDirectorName;
	}
	public String getPlanCompletionTime() {
		return planCompletionTime;
	}
	public void setPlanCompletionTime(String planCompletionTime) {
		this.planCompletionTime = planCompletionTime;
	}
	public String getActualCompletionTime() {
		return actualCompletionTime;
	}
	public void setActualCompletionTime(String actualCompletionTime) {
		this.actualCompletionTime = actualCompletionTime;
	}
	
	
}
