package com.example.android.ulmtourguide;

import java.io.Serializable;
/**
 * Created by Daniel on 15.04.2018.
 */

/**
 * {@link Destination} represents a destination that the user can visit.
 * It contains a the name of the destination, where it is located or which kind of (in case of restaurants and bars).
 */
public class Destination implements Serializable {

    /**
     * Name of the location
     */
    private String mLocationName;

    /**
     * Where it is located
     */
    private String mLocationDestination;

    /**
     * Which kind of location
     */
    private String mLocationCategory;

    /**
     * ID of the corresponding Image of a location
     */
    private int mImageResourceID = NO_IMAGE_PROVIDED;

    /**
     * constant for check if an image is provided
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Destination object.
     *
     * @param locationName        is the name of the location
     * @param locationDestination is the area where the location is adressed
     * @param locationCategory    give details, e.g. which kind of restaurant/bar
     */
    public Destination(String locationName, String locationDestination, String locationCategory) {
        mLocationName = locationName;
        mLocationDestination = locationDestination;
        mLocationCategory = locationCategory;
    }

    /**
     * Create a new Destination object.
     *
     * @param locationName        is the name of the location
     * @param locationDestination is the area where the location is adressed
     * @param locationCategory    give details, e.g. which kind of restaurant/bar
     * @param ImageResourceID     is the ID of the corresponding Image
     */
    public Destination(String locationName, String locationDestination, String locationCategory, int ImageResourceID) {
        mLocationName = locationName;
        mLocationDestination = locationDestination;
        mLocationCategory = locationCategory;
        mImageResourceID = ImageResourceID;
    }

    /**
     * Get the name of the location.
     */
    public String getLocationName() {
        return mLocationName;
    }

    /**
     * Get the kind of destination.
     */
    public String getLocationCategory() {
        return mLocationCategory;
    }

    /**
     * Get the Destination.
     */
    public String getLocationDestination() {
        return mLocationDestination;
    }

    /**
     * Get the corresponding ID of each Destination.
     */
    public int getImageResourceID() {
        return mImageResourceID;
    }

    /**
     * check if an image is provided or not
     */
    public boolean hasImage() {
        return mImageResourceID != NO_IMAGE_PROVIDED;
    }

}