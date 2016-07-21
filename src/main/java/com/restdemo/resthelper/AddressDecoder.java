/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restdemo.resthelper;

/**
 *
 * @author Sanjib
 */
import com.restdemo.applicationconstants.ApplicationConstants;
import static com.restdemo.applicationconstants.ApplicationConstants.COMMA;
import static com.restdemo.applicationconstants.ApplicationConstants.DESTINATION;
import static com.restdemo.applicationconstants.ApplicationConstants.FAIL;
import static com.restdemo.applicationconstants.ApplicationConstants.GOOGLE_DISTANCE_MATRIX_URI;
import static com.restdemo.applicationconstants.ApplicationConstants.SUCCESS;
import com.restdemo.valueobject.Distance;
import com.restdemo.valueobject.DistanceMatrix;
import com.restdemo.valueobject.Elements;
import com.restdemo.valueobject.Geocode;
import com.restdemo.valueobject.GeocodeResponse;
import com.restdemo.valueobject.Geometry;
import com.restdemo.valueobject.Location;
import com.restdemo.valueobject.Rows;
import com.restdemo.valueobject.ShopAddress;
import java.util.Iterator;
import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AddressDecoder {

      
    public List<ShopAddress> decodeAddress(List<ShopAddress> addressList ){
        RestTemplate restTemplate = new RestTemplate();
        
        for (ShopAddress shopAddress : addressList) {
            String url = ApplicationConstants.GOOGLE_MAPS_DECODER_URI+shopAddress.getAddress()+ApplicationConstants.KEY+ApplicationConstants.GOOGLE_KEY;
            GeocodeResponse geocode = restTemplate.getForObject(url, GeocodeResponse .class);
            if(ApplicationConstants.GEOCODE_STATUS_OK.equals(geocode.getStatus())) {
                
                double lat = ((Location)((Geometry)((Geocode)(((List)geocode.getResults()).get(0))).getGeometry()).getLocation()).getLat();
                double lon = ((Location)((Geometry)((Geocode)(((List)geocode.getResults()).get(0))).getGeometry()).getLocation()).getLng();
                shopAddress.setLatitude(lat);
                shopAddress.setLongitude(lon);
                shopAddress.setAddressLookup(ApplicationConstants.SUCCESS);
                }               
                    
            else{
                shopAddress.setAddressLookup(ApplicationConstants.FAIL);
            }
        }
         
        return addressList;
               
    }
   


    public void  findNearestAddress(List<ShopAddress> shopAddressList, Location loc){     
        
        if(checkForValidAddress(shopAddressList)){
            RestTemplate restTemplate = new RestTemplate();
            StringBuffer url = buildUrl(loc, shopAddressList);               
            DistanceMatrix distmat = restTemplate.getForObject(url.toString(), DistanceMatrix.class);
            String destination = null;
            int lowestIndex = 0;
            Long lowestDistance = new Long(0);

            if(ApplicationConstants.GEOCODE_STATUS_OK.equals(distmat.getStatus())) {

                Rows row = (Rows)((List)distmat.getRows()).get(0);
                List elements = row.getElements();
                Iterator itr = elements.iterator();

                int i = 0 ;
                while (itr.hasNext()){
                    Distance dist = ((Elements)itr.next()).getDistance();  
                    if(dist!=null){
                        Long currentDistance = new Long(dist.getValue());
                        if(i == 0 ){
                            lowestDistance = currentDistance;  

                        }
                        if(currentDistance < lowestDistance){
                            lowestDistance = currentDistance; 
                            lowestIndex=i;
                        } 
                    } else {
                        loc.setAddressLookup(FAIL);
                    }           
                    i=i+1;
                }         

            }            
            else{
               loc.setAddressLookup(FAIL);
            }
            ShopAddress nearestShop = (ShopAddress)shopAddressList.get(lowestIndex); 
            loc.setAddress(nearestShop.getShopName()+COMMA+nearestShop.getShopAddressNumber()+COMMA+nearestShop.getShopAddress()+COMMA+nearestShop.getShopAddressPostCode());
            lowestDistance = lowestDistance/1000;
            loc.setDistance(lowestDistance.toString()+" KM");
            loc.setAddressLookup(SUCCESS);
            loc.setLat(nearestShop.getLatitude());
            loc.setLng(nearestShop.getLongitude());
            }
        else{
               loc.setAddressLookup(FAIL);
            }
    }


    private boolean checkForValidAddress(List<ShopAddress> shopAddressList) {
        boolean flag = false;
        if(shopAddressList!=null){
            for(ShopAddress address:shopAddressList ){
                if(ApplicationConstants.SUCCESS.equals(address.getAddressLookup())){
                    flag=true;
                    break;
                }
            }
        }
        return flag;
    }

    private StringBuffer buildUrl(Location loc, List<ShopAddress> shopAddressList) {
        StringBuffer url = new StringBuffer();
        url.append(GOOGLE_DISTANCE_MATRIX_URI).append(loc.getLat()).append(COMMA).append(loc.getLng()).append(DESTINATION);
        shopAddressList.stream().forEach((ShopAddress shopAddress) -> {
            url.append(shopAddress.getLatitude()).append(COMMA).append(shopAddress.getLongitude()).append("||");
        });
        url.delete(url.lastIndexOf("|")-1, url.lastIndexOf("|"));
        url.append(ApplicationConstants.KEY).append(ApplicationConstants.GOOGLE_KEY);
        return url;
    }
}