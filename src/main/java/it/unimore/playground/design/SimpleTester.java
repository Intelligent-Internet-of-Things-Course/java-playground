package it.unimore.playground.design;

import java.util.ArrayList;

/**
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project java-playground
 * @created 03/10/2022 - 10:57
 */
public class SimpleTester {

    public static void main(String[] args) {

        MyDevice device1 = new MyDevice("device001",
                "testDeviceType",
                "ACME Srl",
                "0.0.1");

        System.out.println("Device 1: " + device1);

        MyDevice device2 = new MyDevice("device002",
                "testDeviceType",
                "ACME Srl",
                "0.0.2");

        System.out.println("Device 2: " + device1);

        ArrayList<MyDevice> deviceList = new ArrayList<>();
        deviceList.add(device1);
        deviceList.add(device2);

        System.out.println("Device List Size: " +
                deviceList.size());

        for(MyDevice myDevice : deviceList)
            System.out.println("Device in List: " +
                    myDevice);

    }

}
