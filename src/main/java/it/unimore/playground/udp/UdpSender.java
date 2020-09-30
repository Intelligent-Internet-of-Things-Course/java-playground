package it.unimore.playground.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;


/**
 * Program that sends a UDP packet.
 */
public class UdpSender {

	public static void main(String[] args) throws IOException {

		String destAddr = "127.0.0.1";
		int destPort = 4000;

		byte[] data = "test".getBytes();

		DatagramSocket socket = new DatagramSocket();

		DatagramPacket packet = new DatagramPacket(data,data.length);
		packet.setAddress(Inet4Address.getByName(destAddr));
		packet.setPort(destPort);

		socket.send(packet);

		System.out.println("data sent to "+destAddr+":"+destPort);

		socket.close();
	}

}
