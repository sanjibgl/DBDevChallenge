/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restdemo.restcontroller;

import static com.restdemo.applicationconstants.ApplicationConstants.FAIL;
import static com.restdemo.applicationconstants.ApplicationConstants.SUCCESS;
import com.restdemo.persistense.PersistShopList;
import com.restdemo.valueobject.Location;
import com.restdemo.valueobject.ShopAddress;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Sanjib
 */
public class RestControllerTest {

    public RestControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addShopAddresses method, of class RestController.
     */
    @Test
    public void testAddShopAddresses_1() {
        List<ShopAddress> addressList = new ArrayList();
        ShopAddress shopAddress = new ShopAddress();
        shopAddress.setShopName("More");
        shopAddress.setShopAddress("Sahakar Nagar, Bangalore");
        shopAddress.setShopAddressPostCode("560092");
        shopAddress.setShopAddressNumber("111");
        addressList.add(shopAddress);

        ShopAddress shopAddress1 = new ShopAddress();
        shopAddress.setShopName("More");
        shopAddress.setShopAddress("Golf Green, Kolkata");
        shopAddress.setShopAddressPostCode("700097");
        shopAddress.setShopAddressNumber("166");
        addressList.add(shopAddress1);

        RestController instance = new RestController();
        ResponseEntity<List> expResult = new ResponseEntity<>(addressList, HttpStatus.OK);
        ResponseEntity<List> result = instance.addShopAddresses(addressList);
        assertEquals(expResult, result);

    }

    @Test
    public void testAddShopAddresses_2() {
        List<ShopAddress> addressList = new ArrayList();
        ShopAddress shopAddress = new ShopAddress();
        shopAddress.setShopName("More");
        shopAddress.setShopAddress("Sahakar Nagar, Bangalore");
        shopAddress.setShopAddressPostCode("560092");
        shopAddress.setShopAddressNumber("111");
        addressList.add(shopAddress);

        ShopAddress shopAddress1 = new ShopAddress();
        shopAddress.setShopName("");
        shopAddress.setShopAddress("");
        shopAddress.setShopAddressPostCode("");
        shopAddress.setShopAddressNumber("");
        addressList.add(shopAddress1);

        RestController instance = new RestController();
        ResponseEntity<List> expResult = new ResponseEntity<>(addressList, HttpStatus.OK);
        ResponseEntity<List> result = instance.addShopAddresses(addressList);
        assertEquals(expResult, result);

    }

    /**
     * Test of findNearestShop method, of class RestController.
     */
    @Test
    public void testFindNearestShop_0() {
        PersistShopList.getInstance().persist(null);
        List<ShopAddress> addressList = new ArrayList();
        ShopAddress shopAddress = new ShopAddress();
        shopAddress.setShopName("More");
        shopAddress.setShopAddress("Sahakar Nagar, Bangalore");
        shopAddress.setShopAddressPostCode("560092");
        shopAddress.setShopAddressNumber("111");
        addressList.add(shopAddress);

        ShopAddress shopAddress1 = new ShopAddress();
        shopAddress1.setShopName("");
        shopAddress1.setShopAddress("");
        shopAddress1.setShopAddressPostCode("");
        shopAddress1.setShopAddressNumber("");
        addressList.add(shopAddress1);

        RestController instance = new RestController();
        instance.addShopAddresses(addressList);

        String lat = "13.06";
        String lng = "78.58";
        Location result = instance.findNearestShop(lat, lng);
        assertNotEquals(result.getLat(), 0, 0.5);
        assertNotEquals(result.getLng(), 0, 0.5);
        assertEquals(result.getAddressLookup(), SUCCESS);
        assertNotEquals(result.getDistance(), 0, 0.5);
        System.out.println("latitude " +result.getLat());
        System.out.println("longitude " +result.getLng());
        System.out.println("address " +result.getAddress());
        System.out.println("distance " +result.getDistance());
        System.out.println("look up " +result.getAddressLookup());
         
    }

    /**
     * Test of findNearestShop method, of class RestController.
     */
    @Test
    public void testFindNearestShop_1() {
        PersistShopList.getInstance().persist(null);
        RestController instance = new RestController();
        String lat = "13";
        String lng = "20";
        Location result = instance.findNearestShop(lat, lng);
        assertEquals(result.getLat(), 0, 0.5);
        assertEquals(result.getLng(), 0, 0.5);
        assertEquals(result.getAddressLookup(), FAIL);

    }

}
