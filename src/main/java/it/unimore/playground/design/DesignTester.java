package it.unimore.playground.design;

import java.util.ArrayList;

/**
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project java-playground
 * @created 27/09/2021 - 12:57
 */
public class DesignTester {

    public static void main(String[] args) {

        MyDevice device1 = new MyDevice("0001",
                "temperature-sensor",
                "acme-inc",
                "0.0.1-beta");

        MyDevice device2 = new MyDevice("0002",
                "presence-sensor",
                "acme-inc",
                "0.0.1-beta");

        MyPointOfInterest pointOfInterest = new MyPointOfInterest(
                10.432122,
                44.1413132
        );

        pointOfInterest.addDevice(device1);
        pointOfInterest.addDevice(device2);

        MyDeviceManager deviceManager = new MyDeviceManager();
        deviceManager.addPoI(pointOfInterest);

        //Print all POI
        ArrayList<MyPointOfInterest> deviceList = deviceManager.getPoiList();
        for(MyPointOfInterest poi : deviceList) {

            System.out.println("PoI Name: " + poi.getName() + " Latitude: " + poi.getLatitude() + " Longitude: " + poi.getLongitude());
            System.out.println("Device List:");

            for (MyDevice device : poi.getDeviceList())
                System.out.println(device);

        }
    }

}
