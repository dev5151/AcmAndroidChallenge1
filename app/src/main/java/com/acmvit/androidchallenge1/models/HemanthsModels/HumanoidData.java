package com.acmvit.androidchallenge1.models.HemanthsModels;


public class HumanoidData {
    String name;
    String released;
    String imgLinko;

    public HumanoidData(){}
    public HumanoidData(String name, String released, String imgLinko) {
        this.name = name;
        this.released = released;
        this.imgLinko = imgLinko;
    }

    public String getName(){
        return name;
    }

    public String getReleased(){
        return getReleased();
    }

    public String getImgLinko(){
        return getImgLinko();
    }

    public void setName(String name){
        this.name = name;
    }
    public void setReleased(String released){
        this.released = released;
    }
    public void setImgLinko(String imgLinko){
        this.name = imgLinko;
    }

    public void initData(){
        //TODO

    }
}

