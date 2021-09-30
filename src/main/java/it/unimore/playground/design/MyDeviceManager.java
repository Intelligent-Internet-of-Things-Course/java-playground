package it.unimore.playground.design;

import java.util.ArrayList;

/**
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project java-playground
 * @created 27/09/2021 - 12:52
 */
public class MyDeviceManager {

    private ArrayList<MyPointOfInterest> poiList = null;

    public MyDeviceManager() {
        this.poiList = new ArrayList<>();
    }

    public void addPoI(MyPointOfInterest pointOfInterest){
        if(this.poiList != null && pointOfInterest != null)
            this.poiList.add(pointOfInterest);
        else
            System.err.println("Error Adding PoI");
    }

    public ArrayList<MyPointOfInterest> getPoiList() {
        return poiList;
    }

    public ArrayList<MyDevice> searchDeviceByType(String deviceType){
        return this.searchDeviceByTypeAndPoI(deviceType, null);
    }

    public ArrayList<MyDevice> searchDeviceByTypeAndPoI(String deviceType, String poiName){

        if(this.poiList == null || this.poiList.size() == 0)
            return null;

        ArrayList<MyDevice> resultList = new ArrayList<>();

        for(MyPointOfInterest pointOfInterest : this.getPoiList()){
            if(pointOfInterest != null
                    && pointOfInterest.getDeviceList() != null
                    && pointOfInterest.getDeviceList().size() > 0){

                if(poiName == null || poiName.equals(pointOfInterest.getName()) )
                        for(MyDevice device : pointOfInterest.getDeviceList())
                            if(device != null && device.getType() != null && device.getType().equals(deviceType))
                                resultList.add(device);
                    else
                        break;
            }
        }

        return resultList;
    }

    public ArrayList<MyDevice> searchMobileDeviceByEngineType(String engineType){

        if(this.poiList == null || this.poiList.size() == 0)
            return null;

        ArrayList<MyDevice> resultList = new ArrayList<>();

        for(MyPointOfInterest pointOfInterest : this.getPoiList()){
            if(pointOfInterest != null
                    && pointOfInterest.getDeviceList() != null
                    && pointOfInterest.getDeviceList().size() > 0){
                for(MyDevice device : pointOfInterest.getDeviceList())
                    if(device != null
                            && device.getType() != null
                            && device instanceof MobileDevice){
                        MobileDevice mobileDevice = (MobileDevice) device;
                        if(mobileDevice.getEngineType().equals(engineType))
                            resultList.add(device);
                    }
            }
        }

        return resultList;
    }

}
