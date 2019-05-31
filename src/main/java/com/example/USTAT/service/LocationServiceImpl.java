package com.example.USTAT.service;

import com.example.USTAT.model.Location;
import com.example.USTAT.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl  implements LocationService{

    @Autowired
    private LocationRepository locationRepository;


    @Override
    public Location getLocationById(Long id) {
        return this.locationRepository.findById(id).get();
    }

    @Override
    public List<Location> getAllLocations() {
        return this.locationRepository.findAll();
    }

    @Override
    public Location addLocation(Location location) {
        return this.locationRepository.save(location);
    }

    @Override
    public void deleteLocationById(Long id) {
        this.locationRepository.deleteById(id);
    }

    @Override
    public void deleteAllLocations() {
        this.locationRepository.deleteAll();
    }
}
