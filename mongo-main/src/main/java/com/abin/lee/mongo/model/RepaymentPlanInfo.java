package com.abin.lee.mongo.model;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * 还款计划
 * 
 * @author shixuning
 */

@Document(collection = "YOUXIN_RepaymentPlanInfo")
@CompoundIndexes({ @CompoundIndex(name = "status_1", def = "{'status': 1}"),
        @CompoundIndex(name = "batchNo_1", def = "{'batchNo': 1,'batchNo':1}") })
public class RepaymentPlanInfo extends BaseMongoBean {
    List<RepaymentPlan> repaymentPlan;
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
     * @return the repaymentPlan
     */
    public List<RepaymentPlan> getRepaymentPlan() {
        return repaymentPlan;
    }

    /**
     * @param repaymentPlan
     *            the repaymentPlan to set
     */
    public void setRepaymentPlan(List<RepaymentPlan> repaymentPlan) {
        this.repaymentPlan = repaymentPlan;
    }

}
