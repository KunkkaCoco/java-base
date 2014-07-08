package com.demo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TcmTest {
	private static Logger logger = LoggerFactory.getLogger(TcmTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before test");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass test");
	}

	@Test
	public void testit() {
		System.out.println("testit");
	}

	@Test
	public void testit2() {
		System.out.println("testit");
	}
}
