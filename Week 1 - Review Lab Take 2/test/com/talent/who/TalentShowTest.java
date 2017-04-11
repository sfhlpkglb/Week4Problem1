package com.talent.who;

import static org.junit.Assert.*;

import org.junit.Test;

public class TalentShowTest {

	@Test
	public void testSevenContestants() {
		Audition auditition = new Audition();
		
		auditition.addContestant(EntertainerType.PERFORMER, 1111);
		auditition.addContestant(EntertainerType.DANCER, 222, "ballet");
		auditition.addContestant(EntertainerType.PERFORMER, 567);
		auditition.addContestant(EntertainerType.PERFORMER, 123);
		auditition.addContestant(EntertainerType.DANCER, 5000, "jazz");
		auditition.addContestant(EntertainerType.VOCALIST, 1340, SongKey.G);
		auditition.addContestant(EntertainerType.PERFORMER, 16);
		
		String results = auditition.conductAuditions();
		System.out.println(results);
		
		String resultsWithVolume = auditition.conductAuditions(Volume.SEVEN);
		System.out.println(resultsWithVolume);
	}

}
