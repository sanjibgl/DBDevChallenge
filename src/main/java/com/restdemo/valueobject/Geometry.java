/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restdemo.valueobject;

/**
 *
 * @author Sanjib
 */
public class Geometry {
    private Location location;
    private String locationType;
    private Area viewport;
    private Area bounds;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public Area getViewport() {
        return viewport;
    }

    public void setViewport(Area viewport) {
        this.viewport = viewport;
    }

    public Area getBounds() {
        return bounds;
    }

    public void setBounds(Area bounds) {
        this.bounds = bounds;
    }
}
