package it.unimore.playground.sensor.model;

/**
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project java-playground
 * @created 30/09/2020 - 12:45
 */
public class HumiditySensorDescriptor extends DeviceDescriptor{

    public static final String HUMIDITY_SENSOR_TYPE = "humidity_sensor";

    public HumiditySensorDescriptor(String deviceId, String softwareVersion, String producer) {
        super(deviceId, softwareVersion, producer, HUMIDITY_SENSOR_TYPE);
    }

}
