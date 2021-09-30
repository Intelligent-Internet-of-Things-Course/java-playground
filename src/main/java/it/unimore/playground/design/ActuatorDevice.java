package it.unimore.playground.design;

/**
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project java-playground
 * @created 30/09/2021 - 12:10
 */
public class ActuatorDevice extends MyDevice {

    private double operatingValue;

    public ActuatorDevice(double operatingValue) {
        this.operatingValue = operatingValue;
    }

    public ActuatorDevice(String id, String type, String manufacturer, String softwareVersion, double operatingValue) {
        super(id, type, manufacturer, softwareVersion);
        this.operatingValue = operatingValue;
    }

    public ActuatorDevice(String id, String type, String manufacturer, String softwareVersion, GeoLocation location, double operatingValue) {
        super(id, type, manufacturer, softwareVersion, location);
        this.operatingValue = operatingValue;
    }

    public double getOperatingValue() {
        return operatingValue;
    }

    public void setOperatingValue(double operatingValue) {
        this.operatingValue = operatingValue;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ActuatorDevice{");
        sb.append("operatingValue=").append(operatingValue);
        sb.append('}');
        return sb.toString();
    }
}
