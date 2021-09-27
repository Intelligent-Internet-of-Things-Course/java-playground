package it.unimore.playground.design;

/**
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project java-playground
 * @created 27/09/2021 - 12:43
 */
public class MyDevice {

    private String id;
    private String type;
    private String manufacturer;
    private String softwareVersion;

    public MyDevice() {
    }

    public MyDevice(String id, String type, String manufacturer, String softwareVersion) {
        this.id = id;
        this.type = type;
        this.manufacturer = manufacturer;
        this.softwareVersion = softwareVersion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MyDevice{");
        sb.append("id='").append(id).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", manufacturer='").append(manufacturer).append('\'');
        sb.append(", softwareVersion='").append(softwareVersion).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
