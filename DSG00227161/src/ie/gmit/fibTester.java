package ie.gmit;

import ie.gmit.server.Fibonacci;

import java.rmi.RemoteException;

public class fibTester {
	
	public static void main(String[] args) throws RemoteException {
	
		RemoteFibonacci fib = new Fibonacci();
		
		System.out.println(fib.genFib(30));		
	}
}