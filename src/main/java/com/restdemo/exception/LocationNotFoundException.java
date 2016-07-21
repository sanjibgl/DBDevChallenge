/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restdemo.exception;

/**
 *
 * @author Sanjib
 */
public class LocationNotFoundException extends Exception {
   private String messsage;
   
  
   public LocationNotFoundException(String msg){
       this.messsage = msg;
   }
   
   @Override
   public String getMessage(){
       return this.messsage;
   }
   

}
