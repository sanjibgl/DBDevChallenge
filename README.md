# DBDevChallenge
## Author : Sanjib Ghoshal
## Note : 
          The shop finder micro service is currently designed to cater to single "Retail Manager" for posting the shop list.
          There is no authentication implemented.

## Build : 
          1. Open the command prompt in windows machine
          2. Through command prompt go to the folder where downloded codebase of the project is stored,
             To make sure you are in the right folder check if the files named "README" and "gradle" are present there. 
          3. run the following command :   gradlew build
             Make sure the JAVA_HOME variable is set properly in the build machine. 
             Application requires Java version 1.8 .
          
## Deployment : 
          4. Once the build is completed successfully 
          5. Run the following command to start the application :  java -jar build/libs/demo-0.0.1-SNAPSHOT.war
          
## Testing :
          6. After successful start up,  the application runs on the port 9000.
             (Note: If it is required to run the application in other port, go to the folder -> 
             <codebase folder>/src/main/resources
             Open the file application.properties file, change the server port and save before doing the build.)
             
          7. Use Chrome Postman or similar client tool
          
          8. As a "Retail Manager" user can make a POST request to create the shop address list to this url: 
              <server ip>:9000/v1/addShops
             (In place of <server ip> put "localhost" if you are running the application in local machine)
             
             Each post request will replace the earlier stored list and create a new shop address list.
             
             Sample Jason request structure is provided below
             
                 [{
                    "shopName": "More Superstore",
                    "shopAddress": "Sahakar Nagar, Bangalore",
                    "shopAddressNumber": "110",
                    "shopAddressPostCode": "560092"
                  },
                  {
                    "shopName": "More",
                    "shopAddress": "Golf Green, Kolkata",
                    "shopAddressNumber": "209",
                    "shopAddressPostCode": "700095"
                  },
                  {
                    "shopName": "More Retail",
                    "shopAddress": "Chembur, Mumbai",
                    "shopAddressNumber": "389",
                    "shopAddressPostCode": ""
                    }]
                    
           9. There will be a json response in the following format .
              "latitude" and "longitude" fields will be populated for the shop address if the adddress was 
              found in google maps, and the  "addressLookup: field value will show as "Success".
              If the address was not found, "addressLookup: field value will show as "Failed" and "latitude" 
              and "longitude" field values will be "0".
              
                  [
                      {
                        "shopName": "More Superstore",
                        "shopAddress": "Sahakar Nagar, Bangalore",
                        "shopAddressNumber": "110",
                        "shopAddressPostCode": "560092",
                        "latitude": 13.0623425,
                        "longitude": 77.5871032,
                        "addressLookup": "Success",
                        "address": "Sahakar Nagar, Bangalore , 560092"
                      },
                      {
                        "shopName": "More",
                        "shopAddress": "Golf Green, Kolkata",
                        "shopAddressNumber": "209",
                        "shopAddressPostCode": "700095",
                        "latitude": 22.4931376,
                        "longitude": 88.3621781,
                        "addressLookup": "Success",
                        "address": "Golf Green, Kolkata , 700095"
                      },
                      {
                        "shopName": "More Retail",
                        "shopAddress": "Chembur, Mumbai",
                        "shopAddressNumber": "389",
                        "shopAddressPostCode": "",
                        "latitude": 19.0327996,
                        "longitude": 72.89635679999999,
                        "addressLookup": "Success",
                        "address": "Chembur, Mumbai , "
                      }
                    ]
             
             
          10. As a "Customer" user can make a GET request to the microservice through this below url 
          passing the latitude and longitude of  geolocation throgh url.
                    <server ip>:9000/v1/findNearestShop?lat=23&lng=77
          
          The json response to the request will be like below if there was no shop found.  
          The "addressLookup" field will show "Failed".
          
          {
            "lat": 0,
            "lng": 0,
            "address": null,
            "distance": null,
            "addressLookup": "Failed"
          }
          
          The json response to the request will be like below if there was a shop found. "addressLookup" field will show "Success". Here "lat" and "lng" fields are showing latitude and longitude of the nearest shop.
          The "address" filed is showing the address for the nearest shop.
          
          {
            "lat": 23,
            "lng": 77,
            "address": "More,209,Golf Green, Kolkata,700095",
            "distance": "1448 KM",
            "addressLookup": "Success"
          }
