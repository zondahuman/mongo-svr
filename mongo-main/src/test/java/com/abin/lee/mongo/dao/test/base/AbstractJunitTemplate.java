package com.abin.lee.mongo.dao.test.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
* Created with IntelliJ IDEA.
* User: abin
* Date: 16-4-13
* Time: 下午3:29
* To change this template use File | Settings | File Templates.
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public abstract class AbstractJunitTemplate extends AbstractJUnit4SpringContextTests {}
