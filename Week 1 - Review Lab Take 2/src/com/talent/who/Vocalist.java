package com.talent.who;

class Vocalist implements Perform, Vocal {
	
	private int unionId;
	private SongKey songkey;

	Vocalist(int unionId) {
		this.unionId = unionId;
	}

	@Override
	public String perform() {
		// TODO Auto-generated method stub
		return "I sing in the key of – " + getSongKey() + " – " + getUnionId();
	}
	
	@Override
	public String perform(Volume volume) {
		return "I sing in the key of – " + getSongKey() + " – at the volume " + volume.getVolumeLevel() + " – " + getUnionId(); 
	}
	
	@Override
	public int getUnionId() {
		return unionId;
	}

	@Override
	public void setSongKey(SongKey songkey) {
		this.songkey = songkey;
	}

	@Override
	public String getSongKey() {
		return songkey.toString();
	}


}
