package it.unimore.playground.sensor.process.advanced;

import com.google.gson.Gson;
import it.unimore.playground.sensor.model.SensorData;
import it.unimore.playground.sensor.model.SensorDataRequest;
import it.unimore.playground.sensor.model.SensorDataResponse;
import it.unimore.playground.sensor.model.TemperatureSensorDescriptor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Random;


/**
 * UDP Temperature Sensor server.
 * It receives a JSON requests structured through the SensorDataRequest class and responds with
 * a JSON message structured using the SensorDataResponse class..
 */
public class UdpAdvancedTemperatureSensorServer {

	public static void main(String[] args) throws IOException {

		DatagramSocket socket = new DatagramSocket(4000);

		System.out.println("Sensor server running on UDP port: "+socket.getLocalPort());

		byte[] buffer = new byte[2000];
		DatagramPacket packet = new DatagramPacket(buffer,buffer.length);

		System.out.println("waiting...");

		Random rand = new Random();

		//Init Temperature Sensor Descriptor
		TemperatureSensorDescriptor temperatureSensorDescriptor = new TemperatureSensorDescriptor("tempSensor1", "0.0.1", "Acme Corporation");
		SensorData sensorData = new SensorData(temperatureSensorDescriptor, rand.nextFloat());

		while (true) {

			socket.receive(packet);
			String request = new String(packet.getData(),packet.getOffset(),packet.getLength());
			System.out.println("Request received from "+packet.getSocketAddress().toString().substring(1)+": "+request);

			SensorDataRequest sensorDataRequest = parseRequest(request);

			if (sensorDataRequest != null && sensorDataRequest.getSensorId().equals(temperatureSensorDescriptor.getDeviceId())) {

				//Update Temperature Sensor Value
				sensorData.setValue(rand.nextFloat());

				String responseJsonPayload = generateSensorDataResponsePayloadString(SensorDataResponse.OK_RESPOSE, sensorData);

				if(responseJsonPayload == null)
					System.err.println("Error Generating JSON Payload ! Payload = Null !");
				else {

					packet.setData(responseJsonPayload.getBytes());
					socket.send(packet);
				}
			}
			else {
				packet.setData("Error".getBytes());
				socket.send(packet);
			}

			packet.setData(buffer);
		}

		//socket.close();
	}

	private static SensorDataRequest parseRequest(String requestPayload){
		try{
			Gson gson = new Gson();
			return gson.fromJson(requestPayload, SensorDataRequest.class);
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	private static String generateSensorDataResponsePayloadString(String responseStatus, SensorData sensorData){
		try{
			Gson gson = new Gson();
			return gson.toJson(new SensorDataResponse(responseStatus, sensorData));
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
