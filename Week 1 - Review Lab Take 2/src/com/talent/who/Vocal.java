package com.talent.who;

public interface Vocal {
	
	void setSongKey(SongKey songkey);
	
	String getSongKey();
	
	String perform(Volume volume);

}
