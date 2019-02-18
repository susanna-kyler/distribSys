package cs455.overlay.transport;
import java.io.*;
import java.net.*;

import cs455.overlay.node.Node;
import cs455.overlay.wireformats.*;

public class TCPRecieverThread  implements Runnable {
	private Socket socket;
	private DataInputStream din;
	private byte[] data;
	private final EventFactory eventFactory = EventFactory.getInstance();
	private Node node;

	/* Constructor */
	public TCPRecieverThread(Socket receiverSocket, Node n ) throws IOException {
		this.socket = receiverSocket;
		din = new DataInputStream(socket.getInputStream());
		this.node = n;
	}
	
	public void run() {
		int dataLength;
		int messageType = 0;
		while (socket != null) {
			try {
				dataLength = din.readInt();
				messageType = din.readInt();
				data = new byte[dataLength];
				din.readFully(data, 0, dataLength);
				din.close();
			} catch (SocketException se) {
				System.out.println(se.getMessage());
				break;
			} catch (IOException ioe) {
				System.out.println(ioe.getMessage()) ;
				break;
			}	
		}
		eventFactory.createEvent(messageType, data, node);
//		System.out.println("TCPRecieverThread.java:  Made it out of eventFactory");
	}



}