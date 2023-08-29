package com.spring.weatherapi.controller;

import com.spring.weatherapi.payload.ResponsePayload;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController 
@RequestMapping("/weather/")
public class WeatherAPIController {
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "get/current/{location}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponsePayload getWeather(@PathVariable String location){
        ResponsePayload payload = new ResponsePayload();
        try{
            String uri = "http://api.weatherapi.com/v1/current.json?key=0228cd53a03540e5be2132840232808&q="+location;
            RestTemplate rt = new RestTemplate();
            String result = rt.getForObject(uri, String.class); 
            payload.setData(result);
            payload.setMessage("OK");
            payload.setStatus(200);
        }catch(RestClientException e){
        }
        return payload;
    }
}
