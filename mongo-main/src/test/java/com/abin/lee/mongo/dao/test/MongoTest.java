package com.abin.lee.mongo.dao.test;

import com.abin.lee.mongo.dao.base.MongoDao;
import com.abin.lee.mongo.dao.test.base.AbstractJunitTemplate;
import com.abin.lee.mongo.model.PushMessage;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 16-4-13
 * Time: 下午3:28
 * To change this template use File | Settings | File Templates.
 */
public class MongoTest extends AbstractJunitTemplate {
    @Autowired
    MongoDao<PushMessage> mongoDao;

    @Test
    public void testUpdateByIds() {
        PushMessage crmMessage = new PushMessage();
        crmMessage.setUpdateTime(new Date());
        Map<String, Object> request = new HashMap<>();
        request.put("from", "3333333333333333331");
        request.put("updateTime", new Date());
        this.mongoDao.updateById(PushMessage.class, "570f261a96e63fb34b4d480b", request);
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



}
