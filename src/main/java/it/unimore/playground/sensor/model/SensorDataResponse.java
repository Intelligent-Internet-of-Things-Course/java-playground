package it.unimore.playground.sensor.model;

/**
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project java-playground
 * @created 30/09/2020 - 11:00
 */
public class SensorDataResponse {

    public static final String OK_RESPOSE = "OK";
    public static final String ERROR_RESPONSE = "ERROR";

    private String status;

    private SensorData sensorData;

    public SensorDataResponse() {
    }

    public SensorDataResponse(String status, SensorData sensorData) {
        this.status = status;
        this.sensorData = sensorData;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SensorData getSensorData() {
        return sensorData;
    }

    public void setSensorData(SensorData sensorData) {
        this.sensorData = sensorData;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SensorDataResponse{");
        sb.append("status='").append(status).append('\'');
        sb.append(", sensorData=").append(sensorData);
        sb.append('}');
        return sb.toString();
    }
}
