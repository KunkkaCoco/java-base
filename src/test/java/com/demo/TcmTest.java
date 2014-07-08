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

import headfirst.adapter.ducks.*;
public class TcmTest {
	// private static Logger logger = LoggerFactory.getLogger(TcmTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before test");
	}

	
	public static void tearDownAfterClass() throws Exception {
			System.out.println("AfterClass test");
	}

	@Test
	public void testFetch() throws Exception {
		MallardDuck duck = new MallardDuck();
 duck.
		WildTurkey turkey = new WildTurkey();
		Duck turkeyAdapter = new TurkeyAdapter(turkey);
   
		System.out.println("The Turkey says...");
		turkey.gobble();
		turkey.fly();
 
		System.out.println("\nThe Duck says...");
		testDuck(duck);
  
		System.out.println("\nThe TurkeyAdapter says...");
		testDuck(turkeyAdapter);
	}
 
	public	static void testDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}
}
