package ie.gmit.server;

import java.io.IOException;
import java.rmi.Naming;
import java.util.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FibService {
	
	private LinkedList<FibRequest> inQ = new LinkedList<FibRequest>();
	private Map<Integer, String> outQ = new HashMap<Integer, String>();
	private RemoteFibonacci fs;
	
	public FibService() throws Exception{
		 fs = (Fibonacci) Naming.lookup("rmi://127.0.0.1:1099/Fibber_McGees");
	}
	
	public int add(int max){
		Random rand = new Random(System.currentTimeMillis());
		int jNum = ((rand.nextInt(199) + 1));
		inQ.add(new FibRequest(jNum, max));
		return jNum;
	}
	
	public void addResult(FibRequest fr, String results){
		this.outQ.put(fr.getJobNum(), results);
	}
	
	public String getResult(int JobNum){
		if(outQ.containsKey(JobNum)){
			String result = outQ.get(JobNum);
			outQ.remove(JobNum);
			return result;
		}
		return null;
	}
	
	public void genFib(int number)throws Exception{
		FibRequest value = inQ.get(number);
		String results = fs.genFib(value.getMax());
		addResult(value, results);
	}
}