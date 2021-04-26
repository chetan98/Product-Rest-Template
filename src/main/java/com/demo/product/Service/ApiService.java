package com.demo.product.Service;

import  java.lang.String;
import java.net.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import java.io.PrintWriter;
import java.util.*;

import com.demo.product.Entity.RestModel;

@Service
public class ApiService {

    @Autowired
    private RestTemplate restTemplate;
    private static String url = "http://localhost:9000/product/";

   // PrintWriter writer = response.getWriter();

    public List<RestModel> getData(){
        ResponseEntity<List<RestModel>> response =
                restTemplate.exchange(url+"get/",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<RestModel>>() {
                        });

        List<RestModel> data = response.getBody();

        //assert data != null;
        //data.forEach(System.out::println);
        return data;
    }

    public RestModel addData(RestModel data) {
        String new_url =url+"add/";
       // writer.println(new_url);
        HttpEntity<RestModel> entity = new HttpEntity<>(data);
        return restTemplate.exchange(new_url,HttpMethod.POST,entity,RestModel.class).getBody();

    }

    // public  void getDataById(int id){
    //     String new_url = url+"getbyid/"+id;
    //      RestModel[] response = restTemplate.getForObject(new_url+id,RestModel[].class);
    //      return Arrays.asList(response);
    //    return  restTemplate.exchange(new_url,HttpMethod.GET,null,List.class).getBody();
        
    // }

    public RestModel getDataById(int id) {
        String new_url = url+"getbyid/"+id;
        ResponseEntity<String> responseEntity = restTemplate.exchange(new_url,
                HttpMethod.GET,
                null,
                String.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println("status code - " + statusCode);
        String user = responseEntity.getBody();
        System.out.println("response body - " + user);
        // HttpHeaders responseHeaders = responseEntity.getHeaders();
        // System.out.println("response Headers - " + responseHeaders);

        ResponseEntity<RestModel> responseUser = restTemplate.exchange(new_url ,
                HttpMethod.GET,
                null,
                RestModel.class);
        RestModel userBody = responseUser.getBody();
        System.out.println("user object - " + userBody);
        return userBody;
    }
}
