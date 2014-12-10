package ie.gmit;

import java.rmi.RemoteException;

public class fibTester {
	
	public static void main(String[] args) throws RemoteException {
	
		RemoteFibonacci fib = new Fibonacci();
		
		System.out.println(fib.genFib(30));		
	}
}