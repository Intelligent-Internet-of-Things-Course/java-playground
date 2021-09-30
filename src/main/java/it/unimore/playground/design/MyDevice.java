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
    private GeoLocation location;

    public MyDevice() {
    }

    public MyDevice(String id, String type, String manufacturer, String softwareVersion) {
        this.id = id;
        this.type = type;
        this.manufacturer = manufacturer;
        this.softwareVersion = softwareVersion;
    }

    public MyDevice(String id, String type, String manufacturer, String softwareVersion, GeoLocation location) {
        this(id, type, manufacturer, softwareVersion);
        this.location = location;
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

    public GeoLocation getLocation() {
        return location;
    }

    public void setLocation(GeoLocation location) {
        this.location = location;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MyDevice{");
        sb.append("id='").append(id).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", manufacturer='").append(manufacturer).append('\'');
        sb.append(", softwareVersion='").append(softwareVersion).append('\'');
        sb.append(", location=").append(location);
        sb.append('}');
        return sb.toString();
    }
}
