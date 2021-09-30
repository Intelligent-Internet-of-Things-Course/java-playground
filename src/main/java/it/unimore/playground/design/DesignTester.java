package it.unimore.playground.design;

import java.util.ArrayList;

/**
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project java-playground
 * @created 27/09/2021 - 12:57
 */
public class DesignTester {

    public static void main(String[] args) {

        MyPointOfInterest fumPoI = initFumPoI();
        MyPointOfInterest palazzoDucalePoI = initPalazzoDucalePoI();

        MyDeviceManager deviceManager = new MyDeviceManager();
        deviceManager.addPoI(fumPoI);
        deviceManager.addPoI(palazzoDucalePoI);

        System.out.println("\nSearching for vehicle devices ....");

        ArrayList<MyDevice> vehicleList = deviceManager.searchDeviceByType("vehicle");
        printDeviceList(vehicleList);

        System.out.println("\nSearching for temperature_sensor devices ....");

        ArrayList<MyDevice> temperatureSensorList = deviceManager.searchDeviceByType("temperature_sensor");
        printDeviceList(temperatureSensorList);

        System.out.println("\nSearching for MobileDevice with diesel engine ....");

        ArrayList<MyDevice> dieselMobileDeviceList = deviceManager.searchMobileDeviceByEngineType(MobileDevice.ENGINE_TYPE_DIESEL);
        printDeviceList(dieselMobileDeviceList);

        System.out.println("\nSearching for vehicle devices at FUM PoI");

        vehicleList = deviceManager.searchDeviceByTypeAndPoI("vehicle", fumPoI.getName());
        printDeviceList(vehicleList);
    }

    private static void printDeviceList(ArrayList<MyDevice> deviceList){
        for(MyDevice foundDevice : deviceList)
            System.out.println("DeviceId: " + foundDevice.getId() + " Info: " + foundDevice);
    }

    private static MyPointOfInterest initFumPoI(){

        GeoLocation locationFumLaboratory = new GeoLocation(45.16023344872982, 10.788464186761697);
        MyPointOfInterest fumPoI = new MyPointOfInterest("FUM-Mantova", locationFumLaboratory);

        MobileDevice mobileDevice = new MobileDevice("device-00001",
                "vehicle",
                "acme-inc",
                "0.0.1-rc",
                locationFumLaboratory,
                MobileDevice.ENGINE_TYPE_DIESEL,
                10.0,
                MobileDevice.DEFAULT_EMISSION_UNIT);

        SensorDevice sensorDevice = new SensorDevice("device-00002",
                "temperature_sensor",
                "acme-inc",
                "0.0.1-rc",
                locationFumLaboratory,
                36.5);

        ActuatorDevice actuatorDevice = new ActuatorDevice("device-00003",
                "light_switch",
                "acme-inc",
                "0.0.1-rc",
                locationFumLaboratory,
                0.0);

        fumPoI.addDevice(mobileDevice);
        fumPoI.addDevice(sensorDevice);
        fumPoI.addDevice(actuatorDevice);

       return fumPoI;
    }

    private static MyPointOfInterest initPalazzoDucalePoI(){

        GeoLocation locationPalazzoDucaleMantova = new GeoLocation(45.16055364298056, 10.799876649097172);
        MyPointOfInterest palazzoDucalePoI = new MyPointOfInterest("Palazzo-Ducale-Mantova", locationPalazzoDucaleMantova);

        MobileDevice mobileDevice2 = new MobileDevice("device-00004",
                "vehicle",
                "acme-inc",
                "0.0.1-rc",
                locationPalazzoDucaleMantova,
                MobileDevice.ENGINE_TYPE_ELECTRIC,
                0.0,
                MobileDevice.DEFAULT_EMISSION_UNIT);

        SensorDevice sensorDevice2 = new SensorDevice("device-00005",
                "temperature_sensor",
                "acme-inc",
                "0.0.1-rc",
                locationPalazzoDucaleMantova,
                36.5);

        ActuatorDevice actuatorDevice2 = new ActuatorDevice("device-00006",
                "light_switch",
                "acme-inc",
                "0.0.1-rc",
                locationPalazzoDucaleMantova,
                0.0);

        palazzoDucalePoI.addDevice(mobileDevice2);
        palazzoDucalePoI.addDevice(sensorDevice2);
        palazzoDucalePoI.addDevice(actuatorDevice2);

        return palazzoDucalePoI;
    }

}
