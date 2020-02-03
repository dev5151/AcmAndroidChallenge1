package com.acmvit.androidchallenge1.Models;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public ArrayList<Item> list;
    private static Utils utils = null;

    private Utils(){
        list = new ArrayList<>();
    }
    public static Utils getArrayobj(){
        if(utils==null){
            utils = new Utils();
        }
        return utils;
    }
}
