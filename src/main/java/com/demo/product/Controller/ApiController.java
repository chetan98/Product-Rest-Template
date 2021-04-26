package com.demo.product.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import com.demo.product.Entity.RestModel;
import com.demo.product.Service.ApiService;

@RestController
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/data")
    public List<RestModel> getPostData(){
        return apiService.getData();
    }

    @GetMapping("/data/{id}")
    public RestModel getById(@PathVariable int id) {
        return apiService.getDataById(id);
    }

    @PostMapping("/add")
    public RestModel addProducts(@RequestBody RestModel data){
        return  apiService.addData(data);
    }
}
