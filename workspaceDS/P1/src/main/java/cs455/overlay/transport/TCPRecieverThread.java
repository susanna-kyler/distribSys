package cs455.overlay.transport;
import java.io.DataInputStream;
import java.io.IOException;
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
		while (socket != null && !socket.isClosed()) {
			try {
				dataLength = din.readInt();
				messageType = din.readInt();
				data = new byte[dataLength];
				din.readFully(data, 0, dataLength);
			} catch (SocketException se) {
				System.out.println(se.getMessage());
			} catch (IOException ioe) {
				System.out.println(ioe.getMessage()) ;
			}
			if(!socket.isClosed()) 
				eventFactory.insert(messageType, data, node, socket);
		}
		try {
			din.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}



