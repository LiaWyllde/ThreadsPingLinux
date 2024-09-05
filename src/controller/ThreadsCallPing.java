package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ThreadsCallPing extends Thread {
	
	String[] arrayCall;
	
	public ThreadsCallPing(String[] arrayCall) {
		this.arrayCall = arrayCall;
	}
	
	
	private void callPing(String[] arrayCall) {
		
		try {
            Process process = Runtime.getRuntime().exec(arrayCall);
            InputStream returnn = process.getInputStream();
            InputStreamReader reader = new InputStreamReader(returnn);
            BufferedReader buffer = new BufferedReader(reader);
            String line = buffer.readLine();
            int siz = arrayCall.length;
            String type = "";
            
            while(line != null) {
            	
            	//help
            	
            	if (line.contains("time=")) {
            		String[] filter = line.split("e="); 
            		
            		if (arrayCall[siz-1].contains("uol")) {
            			System.out.println("Ping UOL - " + filter[1]);
            			type = "UOL ";
            		} else if (arrayCall[siz-1].contains("google")) {
            			System.out.println("Ping Google - " + filter[1]);
            			type = "GOOGLE ";
            		} else if (arrayCall[siz-1].contains("terra")) {
            			System.out.println("Ping Terra - " + filter[1]); 
            			type = "TERRA ";
            			}
            	} 
            	
            	if (line.contains("rtt")) {
            		
            		String[] finalLine = line.split("=");
            		String average = finalLine[1];	
            		String[] showAverage = average.split("/"); 
            	
                	Thread.sleep(1500);
                	
                	System.out.println(type + "Average time: " + showAverage[1] + "ms.");
            	}
            	
                line = buffer.readLine();
            }
            returnn.close();
            reader.close();
            buffer.close();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
	}
	
	@Override
	public void run() {
		callPing(arrayCall);
	}
}
