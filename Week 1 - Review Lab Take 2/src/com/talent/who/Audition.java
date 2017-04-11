package com.talent.who;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Audition {
	
	//	List of contestants
	private List<Perform> contestants;
	
	Audition(){
		contestants = new LinkedList<>();		
	}

	//	add Performer to contestant list
	void addContestant(EntertainerType performer, int unionId) {
		
		if(performer == EntertainerType.PERFORMER){
			Performer newPerformer = new Performer(unionId);			
			duplicateUnionIdCheck(newPerformer);					//	check for duplicates union Id
			contestants.add(newPerformer);							//	Add performer	
		} else {
			throw new IllegalArgumentException("Wrong Entertainer Type used: " + performer);
		}		
	}

	//	add Dancer to contestant list
	public void addContestant(EntertainerType dancer, int unionId, String danceStyle) {
		
		if(dancer == EntertainerType.DANCER){
			Dancer newDancer = new Dancer(unionId);
			duplicateUnionIdCheck(newDancer);
			newDancer.setDanceStyle(danceStyle);			//	update dance style
			contestants.add(newDancer);						//	Add dancer
			
		} else {
			throw new IllegalArgumentException("Wrong Entertainer Type used: " + dancer);
		}		
	}
	
	//	add Vocalist to contestant list
	public void addContestant(EntertainerType vocalist, int unionId, SongKey songKey) {

		if(vocalist == EntertainerType.VOCALIST){
			Vocalist newVocalist = new Vocalist(unionId);	//	create a vocalist
			duplicateUnionIdCheck(newVocalist);				//	check for duplicates union Id
			newVocalist.setSongKey(songKey);				//	update song key		
			contestants.add(newVocalist);					//	Add vocalist			
		} else {
			throw new IllegalArgumentException("Wrong Entertainer Type used: " + vocalist);
		}
		
	}


	//	Contestants perform without vocalist volume
	String conductAuditions() {
		return performanceLoop(null);
	}

	//	Contestants perform with vocalist volume
	String conductAuditions(Volume volume) {
		return performanceLoop(volume);
	}
	
	//	METHOD performanceLoop
	//		INOUT
	//			Volume from Volume enum - null when no volume requested
	//		OUTPUT
	//			String containing each contestants audition
	private String performanceLoop(Volume volume){
		
		Perform perform;							//	define perform variable
		StringBuilder sb = new StringBuilder();	
		
		Iterator<Perform> it = contestants.iterator();	//	iterator to go through the list
		
//		loop through list till every contestant has performed
		while(it.hasNext()){
			perform = (Perform) it.next();				//	point to object to process
			
			//	only vocalists sing at a volume level when it is requested
			if ((volume != null) && (perform instanceof Vocal)){	
				Vocal vocalist = (Vocal) perform;
				sb.append(vocalist.perform(volume));
			} else {
				sb.append(perform.perform());
			}

			sb.append("\n");
		}
		
		return sb.toString();							//	return performance results

	}
	
	//	METHOD duplicateUnionIdCheck - loop through contestants to make sure unid Id is unique
	//		INPUT
	//			Perform object for contestant being added
	//		OUTPUT
	//			void
	//			if duplicate if found throw IllegalArgumentException 
	private void duplicateUnionIdCheck(Perform newPerform) {
		
		Perform perform;
		Iterator<Perform> it = contestants.iterator();
		
		while(it.hasNext()){
			perform = (Perform) it.next();
			if(perform.getUnionId() == newPerform.getUnionId()){
				throw new IllegalArgumentException("Union Id already on file " + newPerform.getUnionId());
			}
		}
		
		return;
		
	}

	
}