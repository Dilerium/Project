package ie.gmit;

import java.rmi.*;

public interface FibService extends Remote{

	public int add(int max) throws RemoteException ;

	public void addResult(FibRequest fr, String results) throws RemoteException ;

	public String getResult(int JobNum) throws RemoteException ;

	public void genFib() throws RemoteException ;
}