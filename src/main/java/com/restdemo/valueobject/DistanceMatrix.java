/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restdemo.valueobject;

import java.util.List;

/**
 *
 * @author Sanjib
 */
public class DistanceMatrix
{
   private List<String> destination_address;
   private List<String> origin_addresses;
   private List<Rows> rows;
   private String status;


    /**
     * @return the rows
     */
    public List<Rows> getRows() {
        return rows;
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(List<Rows> rows) {
        this.rows = rows;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the destination_address
     */
    public List<String> getDestination_address() {
        return destination_address;
    }

    /**
     * @param destination_address the destination_address to set
     */
    public void setDestination_address(List<String> destination_address) {
        this.destination_address = destination_address;
    }

    /**
     * @return the origin_addresses
     */
    public List<String> getOrigin_addresses() {
        return origin_addresses;
    }

    /**
     * @param origin_addresses the origin_addresses to set
     */
    public void setOrigin_addresses(List<String> origin_addresses) {
        this.origin_addresses = origin_addresses;
    }
}
