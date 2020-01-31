package com.acmvit.androidchallenge1.CustomClasses;

public class Place {
    private String mName;
    private String mAddress;
    private String mDescription;
    private String mImageUrl;
    private String mDirectionUri;
    public Place(String name, String Address, String imageUrl, String description, String directionUri) {
        mName = name;
        mAddress = Address;
        mDescription = description;
        mImageUrl = imageUrl;
        mDirectionUri = directionUri;
    }
    public String getmName() {
        return mName;
    }
    public String getmAddress() {
        return mAddress;
    }
    public String getmImageUrl() {
        return mImageUrl;
    }
    public String getmDescription() {
        return mDescription;
    }
    public String getmDirectionUri() {
        return mDirectionUri;
    }
}
