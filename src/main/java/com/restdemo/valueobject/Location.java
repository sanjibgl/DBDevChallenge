/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restdemo.valueobject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Sanjib
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    private double lat;
    private double lng;
    private String address;
    private String distance;
    private String addressLookup;
    

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLat() {
        return lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLng() {
        return lng;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the distance
     */
    public String getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
   public void setDistance(String distance) {
        this.distance = distance;
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