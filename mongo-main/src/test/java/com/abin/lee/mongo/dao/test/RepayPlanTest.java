package com.abin.lee.mongo.dao.test;

import com.abin.lee.mongo.dao.base.MongoDao;
import com.abin.lee.mongo.dao.test.base.AbstractJunitTemplate;
import com.abin.lee.mongo.model.*;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.BasicQuery;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 16-4-13
 * Time: 下午3:28
 * To change this template use File | Settings | File Templates.
 */
public class RepayPlanTest extends AbstractJunitTemplate {
    @Autowired
    MongoDao<PushMessage> mongoDao;
    @Autowired
    MongoDao<LoanAgreementInfo> loanAgreementInfoMongoDao;
    @Autowired
    MongoDao<LoanInfo> loanInfoMongoDao;
    @Autowired
    MongoDao<RepaymentPlanInfo> repaymentPlanInfoMongoDao;
    @Autowired
    MongoDao<LoanRecoveryInfo> loanRecoveryInfoMongoDao;

    @Test
    public void testRepayPlan() {
//        Query query = new Query(Criteria.where("syncStatus").is("QUERY_FAILED"));
//        this.updateContract();
        this.updateRepaymentPlanInfoQuery();
        this.updateRepaymentPlanInfoFAILED();
        this.updateRepaymentPlanInfoRepeated();
//        this.updateLoanRecoveryInfo();
    }



    @Test
    public void testupdateRepaymentPlanInfoPending() {
        this.updateRepaymentPlanInfoPending();

    }






    public void updateRepaymentPlanInfoQuery() {
        BasicQuery query = new BasicQuery("{ repaymentPlanSyncStatus : 'QUERY_FAILED' }");
        List<LoanAgreementInfo> loanAgreementInfoList = this.loanAgreementInfoMongoDao.findList(query, LoanAgreementInfo.class);
        if (CollectionUtils.isNotEmpty(loanAgreementInfoList)) {
            System.out.println("loanAgreementInfoList : " + loanAgreementInfoList);
            System.out.println("loanAgreementInfoList_id : " + loanAgreementInfoList.get(0).get_id().toString());
            for (Iterator<LoanAgreementInfo> iterator = loanAgreementInfoList.iterator(); iterator.hasNext(); ) {
                LoanAgreementInfo loanAgreementInfo = iterator.next();
                Map<String, Object> request = Maps.newHashMap();
                request.put("repaymentPlanSyncStatus", "INIT");
                request.put("syncStatus", "INIT");
                this.loanAgreementInfoMongoDao.updateById(LoanAgreementInfo.class, loanAgreementInfo.get_id().toString(), request);
            }
        }

        BasicQuery query1 = new BasicQuery("{ syncStatus : 'QUERY_FAILED' }");
        List<RepaymentPlanInfo> repaymentPlanInfoList = this.repaymentPlanInfoMongoDao.findList(query1, RepaymentPlanInfo.class);
        if (CollectionUtils.isNotEmpty(repaymentPlanInfoList)) {
            System.out.println("repaymentPlanInfoList : " + repaymentPlanInfoList);
            System.out.println("repaymentPlanInfoList-id : " + repaymentPlanInfoList.get(0).get_id().toString());
            for (Iterator<RepaymentPlanInfo> iterator = repaymentPlanInfoList.iterator(); iterator.hasNext(); ) {
                RepaymentPlanInfo repaymentPlanInfo = iterator.next();
                this.repaymentPlanInfoMongoDao.updateById(RepaymentPlanInfo.class, repaymentPlanInfo.get_id().toString(), "syncStatus", "INIT");
            }
        }
    }

    public void updateRepaymentPlanInfoFAILED() {
        BasicQuery query = new BasicQuery("{ repaymentPlanSyncStatus : 'FAILED' }");
        List<LoanAgreementInfo> loanAgreementInfoList = this.loanAgreementInfoMongoDao.findList(query, LoanAgreementInfo.class);
        if (CollectionUtils.isNotEmpty(loanAgreementInfoList)) {
            System.out.println("loanAgreementInfoList : " + loanAgreementInfoList);
            System.out.println("loanAgreementInfoList_id : " + loanAgreementInfoList.get(0).get_id().toString());
            for (Iterator<LoanAgreementInfo> iterator = loanAgreementInfoList.iterator(); iterator.hasNext(); ) {
                LoanAgreementInfo loanAgreementInfo = iterator.next();
                Map<String, Object> request = Maps.newHashMap();
                request.put("repaymentPlanSyncStatus", "INIT");
                request.put("syncStatus", "INIT");
                this.loanAgreementInfoMongoDao.updateById(LoanAgreementInfo.class, loanAgreementInfo.get_id().toString(), request);
            }
        }

        BasicQuery query1 = new BasicQuery("{ syncStatus : 'FAILED' }");
        List<RepaymentPlanInfo> repaymentPlanInfoList = this.repaymentPlanInfoMongoDao.findList(query1, RepaymentPlanInfo.class);
        if (CollectionUtils.isNotEmpty(repaymentPlanInfoList)) {
            System.out.println("repaymentPlanInfoList : " + repaymentPlanInfoList);
            System.out.println("repaymentPlanInfoList-id : " + repaymentPlanInfoList.get(0).get_id().toString());
            for (Iterator<RepaymentPlanInfo> iterator = repaymentPlanInfoList.iterator(); iterator.hasNext(); ) {
                RepaymentPlanInfo repaymentPlanInfo = iterator.next();
                this.repaymentPlanInfoMongoDao.updateById(RepaymentPlanInfo.class, repaymentPlanInfo.get_id().toString(), "syncStatus", "INIT");
            }
        }
    }


    public void updateRepaymentPlanInfoRepeated() {
        BasicQuery query = new BasicQuery("{ repaymentPlanSyncStatus : 'REPEAT_REPORT_FAILED' }");
        List<LoanAgreementInfo> loanAgreementInfoList = this.loanAgreementInfoMongoDao.findList(query, LoanAgreementInfo.class);
        if (CollectionUtils.isNotEmpty(loanAgreementInfoList)) {
            System.out.println("loanAgreementInfoList : " + loanAgreementInfoList);
            System.out.println("loanAgreementInfoList_id : " + loanAgreementInfoList.get(0).get_id().toString());
            for (Iterator<LoanAgreementInfo> iterator = loanAgreementInfoList.iterator(); iterator.hasNext(); ) {
                LoanAgreementInfo loanAgreementInfo = iterator.next();
                Map<String, Object> request = Maps.newHashMap();
                request.put("repaymentPlanSyncStatus", "SUCCESS");
                request.put("syncStatus", "SUCCESS");
                this.loanAgreementInfoMongoDao.updateById(LoanAgreementInfo.class, loanAgreementInfo.get_id().toString(), request);
            }
        }


    }


    public void updateRepaymentPlanInfoPending() {
        BasicQuery query = new BasicQuery("{ syncStatus : 'PENDING' }");
        List<RepaymentPlanInfo> repaymentPlanInfoList = this.repaymentPlanInfoMongoDao.findList(query, RepaymentPlanInfo.class);
        if (CollectionUtils.isNotEmpty(repaymentPlanInfoList)) {
            System.out.println("repaymentPlanInfoList : " + repaymentPlanInfoList);
            System.out.println("repaymentPlanInfoList-id : " + repaymentPlanInfoList.get(0).get_id().toString());
            for (Iterator<RepaymentPlanInfo> iterator = repaymentPlanInfoList.iterator(); iterator.hasNext(); ) {
                RepaymentPlanInfo repaymentPlanInfo = iterator.next();
                Map<String, Object> request = Maps.newHashMap();
                request.put("syncStatus", "INIT");
                this.repaymentPlanInfoMongoDao.updateById(RepaymentPlanInfo.class, repaymentPlanInfo.get_id().toString(), request);
            }
        }


    }




}
