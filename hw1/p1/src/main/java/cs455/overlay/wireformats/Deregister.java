package cs455.overlay.wireformats;

public class Deregister extends Message {
	// This is sent right before a messaging node leaves the overlay
	int messageType;
	private String ipAddress;
	private int portNumber;
	private String registryHost;
	private int registryPort;
	
	
	public Deregister( String IP, int PN){
		ipAddress = IP;
		portNumber = PN;
		messageType = getMessageNumber("DEREGISTER_REQUEST");

		
	}
	
	
}
	
