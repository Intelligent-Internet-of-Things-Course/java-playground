package it.unimore.playground.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;

import com.google.gson.Gson;
import it.unimore.playground.model.SensorData;


/** Program that sends a request message to a UDP sensor server and receives the response.
 * <p>
 * The request should be formed by the string 'GET' followed by the sensor id,
 * while the response is formed by the string 'OK' followed by a JSON string containing the sensor id and value.
 */
public class UdpSensorClient {

	public static void main(String[] args) throws IOException {

		String destAddr="127.0.0.1";
		int destPort=4000;
		String request="GET sensor02";

		DatagramSocket socket=new DatagramSocket();

		byte[] data=request.getBytes();

		DatagramPacket packet=new DatagramPacket(data,data.length);
		packet.setAddress(Inet4Address.getByName(destAddr));
		packet.setPort(destPort);

		socket.send(packet);

		System.out.println("request: "+request);

		byte[] buffer=new byte[2000];
		packet=new DatagramPacket(buffer,buffer.length);
		socket.receive(packet);
		socket.close();	

		String response=new String(packet.getData(),packet.getOffset(),packet.getLength());

		System.out.println("response: "+response);

		if (response.startsWith("OK ")) {

			response=response.substring(3);
			Gson gson=new Gson();
			SensorData sensorData=gson.fromJson(response,SensorData.class);
			System.out.println("id: "+sensorData.id);
			System.out.println("value: "+sensorData.value);

		}
	}

}
