package it.unimore.playground.sensor.process.raw;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;

import com.google.gson.Gson;
import it.unimore.playground.sensor.model.RawSensorData;

/**
 * Program that sends a request message to a UDP sensor server and receives the response.
 * The request should be formed by the string 'GET' followed by the sensor id,
 * while the response is formed by the string 'OK' followed by a JSON string containing the sensor id and value.
 */
public class UdpRawSensorClient {

	public static void main(String[] args) throws IOException {

		String destAddr = "127.0.0.1";
		int destPort = 4000;

		//Custom Command Request to access target sensor data
		String request = "GET sensor02";

		DatagramSocket socket = new DatagramSocket();

		byte[] data = request.getBytes();

		DatagramPacket packet = new DatagramPacket(data,data.length);
		packet.setAddress(Inet4Address.getByName(destAddr));
		packet.setPort(destPort);

		socket.send(packet);

		System.out.println("request: "+request);

		byte[] buffer = new byte[2000];
		packet = new DatagramPacket(buffer,buffer.length);
		socket.receive(packet);
		socket.close();	

		String response = new String(packet.getData(),packet.getOffset(),packet.getLength());

		System.out.println("response: "+response);

		if (response.startsWith("OK ")) {

			//Remove Control String
			response = response.substring(3);

			RawSensorData rawSensorData = parseJsonString(response);

			if(rawSensorData != null){
				System.out.println("RawSensorData Object -> id: " + rawSensorData.id);
				System.out.println("RawSensorData Object -> value: " + rawSensorData.value);
			}
			else
				System.err.println("Error Parsing Response ! SensorData = Null !");
		}
	}

	/**
	 * Parse incoming String into a RawSensorData object
	 * @param payloadString
	 * @return
	 */
	private static RawSensorData parseJsonString(String payloadString){
		try{
			Gson gson = new Gson();
			return gson.fromJson(payloadString, RawSensorData.class);
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
