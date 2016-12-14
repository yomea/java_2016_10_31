package socket;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPService {
	
	static DatagramSocket datagramSocket;
	
	static DatagramPacket datagramPacket;
	
	static byte[] buff;
	
	static ByteArrayInputStream byteArrayInputStream;
	
	static DataInputStream dataInputStream;
	
	public static void main(String[] args) throws Exception {
		
		datagramSocket = new DatagramSocket(6666);
		
		buff = new byte[1024];
		
		datagramPacket = new DatagramPacket(buff, buff.length);
		
		datagramSocket.receive(datagramPacket);
		
		buff = datagramPacket.getData();
		
		byteArrayInputStream = new ByteArrayInputStream(buff);
		
		dataInputStream = new DataInputStream(byteArrayInputStream);
		
		double dou = dataInputStream.readDouble();
		
		System.out.println(dou);
		
	}

}
