package view;
import controller.*;

public class Main {

	public static void main(String[] args) {

		String[] arraySites = {"www.uol.com.br", "www.terra.com.br", "www.google.com.br"};
		String callPing = "ping -4 -c 10 ";

		IdentifyOS os = new IdentifyOS();

		boolean osAvalaible = false;
		osAvalaible = os.getIdentifyOS(osAvalaible);

		if (osAvalaible == true) {

			String[] callPingArray = callPing.split(" ");
			int size = callPingArray.length;

			for (String word : arraySites) {

				String[] pingUltimateFinalReleasePlus = new String[size + 1];
				pingUltimateFinalReleasePlus = os.getArrayUltimate(callPingArray);
				pingUltimateFinalReleasePlus[size] = word;
				Thread tr = new ThreadsCallPing(pingUltimateFinalReleasePlus);
				tr.start();
				
				//Teacher, I'm sorry for the "pingUltimateFinalReleasePlus" and for the trauma 
			}
		}
		else {
			System.out.println("Unavailable system.");
			System.out.println("Exiting...");
			System.exit(0);
		}	
	}
}