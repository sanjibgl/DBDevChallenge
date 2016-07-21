/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demorest.testRestHelper;

import com.restdemo.applicationconstants.ApplicationConstants;
import static com.restdemo.applicationconstants.ApplicationConstants.FAIL;
import static com.restdemo.applicationconstants.ApplicationConstants.SUCCESS;
import com.restdemo.resthelper.AddressDecoder;
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

/**
 *
 * @author Sanjib
 */
public class RestHelperJunitTest {

    AddressDecoder addressDecoder;

    public RestHelperJunitTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.addressDecoder = new AddressDecoder();

    }

    @After
    public void tearDown() {
        this.addressDecoder = null;
    }

    @Test
    public void testDecodeAddressWithValidAddress_0() {
        ShopAddress shopAddress = new ShopAddress();
        List<ShopAddress> addressList = new ArrayList();
        shopAddress.setShopName("More");
        shopAddress.setShopAddress("Sahakar Nagar, Bangalore");
        shopAddress.setShopAddressPostCode("560092");
        shopAddress.setShopAddressNumber("111");
        addressList.add(shopAddress);
        this.addressDecoder.decodeAddress(addressList);
        assertNotEquals(shopAddress.getLatitude(), 0);
        assertNotEquals(shopAddress.getLongitude(), 0);
        assertEquals(shopAddress.getAddressLookup(), ApplicationConstants.SUCCESS);

    }

    @Test
    public void testDecodeAddressWithValidAddress_1() {
        ShopAddress shopAddress = new ShopAddress();
        List<ShopAddress> addressList = new ArrayList();
        shopAddress.setShopName("More");
        shopAddress.setShopAddress("Bangalore");
        shopAddress.setShopAddressPostCode("");
        shopAddress.setShopAddressNumber("");
        addressList.add(shopAddress);
        this.addressDecoder.decodeAddress(addressList);
        assertNotEquals(shopAddress.getLatitude(), 0);
        assertNotEquals(shopAddress.getLongitude(), 0);
        assertEquals(ApplicationConstants.SUCCESS, shopAddress.getAddressLookup());
    }

    @Test
    public void testDecodeAddressWithValidAddress_2() {
        ShopAddress shopAddress = new ShopAddress();
        List<ShopAddress> addressList = new ArrayList();
        shopAddress.setShopName("");
        shopAddress.setShopAddress("Bangalore");
        shopAddress.setShopAddressPostCode("560092");
        shopAddress.setShopAddressNumber("");
        addressList.add(shopAddress);
        this.addressDecoder.decodeAddress(addressList);
        assertNotEquals(shopAddress.getLatitude(), 0);
        assertNotEquals(shopAddress.getLongitude(), 0);
        assertEquals(ApplicationConstants.SUCCESS, shopAddress.getAddressLookup());
    }

    @Test
    public void testDecodeAddressWithValidAddress_3() {
        ShopAddress shopAddress = new ShopAddress();
        List<ShopAddress> addressList = new ArrayList();
        shopAddress.setShopName("");
        shopAddress.setShopAddress("Bangalore");
        shopAddress.setShopAddressPostCode("560067");
        shopAddress.setShopAddressNumber("999");
        addressList.add(shopAddress);
        this.addressDecoder.decodeAddress(addressList);
        assertNotEquals(shopAddress.getLatitude(), 0);
        assertNotEquals(shopAddress.getLongitude(), 0);
        assertEquals(ApplicationConstants.SUCCESS, shopAddress.getAddressLookup());
    }

    @Test
    public void testDecodeAddressWithValidAddress_4() {
        ShopAddress shopAddress = new ShopAddress();
        List<ShopAddress> addressList = new ArrayList();
        shopAddress.setShopName("The Park");
        shopAddress.setShopAddress("Marine Drive, Mumbai");
        shopAddress.setShopAddressPostCode("");
        shopAddress.setShopAddressNumber("999");
        addressList.add(shopAddress);
        addressDecoder.decodeAddress(addressList);
        assertNotEquals(shopAddress.getLatitude(), 0);
        assertNotEquals(shopAddress.getLongitude(), 0);
        assertEquals(ApplicationConstants.SUCCESS, shopAddress.getAddressLookup());
    }

    @Test
    public void testDecodeAddressWithValidAddress_5() {
        ShopAddress shopAddress = new ShopAddress();
        List<ShopAddress> addressList = new ArrayList();
        shopAddress.setShopName("Hola");
        shopAddress.setShopAddress("Montevideo, Uruguay");
        shopAddress.setShopAddressPostCode("");
        shopAddress.setShopAddressNumber("111");
        addressList.add(shopAddress);
        this.addressDecoder.decodeAddress(addressList);
        assertEquals(ApplicationConstants.SUCCESS, shopAddress.getAddressLookup());
        assertNotEquals(shopAddress.getLatitude(), 0);
        assertNotEquals(shopAddress.getLongitude(), 0);
    }

    @Test
    public void testDecodeAddressWithInvalidAddress_1() {
        ShopAddress shopAddress = new ShopAddress();
        List<ShopAddress> addressList = new ArrayList();
        shopAddress.setShopName("");
        shopAddress.setShopAddress("");
        shopAddress.setShopAddressPostCode("");
        shopAddress.setShopAddressNumber("");
        addressList.add(shopAddress);
        this.addressDecoder.decodeAddress(addressList);
        assertEquals(ApplicationConstants.FAIL, shopAddress.getAddressLookup());
        assertEquals(0, shopAddress.getLatitude(), 0.5);
        assertEquals(0, shopAddress.getLongitude(), 0.5);
    }

    @Test
    public void testDecodeAddressWithInvalidAddress_2() {
        ShopAddress shopAddress = new ShopAddress();
        List<ShopAddress> addressList = new ArrayList();
        shopAddress.setShopName("More");
        shopAddress.setShopAddress("");
        shopAddress.setShopAddressPostCode("568880097");
        shopAddress.setShopAddressNumber("");
        addressList.add(shopAddress);
        this.addressDecoder.decodeAddress(addressList);
        assertEquals(ApplicationConstants.FAIL, shopAddress.getAddressLookup());
        assertEquals(0, shopAddress.getLatitude(), 0.5);
        assertEquals(0, shopAddress.getLongitude(), 0.5);
    }

    @Test
    public void testDecodeAddressWithInvalidAddress_3() {
        ShopAddress shopAddress = new ShopAddress();
        List<ShopAddress> addressList = new ArrayList();
        shopAddress.setShopName("More");
        shopAddress.setShopAddress("");
        shopAddress.setShopAddressPostCode("888560097");
        shopAddress.setShopAddressNumber("111");
        addressList.add(shopAddress);
        this.addressDecoder.decodeAddress(addressList);
        assertEquals(ApplicationConstants.FAIL, shopAddress.getAddressLookup());
        assertEquals(0, shopAddress.getLatitude(), 0.5);
        assertEquals(0, shopAddress.getLongitude(), 0.5);
    }

   
    @Test
    public void testFindNearestAddress_0() {
        ShopAddress shopAddress = new ShopAddress();
        ShopAddress shopAddress1 = new ShopAddress();
        List<ShopAddress> addressList = new ArrayList();
        addressList.add(shopAddress);

        Location loc = new Location();
        loc.setLat(-36.06766);
        loc.setLat(-77.56766);
        shopAddress.setLatitude(-36.068786);
        shopAddress.setLongitude(-77.87676);
        shopAddress.setAddressLookup(SUCCESS);
        addressList.add(shopAddress);

        shopAddress1.setLatitude(-35.068786);
        shopAddress1.setLongitude(-78.07676);
        shopAddress1.setAddressLookup(SUCCESS);
        addressList.add(shopAddress1);

        this.addressDecoder.findNearestAddress(addressList, loc);
        assertEquals(ApplicationConstants.SUCCESS, loc.getAddressLookup());
        assertNotEquals(loc.getLat(), 0);
        assertNotEquals(loc.getLng(), 0);
    }

    @Test
    public void testFindNearestAddress_1() {
        ShopAddress shopAddress = new ShopAddress();
        ShopAddress shopAddress1 = new ShopAddress();
        List<ShopAddress> addressList = new ArrayList();
        addressList.add(shopAddress);

        Location loc = new Location();
        loc.setLat(-36.06766);
        loc.setLat(-77.56766);
        shopAddress.setLatitude(0);
        shopAddress.setLongitude(0);
        shopAddress.setAddressLookup(FAIL);
        addressList.add(shopAddress);

        shopAddress1.setLatitude(-35.068786);
        shopAddress1.setLongitude(-78.07676);
        shopAddress1.setAddressLookup(SUCCESS);
        addressList.add(shopAddress1);

        this.addressDecoder.findNearestAddress(addressList, loc);
        assertEquals(ApplicationConstants.SUCCESS, loc.getAddressLookup());
        assertNotEquals(loc.getLat(), 0);
        assertNotEquals(loc.getLng(), 0);
    }

    @Test
    public void testFindNearestAddress_2() {
        ShopAddress shopAddress = new ShopAddress();
        ShopAddress shopAddress1 = new ShopAddress();
        List<ShopAddress> addressList = new ArrayList();
        addressList.add(shopAddress);

        Location loc = new Location();
        loc.setLat(36.06766);
        loc.setLat(77.56766);
        shopAddress.setLatitude(34);
        shopAddress.setLongitude(79);
        shopAddress.setAddressLookup(SUCCESS);
        addressList.add(shopAddress);

        shopAddress1.setLatitude(35.068786);
        shopAddress1.setLongitude(78.07676);
        shopAddress1.setAddressLookup(SUCCESS);
        addressList.add(shopAddress1);

        this.addressDecoder.findNearestAddress(addressList, loc);
        assertEquals(ApplicationConstants.SUCCESS, loc.getAddressLookup());
        assertNotEquals(loc.getLat(), 0);
        assertNotEquals(loc.getLng(), 0);
    }

    @Test
    public void testFindNearestAddress_3() {
        ShopAddress shopAddress = new ShopAddress();
        ShopAddress shopAddress1 = new ShopAddress();
        List<ShopAddress> addressList = new ArrayList();
        addressList.add(shopAddress);

        Location loc = new Location();
        loc.setLat(36.06766);
        loc.setLat(77.56766);

        shopAddress.setAddressLookup(FAIL);
        addressList.add(shopAddress);
        shopAddress1.setAddressLookup(FAIL);
        addressList.add(shopAddress1);
        this.addressDecoder.findNearestAddress(addressList, loc);
        assertEquals(ApplicationConstants.FAIL, loc.getAddressLookup());
        assertEquals(0, loc.getLat(), 0.5);
        assertEquals(0, loc.getLng(), 0.5);
    }

    @Test
    public void testFindNearestAddress_4() {
        ShopAddress shopAddress = new ShopAddress();
        ShopAddress shopAddress1 = new ShopAddress();
        List<ShopAddress> addressList = new ArrayList();
        addressList.add(shopAddress);

        Location loc = new Location();
        loc.setLat(36.06766);
        loc.setLat(77.56766);

        shopAddress.setAddressLookup(SUCCESS);
        shopAddress.setLatitude(13.06785);
        shopAddress.setLongitude(77.82628);

        addressList.add(shopAddress);
        shopAddress1.setAddressLookup(FAIL);
        addressList.add(shopAddress1);
        this.addressDecoder.findNearestAddress(addressList, loc);
        assertEquals(ApplicationConstants.SUCCESS, loc.getAddressLookup());
        assertNotEquals(loc.getLat(), 0);
        assertNotEquals(loc.getLng(), 0);
    }
    
    @Test
    public void testFindNearestAddress_5() {
        
        Location loc = new Location();
        loc.setLat(36.06766);
        loc.setLat(77.56766);
        List<ShopAddress> addressList = new ArrayList();
        this.addressDecoder.findNearestAddress(addressList, loc);
        assertEquals(ApplicationConstants.FAIL, loc.getAddressLookup());
        assertEquals(0, loc.getLat(), 0.5);
        assertEquals(0, loc.getLng(), 0.5);
    }
    @Test
    public void testFindNearestAddress_6() {
        
        Location loc = new Location();
        loc.setLat(36.06766);
        loc.setLat(77.56766);
        List<ShopAddress> addressList = null;
        this.addressDecoder.findNearestAddress(addressList, loc);
        assertEquals(ApplicationConstants.FAIL, loc.getAddressLookup());
        assertEquals(0, loc.getLat(), 0.5);
        assertEquals(0, loc.getLng(), 0.5);
    }
}
