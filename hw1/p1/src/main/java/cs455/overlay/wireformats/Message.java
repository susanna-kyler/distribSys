package cs455.overlay.wireformats;

public class Message {
	private int messageNumber;
	
	public int getMessageNumber(String message) {	
		switch( message ) {	
			case "REGISTER_REQUEST":
				messageNumber = 0;
				
			case "REGISTER_RESPONSE":
				messageNumber = 1;

			case "DEREGISTER_REQUEST":
				messageNumber = 2;

			case "DEREGISTER_RESPONSE":
				messageNumber = 3;

			case "MESSAGING_NODES_LIST":
				messageNumber = 4;

			case "Link_Weights":
				messageNumber = 5;

			case "TASK_INITIATE":
				messageNumber = 6;

			case "TASK_COMPLETE":
				messageNumber = 7;
			
			case "PULL_TRAFFIC_SUMMARY":
				messageNumber = 8;
			
			case "TRAFFIC_SUMMARY":
				messageNumber = 9;
		}
		return messageNumber;
		
	}
	
}
