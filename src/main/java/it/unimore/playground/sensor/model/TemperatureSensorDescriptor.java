package it.unimore.playground.sensor.model;

/**
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project java-playground
 * @created 30/09/2020 - 10:35
 */
public class TemperatureSensorDescriptor extends DeviceDescriptor{

    public static final String TEMPERATURE_SENSOR_TYPE = "temperature_sensor";

    public TemperatureSensorDescriptor() {
        super();
    }

    public TemperatureSensorDescriptor(String deviceId, String softwareVersion, String producer) {
        super(deviceId, softwareVersion, producer, TEMPERATURE_SENSOR_TYPE);
    }
}
