package cs455.overlay.wireformats;

public class Register extends Message {
	// When a messaging node is declared it should first register its IP address + port # with the registry.
	// Be sure that your network is able to register multiple messaging nodes that are running on the same host but have different ports 
	/* When a registry receives this request, it checks to see if the node had previously registered and ensures
	 * the IP address in the message matches the address where the request originated. The registry issues
	 * an error message under two circumstances:
	 * 		• If the node had previously registered and has a valid entry in its registry.
	 * 		• If there is a mismatch in the address that is specified in the registration request and the IP address of the request (the socket’s input stream).
	 * 
	 * In the case of successful registration, the registry should include a message that indicates the number 
	 * of entries currently present in its registry. A sample information string is “Registration request 
	 * successful. The number of messaging nodes currently constituting the overlay is (5)”. If the 
	 * registration was unsuccessful, the message from the registry should indicate why the request was unsuccessful.
	 * 
	 */
	private int messageType;
	private String ipAddress;
	private int portNumber;
	private String registryHost;
	private int registryPort;
	
	
	/* Constructor */
	public Register(String IP, int PN, String regHost, int regPort){
		this.ipAddress = IP;
		this.portNumber = PN;
		this.registryHost = regHost;
		this.registryPort = regPort;
		
		messageType = getMessageNumber("REGISTER_REQUEST");
		
		
	}
	
	public void requestToJoin() {
		System.out.println("requesting to enlist");
	};
	
	
}
