package com.example.USTAT.repository;

import com.example.USTAT.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository
        extends JpaRepository<Location , Long> {
}
