package com.example.grumpybunny.tourguideapp;

public class Places {

    /** this custom class contains fields that will be used by
     * Hotel, Attractions, Restaurants classes
     */

    /** 20 hotest restaurants in DC
     * https://washington.org/visit-dc/hot-new-restaurants-try-now-washington-dc
     */
    private String name;
    private String address;  /* Map Intent - https://developers.google.com/maps/documentation/urls/android-intents */
    private String phone;
    private String websiteURI;
    private int photo;

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

    public String getPlaceName() {
        return name;
    }
    public String getplaceAddress() { return address; }
    public String getPhone() { return phone; }
    public String getWebsiteURI() { return websiteURI; }
    public int getPhoto() { return photo; }

}
