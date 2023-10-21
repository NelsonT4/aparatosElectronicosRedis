package com.uptc.frw.aparatoselectronicos.controller;


import com.uptc.frw.aparatoselectronicos.JPA.entity.Manufacturers;
import com.uptc.frw.aparatoselectronicos.service.ManufacturersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manufacturer")
public class ManufacturersController {

    @Autowired
    private ManufacturersServices manufacturersServices;


    @GetMapping
    public List<Manufacturers> getManufacturers(){
        return manufacturersServices.getAllManufacturers();
    }

    @PostMapping
    public Manufacturers saveManufacturer(@RequestBody Manufacturers manufacturers){
        return manufacturersServices.saveManufacturer(manufacturers);
    }

    @GetMapping("/{id}")
    public Manufacturers getManufacturer(@RequestParam Long id){
        return manufacturersServices.getManufacturer(id);
    }

    @PutMapping
    public Manufacturers updateManufacturer(@RequestBody Manufacturers manufacturers){
        return manufacturersServices.saveManufacturer(manufacturers);
    }

    @DeleteMapping
    public void delManufacturer(@RequestParam Long id){
       manufacturersServices.delManufacturer(id);
    }
}
