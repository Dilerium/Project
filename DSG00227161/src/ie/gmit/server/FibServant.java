package ie.gmit.server;

import java.rmi.Naming;
import java.rmi.server.*;
import java.rmi.registry.*;

public class FibServant {
	
	public static void main(String[] args) throws Exception{
		LocateRegistry.createRegistry(1099);
		Naming.rebind("Fibber_McGees", new Fibonacci());
		System.out.println("Server Ready...");
	}
}