package it.unimore.playground.sensor.process.simple;

import com.google.gson.Gson;
import it.unimore.playground.sensor.model.SensorData;
import it.unimore.playground.sensor.model.TemperatureSensorDescriptor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Random;


/**
 * UDP Temperature Sensor server.
 * It receives requests formed by the 'GET' string followed by the sensor id,
 * and responds with 'OK' followed by sensor id and SensorData structure payload (in JSON format).
 */
public class UdpTemperatureSensorServer {

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

			if (request.startsWith("GET " + temperatureSensorDescriptor.getDeviceId())) {

				//Update Temperature Sensor Value
				sensorData.setValue(rand.nextFloat());

				//Custom Response -> RESPONSE CODE + JSON RESPONSE

				String responseJsonPayload = generateSensorDataPayloadString(sensorData);

				if(responseJsonPayload == null)
					System.err.println("Error Generating JSON Payload ! Payload = Null !");
				else {

					String response = "OK " + responseJsonPayload;

					packet.setData(response.getBytes());
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

	private static String generateSensorDataPayloadString(SensorData sensorData){

		try{
			Gson gson = new Gson();
			return gson.toJson(sensorData);
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}

	}

}
