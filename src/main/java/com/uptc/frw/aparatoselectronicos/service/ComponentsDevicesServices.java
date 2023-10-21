package com.uptc.frw.aparatoselectronicos.service;

import com.uptc.frw.aparatoselectronicos.JPA.entity.ComponentsDevices;
import com.uptc.frw.aparatoselectronicos.JPA.repository.ComponentsDevicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentsDevicesServices {
    @Autowired
    private ComponentsDevicesRepository componentsDevicesRepository;

    public List<ComponentsDevices> getAllComponentsDevices(){
        return componentsDevicesRepository.findAll();
    }

    public ComponentsDevices getComponentsDevices(Long id){
        return componentsDevicesRepository.findById(id).get();
    }

    public ComponentsDevices saveComponentsDevices( ComponentsDevices componentsDevices){
        return  componentsDevicesRepository.save(componentsDevices);
    }

}
