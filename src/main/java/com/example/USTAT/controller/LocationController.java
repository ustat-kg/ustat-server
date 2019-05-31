package com.example.USTAT.controller;

import com.example.USTAT.model.Location;
import com.example.USTAT.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(LocationController.URL_LOCATION)
public class LocationController {

    public static final String URL_LOCATION = "/ustat/";

    @Autowired
    private LocationService locationService;

    @GetMapping(path = "/getLocation/{id}" ,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Location getLocationById(@PathVariable Long id){
        return this.locationService.getLocationById(id);
    }

    @GetMapping(path = "/getAllLocations",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Location> getAllLocations(){
        return this.locationService.getAllLocations();
    }

    @PostMapping(path = "/addLocation" ,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Location addLocation(@RequestBody Location location){
        return this.locationService.addLocation(location);
    }


    @DeleteMapping(path = "/admin/deleteLocation/{id}" ,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteLocationById(@PathVariable Long id){
        this.locationService.deleteLocationById(id);
    }
}
