package com.collect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class TestCollect {

	private static Logger logger = LoggerFactory.getLogger(TestCollect.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before test##########################################");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass test##########################################");
	}

	@Test
	public void testSublist() {

		List<Integer> test = new ArrayList<Integer>();
		// init list
		for (int i = 0; i < 10; i++) {
			Map map = new HashMap();
			map.put("index", "i");
			test.add(i); // auto boxing
		}
		// display the list
		System.out.print("the orginal list: ");
		for (int i = 0; i < test.size(); i++) {
			System.out.print(test.get(i) + " ");
		}
		System.out.println();

		// sub list
		List<Integer> sub = test.subList(1, 3); // sub list contains elements: 1, 2
		sub.remove(1); // remove element “2” from sub list

		// display the list again
		System.out.print("the orginal list after sublist modified: ");
		for (int i = 0; i < test.size(); i++) {
			System.out.print(test.get(i) + " ");
		}
		System.out.println();

		List<Integer> sub2 = test.subList(5, 19); //
		logger.debug("----------" + JSON.toJSONString(sub2));
		logger.debug("----------" + JSON.toJSONString(test));
	}

}
