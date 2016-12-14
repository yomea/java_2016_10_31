package socket;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPClient {
	
	static DatagramSocket datagramSocket;
	
	static DatagramPacket datagramPacket;
	
	static byte[] buff;
	
	static ByteArrayOutputStream byteArrayOutputStream;
	
	static DataOutputStream dataOutputStream;
	
	public static void main(String[] args) throws Exception {
		
		byteArrayOutputStream = new ByteArrayOutputStream();
		
		dataOutputStream = new DataOutputStream(byteArrayOutputStream);
		
		dataOutputStream.writeDouble(12.8);
		
		buff = byteArrayOutputStream.toByteArray();
		
		datagramSocket = new DatagramSocket(8888);
		
		datagramPacket = new DatagramPacket(buff, buff.length, new InetSocketAddress("localhost", 6666));
		
		datagramSocket.send(datagramPacket);
		
	}

}
