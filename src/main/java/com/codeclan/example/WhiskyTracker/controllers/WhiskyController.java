package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;
    //Get all whiskies from particular year

    @GetMapping(value = "year/{year}")
    public List<Whisky> getWhiskiesByYear(@PathVariable int year){
        return whiskyRepository.findByYear(year);
    }

    @GetMapping(value = "distillery/{id}/age/{age}")
    public List<Whisky> getWhiskiesByDistilleryIdAndAge(@PathVariable Long id, @PathVariable int age){
        return whiskyRepository.findByDistilleryIdAndAge(id, age);
    }

    @GetMapping(value = "custom/year/{year}")
    public List<Whisky> getWhiskiesWithYear(@PathVariable int year){
        return whiskyRepository.getWhiskiesWithYear(year);
    }

    @GetMapping(value = "custom/distillery/{id}/age/{age}")
    public List<Whisky> getWhiskiesFromDistilleryIdAndAge(@PathVariable Long id, @PathVariable int age){
        return whiskyRepository.getWhiskiesFromADistilleryOfASpecificAge(id, age);
    }

    @GetMapping(value = "custom/region/{region}")
    public List<Whisky> getWhiskiesFromRegion(@PathVariable String region){
        return whiskyRepository.getWhiskiesFromParticularRegion(region);
    }

    @GetMapping(value = "region/{region}")
    public List<Whisky> getWhiskiesByRegion(@PathVariable String region){
        return whiskyRepository.findByDistilleryRegion(region);
    }



}
