package com.abin.lee.mongo.client.base;

import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import org.bson.Document;

/**
 * Created by abin on 2018/1/3 10:57.
 * mongo-svr
 * com.abin.lee.mongo.client.base
 * http://blog.csdn.net/github_36869152/article/details/68946919
 *
 *  MongoDB中是以Bson数据格式进行存储的，Json字符串没有办法直接写入MongoDB 可以将Json字符串转换成DBObject或者Document，然后写入MongoDB
 */
public class JsonInsert {

    public static void main(String[] args) {
//        insertJson();
        insertBson();
    }

    /**
     *

     1、将Json字符转换成com.mongodb.DBObject（准确的说是BasicDBObject）
     */
    public static void insertJson() {
        // 构造一个Json字符串
        String json = " {" +
                " 'school_code' : '111111', " +
                " 'school_name' : '汉东政法大学', " +
                " 'teacher_idcard' : '0000001', " +
                " 'teacher_name' : '高育良' " +
                " } ";
        MongoClient mongoClient = new MongoClient("172.16.2.133", 27017);
        MongoDatabase database = mongoClient.getDatabase("trade");
        MongoCollection<DBObject> collection = database.getCollection("school", DBObject.class);
        DBObject bson = (DBObject) JSON.parse(json);
        collection.insertOne(bson);
    }

    /**
     * 将字符串转换成org.bson.Document
     */
    public static void insertBson() {
        // 构造一个Json字符串
        String json = " {" +
                " 'school_code' : '2222222', " +
                " 'school_name' : '汉东政法大学', " +
                " 'teacher_idcard' : '0000001', " +
                " 'teacher_name' : '高育良' " +
                " } ";

        MongoClient mongoClient = new MongoClient("172.16.2.133", 27017);

        MongoDatabase database = mongoClient.getDatabase("trade");

        MongoCollection<Document> collection = database.getCollection("school");

        Document document = Document.parse(json);

        collection.insertOne(document );
    }



}
