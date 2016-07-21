/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demorest.testpersistence;

import static com.restdemo.applicationconstants.ApplicationConstants.FAIL;
import static com.restdemo.applicationconstants.ApplicationConstants.SUCCESS;
import com.restdemo.persistense.PersistShopList;
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
public class PersistShopListJUnitTest {

    public PersistShopListJUnitTest() {
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

    @Test
    public void testGetInstance() {
        PersistShopList persistShopList = PersistShopList.getInstance();
        assertNotNull(persistShopList);
    }

    @Test
    public void testPersist() {
        PersistShopList persistShopList = PersistShopList.getInstance();
        ShopAddress shopAddress = new ShopAddress();
        ShopAddress shopAddress1 = new ShopAddress();
        List<ShopAddress> addressList = new ArrayList();
        shopAddress.setAddressLookup(SUCCESS);
        shopAddress.setLatitude(13.06785);
        shopAddress.setLongitude(77.82628);

        shopAddress1.setAddressLookup(FAIL);
        shopAddress1.setLatitude(0);
        shopAddress1.setLongitude(0);
        addressList.add(shopAddress);
        addressList.add(shopAddress1);
        persistShopList.persist(addressList);
        List<ShopAddress> addressList1 = persistShopList.get();

        assertNotNull(addressList1);
        assertEquals(2, addressList1.size());
    }
}
