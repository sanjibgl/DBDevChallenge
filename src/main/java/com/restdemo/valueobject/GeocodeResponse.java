/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restdemo.valueobject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sanjib
 */
public class GeocodeResponse {
    private String status;
    private List<Geocode> results = new ArrayList<>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setResults(List<Geocode> results) {
        this.results = results;
    }

    public List<Geocode> getResults() {
        return results;
    }
}
