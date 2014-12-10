package ie.gmit.server;

import java.util.*;
import java.util.*;

public class FibService {
	
	private LinkedList<FibRequest> inQ = new LinkedList<FibRequest>();
	private Map<Integer, String> outQ = new HashMap<Integer, String>();
	
	public int add(int max){
		int random = (int) Math.round(Math.random());
		inQ.add(new FibRequest(random, max));
		return random;
	}
	
	public void addResult(FibRequest fr, String results){
		this.outQ.put(fr.getJobNum(), results);
	}
	
	public String getResult(int JobNum){
		if(outQ.containsKey(JobNum));
		String result = outQ.get(JobNum);
		outQ.remove(JobNum);
		return result;
	}
}