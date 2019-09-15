package com.example.grumpybunny.tourguideapp;

public class Places {

    /**
     * this custom class contains fields that will be used by
     * Hotel, Attractions, Restaurants, and Calendar classes
     */

    private String name;
    private String address;  /* Map Intent - https://developers.google.com/maps/documentation/urls/android-intents */
    private String phone;
    private String websiteURI;
    private int photo;
    private int ICalBegin;
    private int ICalEnd;

    /**
     * Create a new Places object.
     */
    public Places(String placeName, String placeAddress, String placePhone, String placeWebsiteURI, int placePhoto) {
        name = placeName;
        address = placeAddress;
        phone = placePhone;
        websiteURI = placeWebsiteURI;
        photo = placePhoto;
    }

    /**
     * Create a second Places object with different arguments ( for Calendar output).
     */
    public Places(String placeName, String placeAddress, String placeWebsiteURI, int placePhoto, int placeICalBegin, int placeICalEnd) {
        name = placeName;
        address = placeAddress;
        ICalBegin = placeICalBegin;
        ICalEnd = placeICalEnd;
        websiteURI = placeWebsiteURI;
        photo = placePhoto;
    }

    public String getPlaceName() {
        return name;
    }

    public String getplaceAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getICalBegin() {
        return ICalBegin;
    }

    public int getICalEnd() {
        return ICalEnd;
    }

    public String getWebsiteURI() {
        return websiteURI;
    }

    public int getPhoto() {
        return photo;
    }

}
