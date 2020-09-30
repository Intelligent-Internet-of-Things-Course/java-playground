package it.unimore.playground.sensor.process.raw;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Random;


/**
 * UDP sensor server.
 * It receives requests formed by the 'GET' string followed by the sensor id,
 * and responds with 'OK' followed by sensor id and data (in JSON format).
 */
public class UdpRawSensorServer {

	public static void main(String[] args) throws IOException {

		DatagramSocket socket = new DatagramSocket(4000);

		System.out.println("Sensor server running on UDP port: "+socket.getLocalPort());

		byte[] buffer = new byte[2000];
		DatagramPacket packet = new DatagramPacket(buffer,buffer.length);

		System.out.println("waiting...");

		Random rand = new Random();

		while (true) {

			socket.receive(packet);
			String request = new String(packet.getData(),packet.getOffset(),packet.getLength());
			System.out.println("Request received from "+packet.getSocketAddress().toString().substring(1)+": "+request);

			if (request.startsWith("GET ")) {

				String id = request.substring(4);
				float value = rand.nextFloat();

				//Custom Response -> RESPONSE CODE + JSON RESPONSE
				String response = "OK {\"id\":\""+id+"\",\"value\":"+value+"}";

				packet.setData(response.getBytes());
				socket.send(packet);
			}
			else {
				packet.setData("Error".getBytes());
				socket.send(packet);
			}

			packet.setData(buffer);
		}

		//socket.close();
	}

}
