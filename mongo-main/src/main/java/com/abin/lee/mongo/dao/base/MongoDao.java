package com.abin.lee.mongo.dao.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @param <T>
 */

public class MongoDao<T> {
    @Autowired
    public MongoTemplate mongoTemplate;

    public void insert(T clazz) {
        mongoTemplate.save(clazz);
    }

    public void insertAll(List<T> params) {
        mongoTemplate.insertAll(params);
    }

    public List<T> findList(Query query, Class<T> clazz) {
        return (List<T>)mongoTemplate.find(query, clazz);
    }

    public List<T> findList(Query query, Class<T> clazz, String collectionName) {
        return (List<T>)mongoTemplate.find(query, clazz, collectionName);
    }

    public T findOne(Query query, Class<T> clazz) {
        return (T)mongoTemplate.findOne(query, clazz);
    }

    public T findOne(Query query, Class<T> clazz,String collectionName) {
        return (T)mongoTemplate.findOne(query, clazz, collectionName);
    }

    public void updateById(Class<T> clazz, String id, String key, Object value) {
        Criteria criteria = Criteria.where("_id").is(id);
        Query query = new Query(criteria);
        Update update = Update.update(key, value);
        mongoTemplate.updateFirst(query, update, clazz);
    }

    public void updateById(Class<T> clazz,String id, Map<String ,Object> request) {
        Criteria criteria = Criteria.where("_id").is(id);
        Query query = new Query(criteria);
        Update update = Update.update("_id", id);
        for(Iterator<Map.Entry<String,Object>> iterator=request.entrySet().iterator();iterator.hasNext();){
            Map.Entry<String,Object> entry = iterator.next();
            update.set(entry.getKey(), entry.getValue());
            mongoTemplate.updateFirst(query, update, clazz);
        }

    }

    public T queryById(String id, Class<T> clazz) {
        Query query = new Query();
        Criteria criteria = Criteria.where("_id").is(id);
        query.addCriteria(criteria);
        return this.mongoTemplate.findOne(query, clazz);
    }

    public void delete(T t){
        this.mongoTemplate.remove(t);
    }



//    public long count(Class<T> clazz) {
//        Query query = getQuery(criteriaUser);
//        return mongoTemplate.count(query, User.class);
//    }

}
