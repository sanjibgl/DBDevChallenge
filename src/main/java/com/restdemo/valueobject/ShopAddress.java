/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restdemo.valueobject;

import com.restdemo.applicationconstants.ApplicationConstants;
import java.io.Serializable;

/**
 *
 * @author Sanjib
 */
public class ShopAddress implements Serializable {
    private String shopName;
    private String shopAddress;
    private String shopAddressNumber ;
    private String shopAddressPostCode ;
    private double latitude ;
    private double longitude ;
    private String addressLookup;    
    
    public String getShopName(){
        return this.shopName;
    }
    public void setShopName(String name){
        this.shopName = name;
    }
    public String getShopAddressNumber(){
        return this.shopAddressNumber;
    }
    public void setShopAddressNumber(String shopAddressNumber){
        this.shopAddressNumber = shopAddressNumber;
    }
    
    public String getShopAddressPostCode(){
        return this.shopAddressPostCode;
    }
    public void setShopAddressPostCode(String postcode){
        this.shopAddressPostCode = postcode;
    }
       
    public double getLatitude(){
        return this.latitude;
    }
    public void setLatitude(double latitude){
        this.latitude = latitude;
    }

    public double getLongitude(){
        return this.longitude;
    }
    public void setLongitude(double longitude){
        this.longitude = longitude;
    }    
    
    public String getShopAddress() {
        return shopAddress;
    }

    
    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }
    
    
    
    public String getAddress(){
        return this.shopAddress+" , "+this.shopAddressPostCode;
    }

    /**
     * @return the addressLookup
     */
    public String getAddressLookup() {
        return addressLookup;
    }

    /**
     * @param addressLookup the addressLookup to set
     */
    public void setAddressLookup(String addressLookup) {
        this.addressLookup = addressLookup;
    }

    
}

