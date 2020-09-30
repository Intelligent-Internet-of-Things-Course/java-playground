package it.unimore.playground.sensor.model;

/**
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project java-playground
 * @created 30/09/2020 - 10:58
 */
public class SensorDataRequest {

    public static final String GET_REQUEST = "GET";
    public static final String CREATE_REQUEST = "CREATE";
    public static final String UPDATE_REQUEST = "UPDATE";
    public static final String DELETE_REQUEST = "DELETE";

    private String type;

    private String sensorId;

    public SensorDataRequest() {
    }

    public SensorDataRequest(String type, String sensorId) {
        this.type = type;
        this.sensorId = sensorId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SensorDataRequest{");
        sb.append("type='").append(type).append('\'');
        sb.append(", sensorId='").append(sensorId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
