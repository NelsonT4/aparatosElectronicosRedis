package com.uptc.frw.aparatoselectronicos.service;

import com.uptc.frw.aparatoselectronicos.JPA.entity.Manufacturers;
import com.uptc.frw.aparatoselectronicos.JPA.repository.ManufacturersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturersServices {
    @Autowired
    private ManufacturersRepository manufacturersRepository;

    public Manufacturers getManufacturer(Long id){
        return manufacturersRepository.findById(id).get();
    }

    public List<Manufacturers> getAllManufacturers(){
        return  manufacturersRepository.findAll();
    }

    public Manufacturers saveManufacturer(Manufacturers manufacturers){
        return manufacturersRepository.save(manufacturers);
    }

    public void delManufacturer(Long id){
        manufacturersRepository.deleteById(id);
    }

    public Manufacturers updateManufacturer(Manufacturers pmanufacturer){
        //Manufacturers manufacturers = getManufacturer(pmanufacturer.getRif());
        //manufacturers.setFicalDomicile(pmanufacturer.getFicalDomicile());
        return manufacturersRepository.save(pmanufacturer);
    }

}
