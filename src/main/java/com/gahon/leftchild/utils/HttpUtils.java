package com.gahon.leftchild.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gahon.leftchild.model.LatLng;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class HttpUtils {

    public static LatLng getlnglat(String address, String city) {
        RestTemplate restTemplate = new RestTemplate();
        LatLng latLng = null;
        String url = "http://api.map.baidu.com/geocoder/v2/?address="
                + address
                + "&city="
                + city
                + "&output=json&ak=7r4z0jRBjmWAsODDBhtwsEy5DubCHOHF";
        /* 注意：必须 http、https……开头，不然报错，浏览器地址栏不加 http 之类不出错是因为浏览器自动帮你补全了 */

//        ResponseEntity<LatLng> responseEntity = restTemplate.getForEntity(url,LatLng.class);
        /* body是Http消息体例如json串 */
//        LatLng latLng = responseEntity.getBody();
        String str = restTemplate.getForObject(url, String.class);
        System.out.println(str);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            latLng = objectMapper.readValue(str, LatLng.class);
            System.out.println(latLng);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return latLng;
    }
}
