package com.talent.who;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DancerTest {
	
	Dancer dancer;
	
	@Before
	public void setup(){
		dancer = new Dancer(200);
	}
	
	@Test
	public void testGetUnionId() {
		int expected = 200;
		int actual = dancer.getUnionId();
		assertEquals(expected, actual);
	}

	@Test
	public void testPerform(){
		dancer.setDanceStyle("ballet");
		String expected = "ballet - 200 - dancer";
		String actual = dancer.perform();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDanceStyle(){
		dancer.setDanceStyle("tap");
		String expected = "tap";
		String actual = dancer.getDanceStyle();
		assertEquals(expected, actual);
	}
}
