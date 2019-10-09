package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/distilleries")
public class DistilleryController {

    @Autowired
    DistilleryController distilleryController;

    @GetMapping(value = "/{region}")
    public List<Distillery> getDistilleriesByRegion(@PathVariable String region){
        return distilleryController.getDistilleriesByRegion(region);
    }

}
