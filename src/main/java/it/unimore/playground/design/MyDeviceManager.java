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
}
