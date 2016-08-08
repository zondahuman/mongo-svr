/**
 * 
 */
package com.abin.lee.mongo.model;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 贷款回收信息上报
 * 
 * @author lining
 */
@Document(collection = "YOUXIN_LoanRecoveryInfo")
@CompoundIndexes({ @CompoundIndex(name = "status_1", def = "{'status': 1}"),
        @CompoundIndex(name = "batchNo_1", def = "{'batchNo': 1,'batchNo':1}") })
public class LoanRecoveryInfo extends BaseMongoBean {
    private String reportType; // 上报类型
    private String orgCode; // 组织机构代码
    // private String contractNo; // 合同编号
    private String dueBillNo; // 发放编号
    private String repayDate; // 回收日期
    private String counter; // 还款期数
    private String customerType; // 借款人类别
    private String customerName; // 借款人名称
    private String certificateType; // 借款人证件类型
    private String certificateNo; // 借款人证件号码
    private String gatherMode; // 扣款方式
    private String repayPriAmt; // 收回本金(元)
    private String repayIntAmt; // 收回利息(元)
    private String startDate; // 起息日期
    private String endDate; // 止息日期
    private String receiptType; // 回收类型
    private String delayDays; // 逾期天数
    private String delayAmt; // 逾期本金(元)
    private String delayInterest; // 逾期利息(元)
    private String delayFee; // 逾期滞纳金(元)
    private String priPltyRate; // 逾期月利率(‰)
    private String remark; // 备注
    private String reservedField1; // 保留域1
    private String reservedField2; // 保留域2
    private String reservedField3; // 保留域3

    private String feeDetailId;// mysql 数据库 fee_detail_log表主键
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
     * @return the dueBillNo
     */
    public String getDueBillNo() {
        return dueBillNo;
    }

    /**
     * @param dueBillNo
     *            the dueBillNo to set
     */
    public void setDueBillNo(String dueBillNo) {
        this.dueBillNo = dueBillNo;
    }

    /**
     * @return the repayDate
     */
    public String getRepayDate() {
        return repayDate;
    }

    /**
     * @param repayDate
     *            the repayDate to set
     */
    public void setRepayDate(String repayDate) {
        this.repayDate = repayDate;
    }

    /**
     * @return the counter
     */
    public String getCounter() {
        return counter;
    }

    /**
     * @param counter
     *            the counter to set
     */
    public void setCounter(String counter) {
        this.counter = counter;
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
     * @return the gatherMode
     */
    public String getGatherMode() {
        return gatherMode;
    }

    /**
     * @param gatherMode
     *            the gatherMode to set
     */
    public void setGatherMode(String gatherMode) {
        this.gatherMode = gatherMode;
    }

    /**
     * @return the repayPriAmt
     */
    public String getRepayPriAmt() {
        return repayPriAmt;
    }

    /**
     * @param repayPriAmt
     *            the repayPriAmt to set
     */
    public void setRepayPriAmt(String repayPriAmt) {
        this.repayPriAmt = repayPriAmt;
    }

    /**
     * @return the repayIntAmt
     */
    public String getRepayIntAmt() {
        return repayIntAmt;
    }

    /**
     * @param repayIntAmt
     *            the repayIntAmt to set
     */
    public void setRepayIntAmt(String repayIntAmt) {
        this.repayIntAmt = repayIntAmt;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate
     *            the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate
     *            the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the receiptType
     */
    public String getReceiptType() {
        return receiptType;
    }

    /**
     * @param receiptType
     *            the receiptType to set
     */
    public void setReceiptType(String receiptType) {
        this.receiptType = receiptType;
    }

    /**
     * @return the delayDays
     */
    public String getDelayDays() {
        return delayDays;
    }

    /**
     * @param delayDays
     *            the delayDays to set
     */
    public void setDelayDays(String delayDays) {
        this.delayDays = delayDays;
    }

    /**
     * @return the delayAmt
     */
    public String getDelayAmt() {
        return delayAmt;
    }

    /**
     * @param delayAmt
     *            the delayAmt to set
     */
    public void setDelayAmt(String delayAmt) {
        this.delayAmt = delayAmt;
    }

    /**
     * @return the delayInterest
     */
    public String getDelayInterest() {
        return delayInterest;
    }

    /**
     * @param delayInterest
     *            the delayInterest to set
     */
    public void setDelayInterest(String delayInterest) {
        this.delayInterest = delayInterest;
    }

    /**
     * @return the delayFee
     */
    public String getDelayFee() {
        return delayFee;
    }

    /**
     * @param delayFee
     *            the delayFee to set
     */
    public void setDelayFee(String delayFee) {
        this.delayFee = delayFee;
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
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     *            the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return the reservedField1
     */
    public String getReservedField1() {
        return reservedField1;
    }

    /**
     * @param reservedField1
     *            the reservedField1 to set
     */
    public void setReservedField1(String reservedField1) {
        this.reservedField1 = reservedField1;
    }

    /**
     * @return the reservedField2
     */
    public String getReservedField2() {
        return reservedField2;
    }

    /**
     * @param reservedField2
     *            the reservedField2 to set
     */
    public void setReservedField2(String reservedField2) {
        this.reservedField2 = reservedField2;
    }

    /**
     * @return the reservedField3
     */
    public String getReservedField3() {
        return reservedField3;
    }

    /**
     * @param reservedField3
     *            the reservedField3 to set
     */
    public void setReservedField3(String reservedField3) {
        this.reservedField3 = reservedField3;
    }

    /**
     * @return the feeDetailId
     */
    public String getFeeDetailId() {
        return feeDetailId;
    }

    /**
     * @param feeDetailId
     *            the feeDetailId to set
     */
    public void setFeeDetailId(String feeDetailId) {
        this.feeDetailId = feeDetailId;
    }

}
