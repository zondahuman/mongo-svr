package com.abin.lee.mongo.dao.test;

import com.abin.lee.mongo.dao.base.MongoDao;
import com.abin.lee.mongo.dao.test.base.AbstractJunitTemplate;
import com.abin.lee.mongo.model.*;
import com.google.common.collect.Maps;
import com.mongodb.BasicDBObject;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 16-4-13
 * Time: 下午3:28
 * To change this template use File | Settings | File Templates.
 */
public class ContractTest extends AbstractJunitTemplate {
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
    public void testContract() {
//        Query query = new Query(Criteria.where("syncStatus").is("QUERY_FAILED"));
        this.updateContract();
        this.updateContractStatus();
        this.updateLoanGrant();
        this.updateRepaymentPlanInfo();
        this.updateLoanRecoveryInfo();
    }


    @Test
    public void testContractRepeat() {
//        Query query = new Query(Criteria.where("syncStatus").is("QUERY_FAILED"));
        this.updateContractRepeat();
        this.updateLoanGrantRepeat();
    }


    @Test
    public void testUpdateContractStatusFail() {
//        Query query = new Query(Criteria.where("syncStatus").is("QUERY_FAILED"));
        this.updateContractStatusFail();
    }


    @Test
    public void testRealTimeSyncStatus() {
//        Query query = new Query(Criteria.where("syncStatus").is("QUERY_FAILED"));
        this.realTimeSyncStatus();
    }


    @Test
    public void testUpdateContractStatus() {
//        Query query = new Query(Criteria.where("syncStatus").is("QUERY_FAILED"));
        this.updateContractStatus();
    }

    @Test
    public void testLoan() {
//        Query query = new Query(Criteria.where("syncStatus").is("QUERY_FAILED"));
        this.updateLoanGrant();
    }

    @Test
    public void testRepayPlan() {
//        Query query = new Query(Criteria.where("syncStatus").is("QUERY_FAILED"));
        this.updateLoanGrant();
    }



    @Test
    public void testQueryById() {
        PushMessage crmMessage = this.mongoDao.queryById("570e1d522c044b3db31153c1", PushMessage.class);
        System.out.println("crmMessage="+crmMessage);
    }

    @Test
    public void testUpdateById() {
        Map<String, Object> request = new HashMap<>();
        request.put("from", "3333333333333333332");
        this.mongoDao.updateById(PushMessage.class, "570f261a96e63fb34b4d480b", request);
    }

    public void updateContract(){
        BasicQuery query = new BasicQuery("{ syncStatus : 'QUERY_FAILED' }");
        List<LoanAgreementInfo> loanAgreementInfoList = this.loanAgreementInfoMongoDao.findList(query, LoanAgreementInfo.class);
        if(CollectionUtils.isNotEmpty(loanAgreementInfoList)){
            System.out.println("loanAgreementInfoList : " + loanAgreementInfoList);
            System.out.println("loanAgreementInfoList_id : " + loanAgreementInfoList.get(0).get_id().toString());
            for(Iterator<LoanAgreementInfo> iterator=loanAgreementInfoList.iterator();iterator.hasNext();){
                LoanAgreementInfo loanAgreementInfo = iterator.next();
                this.loanAgreementInfoMongoDao.updateById(LoanAgreementInfo.class, loanAgreementInfo.get_id().toString(), "syncStatus", "INIT");
            }
        }

    }

    public void updateContractStatus(){
        BasicQuery query = new BasicQuery("{ loanAgreementSyncStatus : 'QUERY_FAILED' }");
        List<LoanAgreementInfo> loanAgreementInfoList = this.loanAgreementInfoMongoDao.findList(query, LoanAgreementInfo.class);
        if(CollectionUtils.isNotEmpty(loanAgreementInfoList)){
            System.out.println("loanAgreementInfoList : " + loanAgreementInfoList);
            System.out.println("loanAgreementInfoList_id : " + loanAgreementInfoList.get(0).get_id().toString());
            for(Iterator<LoanAgreementInfo> iterator=loanAgreementInfoList.iterator();iterator.hasNext();){
                LoanAgreementInfo loanAgreementInfo = iterator.next();
                this.loanAgreementInfoMongoDao.updateById(LoanAgreementInfo.class, loanAgreementInfo.get_id().toString(), "loanAgreementSyncStatus", "INIT");
            }
        }
        BasicQuery query1= new BasicQuery("{ loanOfferSyncStatus : 'QUERY_FAILED' }");
        List<LoanAgreementInfo> loanAgreementInfoList1 = this.loanAgreementInfoMongoDao.findList(query1, LoanAgreementInfo.class);
        if(CollectionUtils.isNotEmpty(loanAgreementInfoList1)){
            System.out.println("loanAgreementInfoList1 : " + loanAgreementInfoList1);
            System.out.println("loanAgreementInfoList1-id : " + loanAgreementInfoList1.get(0).get_id().toString());
            for(Iterator<LoanAgreementInfo> iterator=loanAgreementInfoList1.iterator();iterator.hasNext();){
                LoanAgreementInfo loanAgreementInfo = iterator.next();
                this.loanAgreementInfoMongoDao.updateById(LoanAgreementInfo.class, loanAgreementInfo.get_id().toString(), "loanOfferSyncStatus", "INIT");
            }
        }
        BasicQuery query2= new BasicQuery("{ repaymentPlanSyncStatus : 'QUERY_FAILED' }");
        List<LoanAgreementInfo> loanAgreementInfoList2 = this.loanAgreementInfoMongoDao.findList(query2, LoanAgreementInfo.class);
        if(CollectionUtils.isNotEmpty(loanAgreementInfoList2)){
            System.out.println("loanAgreementInfoList2 : " + loanAgreementInfoList2);
            System.out.println("loanAgreementInfoList2-id : " + loanAgreementInfoList2.get(0).get_id().toString());
            for(Iterator<LoanAgreementInfo> iterator=loanAgreementInfoList2.iterator();iterator.hasNext();){
                LoanAgreementInfo loanAgreementInfo = iterator.next();
                this.loanAgreementInfoMongoDao.updateById(LoanAgreementInfo.class, loanAgreementInfo.get_id().toString(), "repaymentPlanSyncStatus", "INIT");
            }
        }
        BasicQuery query3= new BasicQuery("{ loanRecoverySyncStatus : 'QUERY_FAILED' }");
        List<LoanAgreementInfo> loanAgreementInfoList3 = this.loanAgreementInfoMongoDao.findList(query3, LoanAgreementInfo.class);
        if(CollectionUtils.isNotEmpty(loanAgreementInfoList3)){
            System.out.println("loanAgreementInfoList3 : " + loanAgreementInfoList3);
            System.out.println("loanAgreementInfoList3-id : " + loanAgreementInfoList3.get(0).get_id().toString());
            for(Iterator<LoanAgreementInfo> iterator=loanAgreementInfoList3.iterator();iterator.hasNext();){
                LoanAgreementInfo loanAgreementInfo = iterator.next();
                this.loanAgreementInfoMongoDao.updateById(LoanAgreementInfo.class, loanAgreementInfo.get_id().toString(), "loanRecoverySyncStatus", "INIT");
            }
        }

    }

    public void updateContractStatusFail(){
        BasicQuery query = new BasicQuery("{ loanAgreementSyncStatus : 'FAILED' }");
        List<LoanAgreementInfo> loanAgreementInfoList = this.loanAgreementInfoMongoDao.findList(query, LoanAgreementInfo.class);
        if(CollectionUtils.isNotEmpty(loanAgreementInfoList)){
            System.out.println("loanAgreementInfoList : " + loanAgreementInfoList);
            System.out.println("loanAgreementInfoList_id : " + loanAgreementInfoList.get(0).get_id().toString());
            for(Iterator<LoanAgreementInfo> iterator=loanAgreementInfoList.iterator();iterator.hasNext();){
                LoanAgreementInfo loanAgreementInfo = iterator.next();
                Map<String, Object> request = Maps.newHashMap();
                request.put("loanAgreementSyncStatus", "INIT");
                request.put("syncStatus", "INIT");
                this.loanAgreementInfoMongoDao.updateById(LoanAgreementInfo.class, loanAgreementInfo.get_id().toString(), request);
            }
        }

    }

    public void updateContractRepeat(){
        BasicQuery query = new BasicQuery("{ loanAgreementSyncStatus : 'REPEAT_REPORT_FAILED' }");
        List<LoanAgreementInfo> loanAgreementInfoList = this.loanAgreementInfoMongoDao.findList(query, LoanAgreementInfo.class);
        if(CollectionUtils.isNotEmpty(loanAgreementInfoList)){
            System.out.println("loanAgreementInfoList : " + loanAgreementInfoList);
            System.out.println("loanAgreementInfoList_id : " + loanAgreementInfoList.get(0).get_id().toString());
            for(Iterator<LoanAgreementInfo> iterator=loanAgreementInfoList.iterator();iterator.hasNext();){
                LoanAgreementInfo loanAgreementInfo = iterator.next();
                Map<String, Object> request = Maps.newHashMap();
                request.put("loanAgreementSyncStatus", "SUCCESS");
                request.put("syncStatus", "SUCCESS");
                this.loanAgreementInfoMongoDao.updateById(LoanAgreementInfo.class, loanAgreementInfo.get_id().toString(), request);
            }
        }

    }

    public void updateLoanGrantRepeat(){
        BasicQuery query = new BasicQuery("{ loanOfferSyncStatus : 'REPEAT_REPORT_FAILED' }");
        List<LoanAgreementInfo> loanAgreementInfoList = this.loanAgreementInfoMongoDao.findList(query, LoanAgreementInfo.class);
        if(CollectionUtils.isNotEmpty(loanAgreementInfoList)){
            System.out.println("loanAgreementInfoList : " + loanAgreementInfoList);
            System.out.println("loanAgreementInfoList_id : " + loanAgreementInfoList.get(0).get_id().toString());
            for(Iterator<LoanAgreementInfo> iterator=loanAgreementInfoList.iterator();iterator.hasNext();){
                LoanAgreementInfo loanAgreementInfo = iterator.next();
                Map<String, Object> request = Maps.newHashMap();
                request.put("loanOfferSyncStatus", "SUCCESS");
                request.put("syncStatus", "SUCCESS");
                this.loanAgreementInfoMongoDao.updateById(LoanAgreementInfo.class, loanAgreementInfo.get_id().toString(), request);
            }
        }
    }



    public void updateLoanGrant(){
        BasicQuery query = new BasicQuery("{ syncStatus : 'QUERY_FAILED' }");
        List<LoanInfo> loanInfoList = this.loanInfoMongoDao.findList(query, LoanInfo.class);
        if(CollectionUtils.isNotEmpty(loanInfoList)) {
            System.out.println("loanInfoList : " + loanInfoList);
            System.out.println("loanInfoList-id : " + loanInfoList.get(0).get_id().toString());
            for (Iterator<LoanInfo> iterator = loanInfoList.iterator(); iterator.hasNext(); ) {
                LoanInfo loanInfo = iterator.next();
                this.loanInfoMongoDao.updateById(LoanInfo.class, loanInfo.get_id().toString(), "syncStatus", "INIT");
            }
        }
        BasicQuery query1 = new BasicQuery("{ syncStatus : 'QUERY_FAILED' }");
        List<LoanInfo> loanInfoList1 = this.loanInfoMongoDao.findList(query1, LoanInfo.class);
        if(CollectionUtils.isNotEmpty(loanInfoList1)) {
            System.out.println("loanInfoList1 : " + loanInfoList1);
            System.out.println("loanInfoList1-id : " + loanInfoList1.get(0).get_id().toString());
            for (Iterator<LoanInfo> iterator = loanInfoList1.iterator(); iterator.hasNext(); ) {
                LoanInfo loanInfo = iterator.next();
                this.loanInfoMongoDao.updateById(LoanInfo.class, loanInfo.get_id().toString(), "syncStatus", "INIT");
            }
        }

        BasicQuery query2 = new BasicQuery("{ syncStatus : 'REPEAT_REPORT_FAILED' }");
        List<LoanInfo> loanInfoList2 = this.loanInfoMongoDao.findList(query2, LoanInfo.class);
        if(CollectionUtils.isNotEmpty(loanInfoList2)) {
            System.out.println("loanInfoList2 : " + loanInfoList2);
            System.out.println("loanInfoList2-id : " + loanInfoList2.get(0).get_id().toString());
            for (Iterator<LoanInfo> iterator = loanInfoList2.iterator(); iterator.hasNext(); ) {
                LoanInfo loanInfo = iterator.next();
                this.loanInfoMongoDao.updateById(LoanInfo.class, loanInfo.get_id().toString(), "syncStatus", "SUCCESS");
            }
        }
    }





    public void updateRepaymentPlanInfo(){
        BasicQuery query = new BasicQuery("{ syncStatus : 'QUERY_FAILED' }");
        List<RepaymentPlanInfo> repaymentPlanInfoList = this.repaymentPlanInfoMongoDao.findList(query, RepaymentPlanInfo.class);
        if(CollectionUtils.isNotEmpty(repaymentPlanInfoList)) {
            System.out.println("repaymentPlanInfoList : " + repaymentPlanInfoList);
            System.out.println("repaymentPlanInfoList-id : " + repaymentPlanInfoList.get(0).get_id().toString());
            for (Iterator<RepaymentPlanInfo> iterator = repaymentPlanInfoList.iterator(); iterator.hasNext(); ) {
                RepaymentPlanInfo repaymentPlanInfo = iterator.next();
                this.repaymentPlanInfoMongoDao.updateById(RepaymentPlanInfo.class, repaymentPlanInfo.get_id().toString(), "syncStatus", "INIT");
            }
        }
    }

    public void updateLoanRecoveryInfo(){
        BasicQuery query = new BasicQuery("{ syncStatus : 'QUERY_FAILED' }");
        List<LoanRecoveryInfo> loanRecoveryInfoList = this.loanRecoveryInfoMongoDao.findList(query, LoanRecoveryInfo.class);
        if(CollectionUtils.isNotEmpty(loanRecoveryInfoList)) {
            System.out.println("loanRecoveryInfoList : " + loanRecoveryInfoList);
            System.out.println("loanRecoveryInfoList-id : " + loanRecoveryInfoList.get(0).get_id().toString());
            for (Iterator<LoanRecoveryInfo> iterator = loanRecoveryInfoList.iterator(); iterator.hasNext(); ) {
                LoanRecoveryInfo loanRecoveryInfo = iterator.next();
                this.loanRecoveryInfoMongoDao.updateById(LoanRecoveryInfo.class, loanRecoveryInfo.get_id().toString(), "syncStatus", "INIT");
            }
        }
    }


    public void realTimeSyncStatus(){
        BasicQuery query = new BasicQuery("{ \"realTimeSyncStatus\" : \"FAILED\" }");
        List<LoanAgreementInfo> loanAgreementInfoList = this.loanAgreementInfoMongoDao.findList(query, LoanAgreementInfo.class);
        if(CollectionUtils.isNotEmpty(loanAgreementInfoList)){
            System.out.println("loanAgreementInfoList : " + loanAgreementInfoList);
            System.out.println("loanAgreementInfoList_id : " + loanAgreementInfoList.get(0).get_id().toString());
            for(Iterator<LoanAgreementInfo> iterator=loanAgreementInfoList.iterator();iterator.hasNext();){
                LoanAgreementInfo loanAgreementInfo = iterator.next();
                Map<String, Object> request = Maps.newHashMap();
                request.put("realTimeSyncStatus", "INIT");
                this.loanAgreementInfoMongoDao.updateById(LoanAgreementInfo.class, loanAgreementInfo.get_id().toString(), request);
            }
        }
    }



}
