package cs455.overlay.node;
import java.io.IOException;

import cs455.overlay.transport.TCPServerThread;
public class Node {
	public String ipAddr;
	public int portNum;
	
	// Node constructor
	public Node(String ipAddress, int portNumber){
		ipAddr = ipAddress;
		portNum = portNumber;
		
		//may have to change later cause of assigned port num
		// so for now i am just directly altering 
		try {
			TCPServerThread gPort = new TCPServerThread();
			portNum = gPort.portFinder;
			System.out.println(portNum);
		} catch (IOException e) {
			e.printStackTrace();	//alter later
		}
		
	}
	
}
