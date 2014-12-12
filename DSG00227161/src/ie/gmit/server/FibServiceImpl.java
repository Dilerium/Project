package ie.gmit.server;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class FibServiceImpl extends UnicastRemoteObject implements FibService {
	
	/**
	 * 
	 */
	private static LinkedList<FibRequest> inQ = new LinkedList<FibRequest>();
	private static Map<Integer, String> outQ = new HashMap<Integer, String>();
	private static RemoteFibonacci fib;
	
	public FibServiceImpl() throws RemoteException{
		try {
			fib = (RemoteFibonacci) Naming.lookup("rmi://127.0.0.1:1099/FibberMcGees");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see ie.gmit.server.FibService#add(int)
	 */
	public int add(int max){
		Random rand = new Random(System.currentTimeMillis());
		int jNum = ((rand.nextInt(199) + 1));
		inQ.add(new FibRequest(jNum, max));
		System.out.println(inQ.toString() + " " + jNum + " " + max);
		return jNum;
	}
	
	/* (non-Javadoc)
	 * @see ie.gmit.server.FibService#addResult(ie.gmit.server.FibRequest, java.lang.String)
	 */
	public void addResult(FibRequest fr, String results){
		this.outQ.put(fr.getJobNum(), results);
	}
	
	/* (non-Javadoc)
	 * @see ie.gmit.server.FibService#getResult(int)
	 */
	public String getResult(int JobNum){
		if(outQ.containsKey(JobNum)){
			String result = outQ.get(JobNum);
			outQ.remove(JobNum);
			System.out.println(inQ.toString());
			return result;
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see ie.gmit.server.FibService#genFib()
	 */
	public void genFib(){
		System.out.println(inQ.toString());
		try{
			FibRequest value = inQ.poll();
			String results = fib.genFib(value.getMax());
			addResult(value, results);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}