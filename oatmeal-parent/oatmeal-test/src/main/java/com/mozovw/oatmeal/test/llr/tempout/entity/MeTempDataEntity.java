package com.mozovw.oatmeal.test.llr.tempout.entity;

import java.util.List;

import com.mozovw.oatmeal.common.base.entity.BaseEntity;

public class MeTempDataEntity extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2567726486035718651L;
	private String llrCode;
	private String title;
	private String caseName;
	private String employeeNo;
	private String userName;
	private String orgName;
	private String tel;
	private String createDate;
	private String occurDate;
	private String sourceName;
	private String projectName;
	private String partCode;
	private String partName;
	private String pointName;
	private String caseDescription;
	private String causeAnalysis;
	private String tmpMeasures;
	private String longTermMeasure;
	private String directive;
	private String isVerify;
	private String directorName;
	private String deptName;
	private String verifyModeName;
	private String typeName;
	private String quota;
	private String targetEffect;
	private String planDate;
	private String actualDate;
	
	private List<MeTempKnowledgeEntity> entitys;
	
	
	public List<MeTempKnowledgeEntity> getEntitys() {
		return entitys;
	}
	public void setEntitys(List<MeTempKnowledgeEntity> entitys) {
		this.entitys = entitys;
	}
	
	public String getLlrCode() {
		return llrCode;
	}
	public void setLlrCode(String llrCode) {
		this.llrCode = llrCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCaseName() {
		return caseName;
	}
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	public String getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getOccurDate() {
		return occurDate;
	}
	public void setOccurDate(String occurDate) {
		this.occurDate = occurDate;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getPartCode() {
		return partCode;
	}
	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getPointName() {
		return pointName;
	}
	public void setPointName(String pointName) {
		this.pointName = pointName;
	}
	public String getCaseDescription() {
		return caseDescription;
	}
	public void setCaseDescription(String caseDescription) {
		this.caseDescription = caseDescription;
	}
	public String getCauseAnalysis() {
		return causeAnalysis;
	}
	public void setCauseAnalysis(String causeAnalysis) {
		this.causeAnalysis = causeAnalysis;
	}
	public String getTmpMeasures() {
		return tmpMeasures;
	}
	public void setTmpMeasures(String tmpMeasures) {
		this.tmpMeasures = tmpMeasures;
	}
	public String getLongTermMeasure() {
		return longTermMeasure;
	}
	public void setLongTermMeasure(String longTermMeasure) {
		this.longTermMeasure = longTermMeasure;
	}
	public String getDirective() {
		return directive;
	}
	public void setDirective(String directive) {
		this.directive = directive;
	}
	public String getIsVerify() {
		return isVerify;
	}
	public void setIsVerify(String isVerify) {
		this.isVerify = isVerify;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	public String getVerifyModeName() {
		return verifyModeName;
	}
	public void setVerifyModeName(String verifyModeName) {
		this.verifyModeName = verifyModeName;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getQuota() {
		return quota;
	}
	public void setQuota(String quota) {
		this.quota = quota;
	}
	public String getTargetEffect() {
		return targetEffect;
	}
	public void setTargetEffect(String targetEffect) {
		this.targetEffect = targetEffect;
	}
	public String getPlanDate() {
		return planDate;
	}
	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}
	public String getActualDate() {
		return actualDate;
	}
	public void setActualDate(String actualDate) {
		this.actualDate = actualDate;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
	
}
