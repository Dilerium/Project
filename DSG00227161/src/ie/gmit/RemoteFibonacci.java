package ie.gmit;

import java.rmi.*;
import java.util.*;

public interface RemoteFibonacci extends Remote{
	
	public String genFib(int number) throws RemoteException ;
}