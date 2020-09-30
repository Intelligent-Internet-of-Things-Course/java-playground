package it.unimore.playground.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Program that receives a UDP packet and prints the textual payload.
 */
public class UdpReceiver {
	
	public static void main(String[] args) throws IOException {

		DatagramSocket socket = new DatagramSocket(4000);

		System.out.println("UDP receiver on port: "+socket.getLocalPort());

		byte[] buffer = new byte[2000];

		DatagramPacket packet = new DatagramPacket(buffer,buffer.length);

		System.out.println("waiting...");

		socket.receive(packet);

		String data = new String(packet.getData(),packet.getOffset(),packet.getLength());

		System.out.println("from '"+packet.getSocketAddress()+"': "+data);

		socket.close();
	}

}
