//James Hood
//This is my chests class this consist of all the different chests that I implemented into my project.

public class Party {
	private int partysize;	//fields
	private int partylevel;	//always make fields private	
	public int getPartySize () {
		if (partysize <= 10 && partysize >= 2){
		}
		return partysize;	
		}
	public void setPartySize(int size) {
		this.partysize=size;
	}
	
	public int getPartyLevel() {
		if (partylevel <= 20 && partylevel >= 1); {
		}
		return partylevel;
		
	}
	public void setPartyLevel(int lev) {
		if (lev >= 1 && lev <= 20)
		this.partylevel=lev;
	}
	
	public Party() {
		
	}
	public Party (int size, int lev) {
		
		partysize=size;
		partylevel=lev;
	}
	
	
	
}

