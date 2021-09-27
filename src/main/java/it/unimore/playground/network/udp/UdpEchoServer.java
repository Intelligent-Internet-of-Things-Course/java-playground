package it.unimore.playground.network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


/**
 * UDP echo server.
 * It replies back the received data.
 */
public class UdpEchoServer {

	public static void main(String[] args) throws IOException {

		DatagramSocket socket = new DatagramSocket(4000);

		System.out.println("UDP echo server on port: "+socket.getLocalPort());

		byte[] buffer = new byte[2000];

		DatagramPacket packet = new DatagramPacket(buffer,buffer.length);

		System.out.println("waiting...");

		while (true) {

			socket.receive(packet);

			String data = new String(packet.getData(),packet.getOffset(),packet.getLength());

			System.out.println("from '"+packet.getSocketAddress()+"': "+data);

			socket.send(packet);
		}

		//socket.close();
	}

}
