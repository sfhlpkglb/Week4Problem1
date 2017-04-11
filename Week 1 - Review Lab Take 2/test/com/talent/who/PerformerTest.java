package com.talent.who;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PerformerTest {
	
	Performer performer;
	
	@Before
	public void setup(){
		performer = new Performer(222);
	}
	
	@Test
	public void testGetUnionId() {
		int expected = 222;
		int actual = performer.getUnionId();
		assertEquals(expected,actual);
	}

	@Test
	public void testPerform(){
		String expected = "222 - performer";
		String actual = performer.perform();
		assertEquals(expected, actual);
	}
	
}
