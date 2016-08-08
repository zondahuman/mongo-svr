/**
 * 
 */
package com.abin.lee.mongo.model;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 贷款合同信息上报
 * 
 * @author lining
 */
@Document(collection = "YOUXIN_LoanAgreementInfo")
@CompoundIndexes({
        @CompoundIndex(name = "contractNo_1", def = "{'contractNo': 1}"),
        @CompoundIndex(name = "realTimeSyncStatus_1_loanAgreementSyncStatus_1", def = "{'realTimeSyncStatus': 1,'loanAgreementSyncStatus':1}") })
public class LoanAgreementInfo extends BaseMongoBean {
    private String reportType; // 上报类型
    private String orgCode; // 组织机构代码
    // private String contractNo; // 合同编号
    private String loanCate; // 贷款类别
    private String contractName; // 合同名称
    private String customerType; // 借款人类别
    private String customerName; // 借款人名称
    private String certificateType; // 借款人证件类型
    private String certificateNo; // 借款人证件号码
    private String loanObject; // 贷款对象
    private String loanObjectSize; // 贷款对象规模
    private String contractSignDate; // 合同签订日期
    private String contractBeginDate; // 合同有效起始日期
    private String contractEndDate; // 合同有效结束日期
    private String contractAmount; // 合同金额
    private String outstanding; // 贷款余额
    private String guarType; // 担保方式
    private String ccy; // 币种
    private String isRealQuotaLoan; // 是否额度项下贷款
    private String intRate; // 月利率(‰)
    private String priPltyRate; // 逾期月利率(‰)
    private String contractStatus; // 合同状态
    private String relationManager; // 客户经理
    private String disputeScheme; // 争议解决方式
    private String linkman; // 联系人
    private String telephone; // 联系电话
    private String realTimeSyncStatus;// 实时同步状态 处理中、处理成功、处理失败
    private String loanAgreementSyncStatus;// 合同上报同步状态
    private String loanOfferSyncStatus;// 贷款发放同步状态
    private String loanRecoverySyncStatus;// 贷款回收计划同步状态
    private String repaymentPlanSyncStatus;// 还款计划同步状态
    /**
     * 批次号
     */
    private String batchNo;

    /**
     * @return the reportType
     */
    public String getReportType() {
        return reportType;
    }

    /**
     * @param reportType
     *            the reportType to set
     */
    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    /**
     * @return the orgCode
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * @param orgCode
     *            the orgCode to set
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    // /**
    // * @return the contractNo
    // */
    // public String getContractNo() {
    // return contractNo;
    // }
    //
    // /**
    // * @param contractNo
    // * the contractNo to set
    // */
    // public void setContractNo(String contractNo) {
    // this.contractNo = contractNo;
    // }

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

    /**
     * @return the contractName
     */
    public String getContractName() {
        return contractName;
    }

    /**
     * @param contractName
     *            the contractName to set
     */
    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    /**
     * @return the customerType
     */
    public String getCustomerType() {
        return customerType;
    }

    /**
     * @param customerType
     *            the customerType to set
     */
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName
     *            the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the certificateType
     */
    public String getCertificateType() {
        return certificateType;
    }

    /**
     * @param certificateType
     *            the certificateType to set
     */
    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    /**
     * @return the certificateNo
     */
    public String getCertificateNo() {
        return certificateNo;
    }

    /**
     * @param certificateNo
     *            the certificateNo to set
     */
    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    /**
     * @return the loanObject
     */
    public String getLoanObject() {
        return loanObject;
    }

    /**
     * @param loanObject
     *            the loanObject to set
     */
    public void setLoanObject(String loanObject) {
        this.loanObject = loanObject;
    }

    /**
     * @return the loanObjectSize
     */
    public String getLoanObjectSize() {
        return loanObjectSize;
    }

    /**
     * @param loanObjectSize
     *            the loanObjectSize to set
     */
    public void setLoanObjectSize(String loanObjectSize) {
        this.loanObjectSize = loanObjectSize;
    }

    /**
     * @return the contractSignDate
     */
    public String getContractSignDate() {
        return contractSignDate;
    }

    /**
     * @param contractSignDate
     *            the contractSignDate to set
     */
    public void setContractSignDate(String contractSignDate) {
        this.contractSignDate = contractSignDate;
    }

    /**
     * @return the contractBeginDat
     */
    public String getContractBeginDate() {
        return contractBeginDate;
    }

    /**
     * @param contractBeginDat
     *            the contractBeginDat to set
     */
    public void setContractBeginDate(String contractBeginDate) {
        this.contractBeginDate = contractBeginDate;
    }

    /**
     * @return the contractEndDate
     */
    public String getContractEndDate() {
        return contractEndDate;
    }

    /**
     * @param contractEndDate
     *            the contractEndDate to set
     */
    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    /**
     * @return the contractAmount
     */
    public String getContractAmount() {
        return contractAmount;
    }

    /**
     * @param contractAmount
     *            the contractAmount to set
     */
    public void setContractAmount(String contractAmount) {
        this.contractAmount = contractAmount;
    }

    /**
     * @return the outstanding
     */
    public String getOutstanding() {
        return outstanding;
    }

    /**
     * @param outstanding
     *            the outstanding to set
     */
    public void setOutstanding(String outstanding) {
        this.outstanding = outstanding;
    }

    /**
     * @return the guarType
     */
    public String getGuarType() {
        return guarType;
    }

    /**
     * @param guarType
     *            the guarType to set
     */
    public void setGuarType(String guarType) {
        this.guarType = guarType;
    }

    /**
     * @return the ccy
     */
    public String getCcy() {
        return ccy;
    }

    /**
     * @param ccy
     *            the ccy to set
     */
    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    /**
     * @return the isRealQuotaLoan
     */
    public String getIsRealQuotaLoan() {
        return isRealQuotaLoan;
    }

    /**
     * @param isRealQuotaLoan
     *            the isRealQuotaLoan to set
     */
    public void setIsRealQuotaLoan(String isRealQuotaLoan) {
        this.isRealQuotaLoan = isRealQuotaLoan;
    }

    /**
     * @return the intRate
     */
    public String getIntRate() {
        return intRate;
    }

    /**
     * @param intRate
     *            the intRate to set
     */
    public void setIntRate(String intRate) {
        this.intRate = intRate;
    }

    /**
     * @return the priPltyRate
     */
    public String getPriPltyRate() {
        return priPltyRate;
    }

    /**
     * @param priPltyRate
     *            the priPltyRate to set
     */
    public void setPriPltyRate(String priPltyRate) {
        this.priPltyRate = priPltyRate;
    }

    /**
     * @return the contractStatus
     */
    public String getContractStatus() {
        return contractStatus;
    }

    /**
     * @param contractStatus
     *            the contractStatus to set
     */
    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    /**
     * @return the relationManager
     */
    public String getRelationManager() {
        return relationManager;
    }

    /**
     * @param relationManager
     *            the relationManager to set
     */
    public void setRelationManager(String relationManager) {
        this.relationManager = relationManager;
    }

    /**
     * @return the disputeScheme
     */
    public String getDisputeScheme() {
        return disputeScheme;
    }

    /**
     * @param disputeScheme
     *            the disputeScheme to set
     */
    public void setDisputeScheme(String disputeScheme) {
        this.disputeScheme = disputeScheme;
    }

    /**
     * @return the linkman
     */
    public String getLinkman() {
        return linkman;
    }

    /**
     * @param linkman
     *            the linkman to set
     */
    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone
     *            the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the realTimeSyncStatus
     */
    public String getRealTimeSyncStatus() {
        return realTimeSyncStatus;
    }

    /**
     * @param realTimeSyncStatus
     *            the realTimeSyncStatus to set
     */
    public void setRealTimeSyncStatus(String realTimeSyncStatus) {
        this.realTimeSyncStatus = realTimeSyncStatus;
    }

    /**
     * @return the loanAgreementSyncStatus
     */
    public String getLoanAgreementSyncStatus() {
        return loanAgreementSyncStatus;
    }

    /**
     * @param loanAgreementSyncStatus
     *            the loanAgreementSyncStatus to set
     */
    public void setLoanAgreementSyncStatus(String loanAgreementSyncStatus) {
        this.loanAgreementSyncStatus = loanAgreementSyncStatus;
    }

    /**
     * @return the repaymentPlanSyncStatus
     */
    public String getRepaymentPlanSyncStatus() {
        return repaymentPlanSyncStatus;
    }

    /**
     * @param repaymentPlanSyncStatus
     *            the repaymentPlanSyncStatus to set
     */
    public void setRepaymentPlanSyncStatus(String repaymentPlanSyncStatus) {
        this.repaymentPlanSyncStatus = repaymentPlanSyncStatus;
    }

    public String getLoanRecoverySyncStatus() {
        return loanRecoverySyncStatus;
    }

    public void setLoanRecoverySyncStatus(String loanRecoverySyncStatus) {
        this.loanRecoverySyncStatus = loanRecoverySyncStatus;
    }

    /**
     * @return the loanOfferSyncStatus
     */
    public String getLoanOfferSyncStatus() {
        return loanOfferSyncStatus;
    }

    /**
     * @param loanOfferSyncStatus
     *            the loanOfferSyncStatus to set
     */
    public void setLoanOfferSyncStatus(String loanOfferSyncStatus) {
        this.loanOfferSyncStatus = loanOfferSyncStatus;
    }

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

}
