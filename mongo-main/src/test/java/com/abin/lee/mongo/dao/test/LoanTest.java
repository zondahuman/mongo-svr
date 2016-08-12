package com.abin.lee.mongo.dao.test;

import com.abin.lee.mongo.dao.base.MongoDao;
import com.abin.lee.mongo.dao.test.base.AbstractJunitTemplate;
import com.abin.lee.mongo.model.*;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.BasicQuery;

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
public class LoanTest extends AbstractJunitTemplate {
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
        this.updateLoanQuery();
        this.updateLoanFailed();
        this.updateLoanRepeat();
//        this.updateLoanRecoveryInfo();
    }





    public void updateLoanQuery(){
        BasicQuery query = new BasicQuery("{ loanOfferSyncStatus : 'QUERY_FAILED' }");
        List<LoanAgreementInfo> loanAgreementInfoList = this.loanAgreementInfoMongoDao.findList(query, LoanAgreementInfo.class);
        if(CollectionUtils.isNotEmpty(loanAgreementInfoList)){
            System.out.println("loanAgreementInfoList : " + loanAgreementInfoList);
            System.out.println("loanAgreementInfoList_id : " + loanAgreementInfoList.get(0).get_id().toString());
            for(Iterator<LoanAgreementInfo> iterator=loanAgreementInfoList.iterator();iterator.hasNext();){
                LoanAgreementInfo loanAgreementInfo = iterator.next();
                Map<String, Object> request = Maps.newHashMap();
                request.put("loanOfferSyncStatus", "INIT");
                request.put("syncStatus", "INIT");
                this.loanAgreementInfoMongoDao.updateById(LoanAgreementInfo.class, loanAgreementInfo.get_id().toString(), request);
            }
        }

        BasicQuery query2 = new BasicQuery("{ syncStatus : 'QUERY_FAILED' }");
        List<LoanInfo> loanInfoList2 = this.loanInfoMongoDao.findList(query2, LoanInfo.class);
        if(CollectionUtils.isNotEmpty(loanInfoList2)) {
            System.out.println("loanInfoList2 : " + loanInfoList2);
            System.out.println("loanInfoList2-id : " + loanInfoList2.get(0).get_id().toString());
            for (Iterator<LoanInfo> iterator = loanInfoList2.iterator(); iterator.hasNext(); ) {
                LoanInfo loanInfo = iterator.next();
                this.loanInfoMongoDao.updateById(LoanInfo.class, loanInfo.get_id().toString(), "syncStatus", "INIT");
            }
        }
    }


    public void updateLoanFailed(){
        BasicQuery query = new BasicQuery("{ loanOfferSyncStatus : 'FAILED' }");
        List<LoanAgreementInfo> loanAgreementInfoList = this.loanAgreementInfoMongoDao.findList(query, LoanAgreementInfo.class);
        if(CollectionUtils.isNotEmpty(loanAgreementInfoList)){
            System.out.println("loanAgreementInfoList : " + loanAgreementInfoList);
            System.out.println("loanAgreementInfoList_id : " + loanAgreementInfoList.get(0).get_id().toString());
            for(Iterator<LoanAgreementInfo> iterator=loanAgreementInfoList.iterator();iterator.hasNext();){
                LoanAgreementInfo loanAgreementInfo = iterator.next();
                Map<String, Object> request = Maps.newHashMap();
                request.put("loanOfferSyncStatus", "INIT");
                request.put("syncStatus", "INIT");
                this.loanAgreementInfoMongoDao.updateById(LoanAgreementInfo.class, loanAgreementInfo.get_id().toString(), request);
            }
        }

        BasicQuery query2 = new BasicQuery("{ syncStatus : 'FAILED' }");
        List<LoanInfo> loanInfoList2 = this.loanInfoMongoDao.findList(query2, LoanInfo.class);
        if(CollectionUtils.isNotEmpty(loanInfoList2)) {
            System.out.println("loanInfoList2 : " + loanInfoList2);
            System.out.println("loanInfoList2-id : " + loanInfoList2.get(0).get_id().toString());
            for (Iterator<LoanInfo> iterator = loanInfoList2.iterator(); iterator.hasNext(); ) {
                LoanInfo loanInfo = iterator.next();
                this.loanInfoMongoDao.updateById(LoanInfo.class, loanInfo.get_id().toString(), "syncStatus", "INIT");
            }
        }
    }

    public void updateLoanRepeat(){
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



}
