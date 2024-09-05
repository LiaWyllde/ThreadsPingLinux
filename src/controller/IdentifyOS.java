package controller;

public class IdentifyOS {
	
	private String typeOS() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public boolean getIdentifyOS(boolean osAvalaible) {
		if (typeOS().contains("Linux")){
			osAvalaible = true;} 
		else {osAvalaible = false;}
		return osAvalaible;
	}
	
	private String[] arrayUltimate(String[] callPingArray) {
		
		int size = callPingArray.length;
		
		String[] pingUltimateFinalReleasePlus = new String[size + 1];
		
		for(int i = 0; i < size; i++) {
			pingUltimateFinalReleasePlus[i] = callPingArray[i];
		}
		
		return pingUltimateFinalReleasePlus;

	}
	
	public String[] getArrayUltimate(String[] callPingArray) {
		callPingArray = arrayUltimate(callPingArray);
		return callPingArray;
		
	}
	
}
