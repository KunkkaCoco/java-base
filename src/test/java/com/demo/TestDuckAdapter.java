package com.demo;

import headfirst.adapter.ducks.Duck;
import headfirst.adapter.ducks.MallardDuck;
import headfirst.adapter.ducks.TurkeyAdapter;
import headfirst.adapter.ducks.WildTurkey;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDuckAdapter {
	private static Logger logger = LoggerFactory.getLogger(TcmTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before test##########################################");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass test##########################################");
	}

@Test
	public void testit1() {
	

		System.out.println("#####################");
		
		System.out.println("\ntestit2");

		System.out.println("\n#################");
	
	}

	@Test
	public void testit2() {
		MallardDuck duck = new MallardDuck();

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

	public void testDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}
}
