package it.unimore.playground.design;

/**
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project java-playground
 * @created 30/09/2021 - 12:10
 */
public class SensorDevice extends MyDevice {

    private double measurement;

    public SensorDevice(double measurement) {
        this.measurement = measurement;
    }

    public SensorDevice(String id, String type, String manufacturer, String softwareVersion, double measurement) {
        super(id, type, manufacturer, softwareVersion);
        this.measurement = measurement;
    }

    public SensorDevice(String id, String type, String manufacturer, String softwareVersion, GeoLocation location, double measurement) {
        super(id, type, manufacturer, softwareVersion, location);
        this.measurement = measurement;
    }

    public double getMeasurement() {
        return measurement;
    }

    public void setMeasurement(double measurement) {
        this.measurement = measurement;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SensorDevice{");
        sb.append("measurement=").append(measurement);
        sb.append('}');
        return sb.toString();
    }
}
