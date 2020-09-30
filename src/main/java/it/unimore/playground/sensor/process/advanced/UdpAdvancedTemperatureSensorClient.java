package it.unimore.playground.sensor.process.advanced;

import com.google.gson.Gson;
import it.unimore.playground.sensor.model.SensorData;
import it.unimore.playground.sensor.model.SensorDataRequest;
import it.unimore.playground.sensor.model.SensorDataResponse;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;

/**
 * Program that sends a request message to a UDP sensor server and receives the response.
 * The request is through the SensorDataRequest class and the response with the SensorDataResponse object.
 * Both request and response are serialized and deserialized using JSON.
 */
public class UdpAdvancedTemperatureSensorClient {

	public static void main(String[] args) throws IOException {

		String destAddr = "127.0.0.1";
		int destPort = 4000;

		SensorDataRequest sensorDataRequest = new SensorDataRequest(SensorDataRequest.GET_REQUEST, "tempSensor1");

		String requestPayload = generateSensorDataRequestPayloadString(sensorDataRequest);

		DatagramSocket socket = new DatagramSocket();

		byte[] data = requestPayload.getBytes();

		DatagramPacket packet = new DatagramPacket(data,data.length);
		packet.setAddress(Inet4Address.getByName(destAddr));
		packet.setPort(destPort);

		socket.send(packet);

		System.out.println("request: "+requestPayload);

		byte[] buffer = new byte[2000];
		packet = new DatagramPacket(buffer,buffer.length);
		socket.receive(packet);
		socket.close();	

		String response = new String(packet.getData(),packet.getOffset(),packet.getLength());

		System.out.println("response: "+response);

		SensorDataResponse sensorDataResponse = parseSensorDataResponse(response);

		if (sensorDataResponse != null) {

			if(sensorDataResponse.getStatus().equals(SensorDataResponse.OK_RESPOSE)){
				System.out.println("RawSensorData Object -> Device Descriptor: " + sensorDataResponse.getSensorData().getDeviceDescriptor());
				System.out.println("RawSensorData Object -> Value: " + sensorDataResponse.getSensorData().getValue());
			}
			else
				System.err.println("Response Error ! Check the request");
		}
		else
			System.err.println("Error ! SensorDataResponse = Null !");
	}

	private static String generateSensorDataRequestPayloadString(SensorDataRequest sensorDataRequest){
		try{
			Gson gson = new Gson();
			return gson.toJson(sensorDataRequest);
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Parse incoming String into a SensorData object
	 * @param payloadString
	 * @return
	 */
	private static SensorDataResponse parseSensorDataResponse(String payloadString){
		try{
			Gson gson = new Gson();
			return gson.fromJson(payloadString, SensorDataResponse.class);
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
