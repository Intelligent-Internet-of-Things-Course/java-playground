package it.unimore.playground.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;


/**
 * Program that sends a message to a UDP server and receives the reply.
 */
public class UdpClient {

	public static void main(String[] args) throws IOException {

		String destAddr = "127.0.0.1";
		int destPort = 4000;
		byte[] data = "test".getBytes();

		DatagramSocket socket = new DatagramSocket();

		DatagramPacket packet = new DatagramPacket(data,data.length);
		packet.setAddress(Inet4Address.getByName(destAddr));
		packet.setPort(destPort);

		socket.send(packet);

		System.out.println("sent: "+new String(data));

		byte[] buffer = new byte[2000];

		packet = new DatagramPacket(buffer,buffer.length);

		socket.receive(packet);

		String resp = new String(packet.getData(),packet.getOffset(),packet.getLength());

		System.out.println("received: "+resp);

		socket.close();
	}

}
