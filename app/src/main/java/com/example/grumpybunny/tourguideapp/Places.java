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
    private String addressURI; /* maps specific link to the address */
    private String phone;
//    private String website;
    private String websiteURI;
    private String reviewStars;
    private int photo;
    private String twitterURI;
    private String hours;

    /**
     * Create a new Places object.
     */
    public Places(String placeName, String placeAddress, String placeAddressURI,
                String placePhone, String placeWebsiteURI, String placeReviewStars, int placePhoto,
                  String placeTwitterURI, String placeHours) {
        name = placeName;
        address = placeAddress;
        addressURI = placeAddressURI;
        phone = placePhone;
        websiteURI = placeWebsiteURI;
        reviewStars = placeReviewStars;
        photo = placePhoto;
        twitterURI = placeTwitterURI;
        hours = placeHours;
    }

    public String getPlaceName() {
        return name;
    }
    public String getplaceAddress() { return address; }
    public String getAddressURI() { return addressURI; }
    public String getPhone() { return phone; }
    public String getWebsiteURI() { return websiteURI; }
    public String getReviewStars() { return reviewStars; }
    public int getPhoto() { return photo; }
    public String getTwitterURI() { return twitterURI; }
    public String getHours() { return hours; }

}
