package ie.gmit;

import java.rmi.Naming;
import java.rmi.registry.*;

public class FibonacciService {
	
	public static void main(String[] args) throws Exception{
		LocateRegistry.createRegistry(1099);
		Naming.rebind("FibberMcGees", new Fibonacci());
		Naming.rebind("FibService", new FibServiceImpl());
		System.out.println("Server running!");
		Worker worker = new Worker();
		worker.run();
	}
}