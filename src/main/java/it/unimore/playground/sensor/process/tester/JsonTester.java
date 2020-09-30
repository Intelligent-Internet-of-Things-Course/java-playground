package it.unimore.playground.sensor.process.tester;

import com.google.gson.Gson;
import it.unimore.playground.sensor.model.SensorData;
import it.unimore.playground.sensor.model.TemperatureSensorDescriptor;

import java.util.Random;

/**
 *
 * Json & GSON Library Test Class
 *
 */
public class JsonTester {

    public static void main(String[] args) {

        //Random number generator
        Random rand = new Random();

        TemperatureSensorDescriptor temperatureSensorDescriptor = new TemperatureSensorDescriptor("tempSensor1", "0.0.1", "Acme Corporation");
        SensorData sensorData = new SensorData(temperatureSensorDescriptor, rand.nextFloat());

        System.out.println("Original SensorData: " + sensorData.toString() + " ObjectId: " + System.identityHashCode(sensorData));

        //Init Gson main object to handle Json serialization and deserialization
        Gson gson = new Gson();

        String serializedJsonString = gson.toJson(sensorData);

        System.out.println("SensorData -> Serialized Json String: " + serializedJsonString);

        SensorData deserializedObject = gson.fromJson(serializedJsonString, SensorData.class);

        System.out.println("Deserialized SensorData: " + deserializedObject.toString() + " ObjectId: " + System.identityHashCode(deserializedObject));

    }

}
