package com.example.USTAT.service;

import com.example.USTAT.model.Location;

import java.util.List;

public interface LocationService {
    Location  getLocationById(Long id);
    List<Location> getAllLocations();
    Location addLocation(Location location);
    void deleteLocationById(Long id);
    void deleteAllLocations();
}
