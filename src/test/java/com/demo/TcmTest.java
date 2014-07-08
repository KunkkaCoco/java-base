package com.demo;

import org.junit.BeforeClass;

public class TcmTest {
	// private static Logger logger = LoggerFactory.getLogger(TcmTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before test");
	}

	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass test");
	}

}
