package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long>, WhiskyRepositoryCustom {

    //list of whiskies by year
    List<Whisky> findByYear(int year);
    //list of whiskies from particular distillery of a specific age
    List<Whisky> findByDistilleryIdAndAge(Long id, int age);

    List<Whisky> findByDistilleryRegion(String region);
}
