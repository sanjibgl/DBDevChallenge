/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restdemo.valueobject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Sanjib
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class Geocode {
    
    private Collection<String> types = new ArrayList<>();
    private String formatted_address;
    private Collection<AddressComponent> address_components = new ArrayList<>();
    private Geometry geometry;
    private boolean partialMatch;

    public Collection<String> getTypes() {
        return types;
    }

    public void setTypes(Collection<String> types) {
        this.types = types;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public void setAddress_components(Collection<AddressComponent> address_components) {
        this.address_components = address_components;
    }

    public Collection<AddressComponent> getAddress_components() {
        return address_components;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public boolean isPartialMatch() {
        return partialMatch;
    }

    public void setPartialMatch(boolean partialMatch) {
        this.partialMatch = partialMatch;
    }
}