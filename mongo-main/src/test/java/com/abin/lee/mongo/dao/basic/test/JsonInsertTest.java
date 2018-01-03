package com.abin.lee.mongo.dao.basic.test;

import com.abin.lee.mongo.common.util.JsonUtil;
import com.abin.lee.mongo.dao.base.MongoDao;
import com.abin.lee.mongo.dao.test.base.AbstractJunitTemplate;
import com.abin.lee.mongo.model.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.bson.Document;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
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
public class JsonInsertTest extends AbstractJunitTemplate {
    @Autowired
    MongoDao<PushMessage> mongoDao;
    @Autowired
    MongoDao<Map<String, Object>> mapMongoDao;
    @Autowired
    MongoDao<Object> objectMongoDao;
    @Autowired
    MongoTemplate mongoTemplate;


    @Test
    public void testContract() {
//        Query query = new Query(Criteria.where("syncStatus").is("QUERY_FAILED"));

    }


    @Test
    public void testInsertJson() {
        // 构造一个Json字符串
        String json = " {" +
                " 'school_code' : '33333333', " +
                " 'school_name' : '汉东政法大学', " +
                " 'teacher_idcard' : '0000001', " +
                " 'teacher_name' : '高育良' " +
                " } ";

        Map<String, Object> request = JsonUtil.decodeJson(json, new TypeReference<Map<String, Object>>() {
        });
        String school_code = (int)(Math.random()*100000000)+"";
        request.put("orderId", (int)(Math.random()*1000000000));
        request.put("school_code", school_code);
        String toJson = JsonUtil.toJson(request);
        mongoDao.insertJson(toJson, "school");
    }

    @Test
    public void testFind(){
        BasicQuery query = new BasicQuery("{ orderId : '582849429' }");
        Map<String, Object> request = Maps.newHashMap();
        Object response = this.objectMongoDao.findOneByT(query, new Object(), "school");
        System.out.println("request="+request);
        System.out.println("response="+response);
    }

    @Test
    public void testFindMap(){
        BasicQuery query = new BasicQuery("{ 'orderId' : 582849429 }");
        Map response = this.mongoTemplate.findOne(query, Map.class, "school");
        System.out.println("response="+response);
    }

//    Map envinfo= mongoTemplate.findOne(basicQuery, Map.class, "jvmInfo");






}
