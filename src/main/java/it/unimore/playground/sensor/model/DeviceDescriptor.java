package it.unimore.playground.sensor.model;

/**
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project java-playground
 * @created 30/09/2020 - 10:32
 */
public class DeviceDescriptor {

    private String deviceId = null;

    private String softwareVersion = null;

    private String producer = null;

    private String type = null;

    public DeviceDescriptor() {
    }

    public DeviceDescriptor(String deviceId, String softwareVersion, String producer, String type) {
        this.deviceId = deviceId;
        this.softwareVersion = softwareVersion;
        this.producer = producer;
        this.type = type;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DeviceDescriptor{");
        sb.append("deviceId='").append(deviceId).append('\'');
        sb.append(", softwareVersion='").append(softwareVersion).append('\'');
        sb.append(", producer='").append(producer).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
