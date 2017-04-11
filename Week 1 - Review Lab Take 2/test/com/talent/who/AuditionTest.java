package com.talent.who;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AuditionTest {

	Audition audition;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setup(){
		audition = new Audition();
	}
	
	@Test
	public void testAddPerformer() {
		audition.addContestant(EntertainerType.PERFORMER, 123);
		String expected = "123 - performer\n";
		String actual = audition.conductAuditions();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAddDancer(){
		audition.addContestant(EntertainerType.DANCER, 456, "tap");
		String expected = "tap - 456 - dancer\n";
		String actual = audition.conductAuditions();
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testVocalist(){
		audition.addContestant(EntertainerType.VOCALIST, 921, SongKey.E);
		String expected = "I sing in the key of – E – 921\n";
		String actual = audition.conductAuditions();
		assertEquals(expected, actual);				
	}

	@Test
	public void testVocalistWithVolume(){
		audition.addContestant(EntertainerType.VOCALIST, 1020, SongKey.F);
		String expected = "I sing in the key of – F – at the volume 8 – 1020\n";
		String actual = audition.conductAuditions(Volume.EIGHT);
		assertEquals(expected, actual);				
	}
	
	@Test
	public void testDuplicateUnionIdError(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Union Id already on file 222");
		audition.addContestant(EntertainerType.PERFORMER, 222);
		audition.addContestant(EntertainerType.PERFORMER, 222);
	}
	
	@Test
	public void testWrongEntertainerTypePerformer(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Wrong Entertainer Type used: DANCER");
		audition.addContestant(EntertainerType.DANCER, 444);
	}
	
	@Test
	public void testWrongEntertainerTypeDancer(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Wrong Entertainer Type used: VOCALIST");
		audition.addContestant(EntertainerType.VOCALIST, 555, "tap");
	}
	
	@Test
	public void testWrongEntertainerTypeVocalist(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Wrong Entertainer Type used: PERFORMER");
		audition.addContestant(EntertainerType.PERFORMER, 777, SongKey.G);
	}

	@Test
	public void testWrongEntertainerTypeNull(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Wrong Entertainer Type used: null");
		audition.addContestant(null, 999);
	}
	
}
