package com.uptc.frw.aparatoselectronicos.service;

import com.uptc.frw.aparatoselectronicos.JPA.entity.Devices;
import com.uptc.frw.aparatoselectronicos.JPA.repository.DevicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevicesServices {
    @Autowired
    private DevicesRepository devicesRepository;

    @Cacheable(value = "Devices")
    public List<Devices> getAllDevices(){
        List<Devices> devices =  devicesRepository.findAll();
        return devices;
    }

    @Cacheable(value = "Devices",key = "#id")
    public Devices getDeviceId(Long id){
        return devicesRepository.findById(id).get();
    }

    public Devices saveDevice(Devices device){
        return devicesRepository.save(device);
    }

    @CacheEvict(value = "Devices",key = "#id")
    public void delDevice(Long id){
        devicesRepository.deleteById(id);
    }

    @CachePut(value = "Devices",key = "#id")
    public Devices updateDescriptionDevice(Long id, String newDescription){
        Devices device = getDeviceId(id);
        device.setDescription(newDescription);
        return devicesRepository.save(device);
    }
}
