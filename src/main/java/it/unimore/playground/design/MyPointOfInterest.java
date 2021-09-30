package it.unimore.playground.design;

import java.util.ArrayList;

/**
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project java-playground
 * @created 27/09/2021 - 12:45
 */
public class MyPointOfInterest {

    private String name;

    private GeoLocation location;

    private ArrayList<MyDevice> deviceList;

    public MyPointOfInterest() {
        this.deviceList = new ArrayList<>();
    }

    public MyPointOfInterest(String name, GeoLocation location) {
        this();
        this.name = name;
        this.location = location;
    }

    public void addDevice(MyDevice device){
        if(this.deviceList != null && device != null)
            this.deviceList.add(device);
        else
            System.err.println("Error adding new Device !");
    }

    public void removeDevice(String deviceId){
        //TODO Add remove method
    }

    public void addDeviceList(ArrayList<MyDevice> deviceList){
        if(this.deviceList != null && deviceList != null && deviceList.size() > 0)
            this.deviceList.addAll(deviceList);
    }

    public GeoLocation getLocation() {
        return location;
    }

    public void setLocation(GeoLocation location) {
        this.location = location;
    }

    public ArrayList<MyDevice> getDeviceList() {
        return deviceList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MyPointOfInterest{");
        sb.append("name='").append(name).append('\'');
        sb.append(", location=").append(location.toString());
        sb.append(", deviceList=").append(deviceList);
        sb.append('}');
        return sb.toString();
    }
}
