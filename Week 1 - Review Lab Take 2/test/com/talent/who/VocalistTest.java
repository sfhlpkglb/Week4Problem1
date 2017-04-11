package com.talent.who;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class VocalistTest {
	
	Vocalist vocalist;
	
	@Before
	public void setup(){
		vocalist = new Vocalist(123);
	}
	
	

	@Test
	public void testGetUnionId() {
		int expected = 123;
		int actual = vocalist.getUnionId();
		assertEquals(expected, actual);
	}

	@Test
	public void testPerform(){
		vocalist.setSongKey(SongKey.C);
		String expected = "I sing in the key of – C – 123";
		String actual = vocalist.perform();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPerformWithVolume(){
		vocalist.setSongKey(SongKey.D);
		String expected = "I sing in the key of – D – at the volume 5 – 123";
		String actual = vocalist.perform(Volume.FIVE);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSetSongKey(){
		vocalist.setSongKey(SongKey.A);
		String expected = "A";
		String actual = vocalist.getSongKey();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetSongKey(){
		vocalist.setSongKey(SongKey.B);
		String expected = "B";
		String actual = vocalist.getSongKey();
		assertEquals(expected, actual);	
	}
	
	
}
