package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface WhiskyRepositoryCustom {

    List<Whisky> getWhiskiesWithYear(int year);

    List<Whisky> getWhiskiesFromADistilleryOfASpecificAge(Long id, int age);
}
