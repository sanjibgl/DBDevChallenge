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
public class Rows
{
   private List<Elements> elements;

    /**
     * @return the elements
     */
    public List<Elements> getElements() {
        return elements;
    }

    /**
     * @param elements the elements to set
     */
    public void setElements(List<Elements> elements) {
        this.elements = elements;
    }

}