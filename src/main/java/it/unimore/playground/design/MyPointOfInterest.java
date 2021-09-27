package it.unimore.playground.design;

import java.util.ArrayList;

/**
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project java-playground
 * @created 27/09/2021 - 12:45
 */
public class MyPointOfInterest {

    private String name;

    private double latitude;

    private double longitude;

    private ArrayList<MyDevice> deviceList;

    public MyPointOfInterest() {
        this.deviceList = new ArrayList<>();
    }

    public MyPointOfInterest(String name, double latitude, double longitude) {
        this();
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public MyPointOfInterest(double latitude, double longitude) {
        this();
        this.latitude = latitude;
        this.longitude = longitude;
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
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
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", deviceList=").append(deviceList);
        sb.append('}');
        return sb.toString();
    }
}
