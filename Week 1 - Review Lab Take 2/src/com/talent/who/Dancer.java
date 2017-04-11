package com.talent.who;

public class Dancer implements Perform, Dance {

	private int unionId;
	private String danceStyle;
	
	//		Constructor - Union Id is required
	public Dancer(int unionId){
		this.unionId = unionId;
	}
	
	@Override
	public String perform() {
		return getDanceStyle() + " - " + getUnionId() + " - dancer";
	}

	@Override
	public int getUnionId() {
		return unionId;
	}


	@Override
	public String getDanceStyle() {
		return danceStyle;
	}

	@Override
	public void setDanceStyle(String danceStyle) {
		this.danceStyle = danceStyle;
	}

}
  