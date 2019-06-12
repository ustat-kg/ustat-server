package com.example.USTAT.controller;

import com.example.USTAT.model.Location;
import com.example.USTAT.model.Response;
import com.example.USTAT.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping(LocationController.URL_LOCATION)
public class LocationController {

    public static final String URL_LOCATION = "/ustat/";

    @Autowired
    private LocationService locationService;

    @GetMapping(path = "/getLocation/{id}" ,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response getLocationById(@PathVariable Long id){
        return new Response(true,"Getting location by id",this.locationService.getLocationById(id));
    }

    @GetMapping(path = "/getAllLocations",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response getAllLocations(){
        return new Response(true,"Getting all locations" ,this.locationService.getAllLocations());
    }

    @PostMapping(path = "/addLocation" ,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response addLocation(@RequestBody Location location){
        return new Response(true,"Adding location",this.locationService.addLocation(location)) ;
    }


    @DeleteMapping(path = "/admin/deleteLocation/{id}" ,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response deleteLocationById(@PathVariable Long id){
        this.locationService.deleteLocationById(id);
        return new Response(true,"Deleting location by id",null);
        }
}
