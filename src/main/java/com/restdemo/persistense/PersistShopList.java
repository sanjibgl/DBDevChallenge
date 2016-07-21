/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restdemo.persistense;

import com.restdemo.valueobject.ShopAddress;
import java.util.List;

/**
 *
 * @author Sanjib This class persists the shop list posted by the store manager
 * This is a singleton class, this class is mimicking the persistence layer of
 * the application
 */
public class PersistShopList {

    List<ShopAddress> shopList;
    private static PersistShopList instance;

    private PersistShopList() {
    }

    public static PersistShopList getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new PersistShopList();
            return instance;
        }
    }

    public void persist(List<ShopAddress> shopList) {
        this.shopList = shopList;
    }

    public List<ShopAddress> get() {
        return this.shopList;
    }
}
