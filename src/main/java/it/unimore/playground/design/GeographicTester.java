package it.unimore.playground.design;


/**
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project java-playground
 * @created 02/10/2025 - 15:42
 */
public class GeographicTester {

    public static void main(String[] args) {

        // Create two Geographic Points
        GeoLocation geoLocation1 = new GeoLocation(10.444444, 44.1111);
        GeoLocation geoLocation2 = new GeoLocation(11.444444, 41.1111);

        // Compute distance in meters using static method on GeoLocation class
        double distance1 = GeoLocation.distanceMeters(geoLocation1, geoLocation2);
        System.out.println("Distance 1: " + distance1);

        // Compute the distance using the GeoLocation public method (not static)
        double distance2 = geoLocation1.distanceTo(geoLocation2);
        System.out.println("Distance 2: " + distance1);

    }

}
