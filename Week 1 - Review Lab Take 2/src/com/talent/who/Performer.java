package com.talent.who;

class Performer implements Perform {

	private int unionId;
	
	//		Constructor - Union Id is required
	public Performer(int unionId){
		this.unionId = unionId;
	}
	
	@Override
	public int getUnionId() {
		return unionId;
	}

	@Override
	public String perform() {
		return getUnionId() + " - performer";
	}

}
