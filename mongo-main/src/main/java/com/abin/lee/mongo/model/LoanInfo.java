package com.abin.lee.mongo.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 贷款发放信息
 * 
 * @author shixuning
 */
@Document(collection = "YOUXIN_LoanInfo")
@CompoundIndexes({ @CompoundIndex(name = "status_1", def = "{'status': 1}"),
        @CompoundIndex(name = "batchNo_1", def = "{'batchNo': 1,'batchNo':1}") })
public class LoanInfo extends BaseMongoBean {
    /**
     * 上报类型
     */
    private String reportType;
    /**
     * 组织机构代码
     */
    private String orgCode;
    // /**
    // * 合同编号
    // */
    // private String contractNo;
    /**
     * 发放编号
     */
    private String dueBillNo;
    /**
     * 借款人类别
     */
    private String customerType = DefaultContant.PL_48;
    /**
     * 借款人名称
     */
    private String customerName;
    /**
     * 借款人证件类型
     */
    private String certificateType = DefaultContant.PL_15;
    /**
     * 借款人证件号码
     */
    private String certificateNo;
    /**
     * 发放金额
     */
    private String ddAmt;
    /**
     * 贷款类别
     */
    private String loanCate = DefaultContant.PL_53;
    /**
     * 月利率(‰)
     */
    private String intRate;
    /**
     * 逾期月利率(‰)
     */
    private String priPltyRate;
    /**
     * 利率性质
     */
    private String rateType = DefaultContant.PL_52;
    /**
     * 签约日期
     */
    private String signDate;
    /**
     * 发放日期
     */
    private String ddDate;
    /**
     * 到期日期
     */
    private String matureDate;
    /**
     * 投放区域
     */
    private String zone = DefaultContant.PL_23;
    /**
     * 担保方式
     */
    private String guarType = DefaultContant.PL_24;
    /**
     * 贷款期限
     */
    private String term;
    /**
     * 贷款用途
     */
    private String purpose = DefaultContant.PL_26;
    /**
     * 贷款对象
     */
    private String loanObject = DefaultContant.PL_41;
    /**
     * 贷款对象规模
     */
    private String loanObjectSize = DefaultContant.PL_28;
    /**
     * 计息方式
     */
    private String rateCalcMode = DefaultContant.PL_27;
    /**
     * 扣款方式
     */
    private String repayMode = DefaultContant.PL_43;
    /**
     * 投放行业
     */
    private String industry = DefaultContant.PL_29;
    /**
     * 五级分类
     */
    private String riskLevel = DefaultContant.PL_51;
    /**
     * 发放状态
     */
    private String issueStatus = DefaultContant.PL_54;

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * @return the batchNo
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * @param batchNo
     *            the batchNo to set
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    // public String getContractNo() {
    // return contractNo;
    // }
    // public void setContractNo(String contractNo) {
    // this.contractNo = contractNo;
    // }
    public String getDueBillNo() {
        return dueBillNo;
    }

    public void setDueBillNo(String dueBillNo) {
        this.dueBillNo = dueBillNo;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public String getDdAmt() {
        return ddAmt;
    }

    public void setDdAmt(String ddAmt) {
        this.ddAmt = ddAmt;
    }

    /**
     * @return the loanCate
     */
    public String getLoanCate() {
        return loanCate;
    }

    /**
     * @param loanCate
     *            the loanCate to set
     */
    public void setLoanCate(String loanCate) {
        this.loanCate = loanCate;
    }

    public String getIntRate() {
        return intRate;
    }

    public void setIntRate(String intRate) {
        this.intRate = intRate;
    }

    public String getPriPltyRate() {
        return priPltyRate;
    }

    public void setPriPltyRate(String priPltyRate) {
        this.priPltyRate = priPltyRate;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public String getDdDate() {
        return ddDate;
    }

    public void setDdDate(String ddDate) {
        this.ddDate = ddDate;
    }

    public String getMatureDate() {
        return matureDate;
    }

    public void setMatureDate(String matureDate) {
        this.matureDate = matureDate;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getGuarType() {
        return guarType;
    }

    public void setGuarType(String guarType) {
        this.guarType = guarType;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getLoanObject() {
        return loanObject;
    }

    public void setLoanObject(String loanObject) {
        this.loanObject = loanObject;
    }

    public String getLoanObjectSize() {
        return loanObjectSize;
    }

    public void setLoanObjectSize(String loanObjectSize) {
        this.loanObjectSize = loanObjectSize;
    }

    public String getRateCalcMode() {
        return rateCalcMode;
    }

    public void setRateCalcMode(String rateCalcMode) {
        this.rateCalcMode = rateCalcMode;
    }

    public String getRepayMode() {
        return repayMode;
    }

    public void setRepayMode(String repayMode) {
        this.repayMode = repayMode;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(String issueStatus) {
        this.issueStatus = issueStatus;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
