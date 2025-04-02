package com.example.CampaignApplication.Controller;


import com.example.CampaignApplication.Entities.City;
import com.example.CampaignApplication.Service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<City> getCities() {
        return cityService.getAllCities();
    }
}
