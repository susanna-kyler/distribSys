package cs455.overlay.wireformats;

import java.io.*;

public class Marshalling {
	// Translation from in-memory to network-bound byte sequence
	// Basically packing  fields into a byte array
	private int messageType;
	private long timestamp;
	private String identifier;
	private int tracker;
	
	public Marshalling(int mT, String identifier ) throws IOException {
		getBytes();
	}
	
	
	private byte[] getBytes() throws IOException {
		byte[] marshalledBytes ;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		DataOutputStream dout = new DataOutputStream(new BufferedOutputStream(outputStream));
		dout.writeInt(messageType);
		dout.writeLong(timestamp);
		byte[] identifierBytes = identifier.getBytes();
		int elementLength = identifierBytes.length;
		dout.writeInt(elementLength);
		dout.write(identifierBytes);
		dout.writeInt(tracker);
		dout.flush();
		marshalledBytes = outputStream.toByteArray();
		outputStream.close();
		dout.close();
		return marshalledBytes;
	}

	public static void main(String[] args) {
		Marshalling messageM = new Marshalling(messageType, identifier);
	}
}