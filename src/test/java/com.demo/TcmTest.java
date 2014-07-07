package com.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TcmTest {
	private static Logger logger = LoggerFactory.getLogger(TcmTest.class);
	private static ClassPathXmlApplicationContext context;
	private static ShareServiceImpl shareService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.debug("before test");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		logger.debug("after test");
	}

	@Test
	public void testFetch() throws Exception {
		logger.debug(" testing");
		

	}
}
