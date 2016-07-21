/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restdemo.restcontroller;

/**
 *
 * @author Sanjib
 */
import com.restdemo.valueobject.Location;
import com.restdemo.valueobject.ShopAddress;
import com.restdemo.persistense.PersistShopList;
import com.restdemo.resthelper.AddressDecoder;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;

        
@org.springframework.web.bind.annotation.RestController

public class RestController {    
   
    @RequestMapping(value="/v1/addShops", method = {RequestMethod.POST }, produces = "application/json", consumes = "application/json")
    public ResponseEntity <List> addShopAddresses(@RequestBody List<ShopAddress> shopList) {
        PersistShopList persisShopList = PersistShopList.getInstance();       
        AddressDecoder decoder = new AddressDecoder();
        decoder.decodeAddress(shopList);
        persisShopList.persist(shopList); 
        return new ResponseEntity(persisShopList.get(), HttpStatus.OK);

    }

    @RequestMapping(value= "/v1/findNearestShop",method = {RequestMethod.GET })
    public Location findShop(@RequestParam String lat, String lng) {
        List shopList = PersistShopList.getInstance().get();              
        AddressDecoder decoder = new AddressDecoder();
        Location loc = new Location();
        loc.setLat(Double.parseDouble(lat));
        loc.setLng(Double.parseDouble(lng));
        decoder.findNearestAddress(shopList,loc);
        return loc;
    }
    
}
