package com.acmvit.androidchallenge1.Activities;

public class RoadBike_niyantha {
    private String mbikeUrl;
    private String mtext;
    private String mdescription;
    private String mextraInfoUrl;
    public RoadBike_niyantha(String bikeUrl,String text,String description,String extraInfoUrl)
    {
        mbikeUrl=bikeUrl;
        mdescription=description;
        mtext=text;
        mextraInfoUrl=extraInfoUrl;
    }
    public String getMbikeUrl() {
        return mbikeUrl;
    }
    public String getMdescription() {
        return mdescription;
    }
    public String getMtext() {
        return mtext;
    }
    public String getMextraInfoUrl(){
        return mextraInfoUrl;
    }
}
