package com.abin.lee.mongo.dao.test;

import com.abin.lee.mongo.dao.base.MongoDao;
import com.abin.lee.mongo.dao.test.base.AbstractJunitTemplate;
import com.abin.lee.mongo.model.*;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
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
public class SetTest extends AbstractJunitTemplate {
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
    @Autowired
    MongoDao<ThirdPartyBasicInfo> thirdPartyBasicInfoMongoDao;

    @Test
    public void testRepayPlan() {
        this.updateLoanQuery();
    }

    @Test
    public void testupdateContractPENDING() {
        this.updateContractPENDING();
    }



    public void updateLoanQuery(){
        BasicQuery query = new BasicQuery("{ realTimeSyncStatus : 'SUCCESS',loanAgreementSyncStatus : 'SUCCESS',loanOfferSyncStatus : 'SUCCESS',repaymentPlanSyncStatus : 'SUCCESS',loanRecoverySyncStatus : 'SUCCESS' }");
        List<LoanAgreementInfo> loanAgreementInfoList = this.loanAgreementInfoMongoDao.findList(query, LoanAgreementInfo.class);
        if(CollectionUtils.isNotEmpty(loanAgreementInfoList)){
            System.out.println("loanAgreementInfoList : " + loanAgreementInfoList);
            System.out.println("loanAgreementInfoList_id : " + loanAgreementInfoList.get(0).get_id().toString());
            for(Iterator<LoanAgreementInfo> iterator=loanAgreementInfoList.iterator();iterator.hasNext();){
                LoanAgreementInfo loanAgreementInfo = iterator.next();

                BasicQuery querys = new BasicQuery("{ reportedId : '+"+loanAgreementInfo.getReportedId()+"+'}");

                ThirdPartyBasicInfo thirdPartyBasicInfo = this.thirdPartyBasicInfoMongoDao.findOne(querys, ThirdPartyBasicInfo.class);
                if(ObjectUtils.notEqual(null, thirdPartyBasicInfo)){
                    Map<String, Object> request = Maps.newHashMap();
                    request.put("syncStatus", "SUCCESS");
                    this.thirdPartyBasicInfoMongoDao.updateById(ThirdPartyBasicInfo.class, thirdPartyBasicInfo.get_id().toString(), request);
                }
            }
        }
    }


    public void updateContractPENDING(){
        BasicQuery query = new BasicQuery("{loanAgreementSyncStatus : 'PENDING'}");
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





}
