package com.uptc.frw.aparatoselectronicos.controller;

import com.uptc.frw.aparatoselectronicos.JPA.entity.Components;
import com.uptc.frw.aparatoselectronicos.JPA.entity.ComponentsDevices;
import com.uptc.frw.aparatoselectronicos.JPA.entity.Devices;
import com.uptc.frw.aparatoselectronicos.service.ComponentsDevicesServices;
import com.uptc.frw.aparatoselectronicos.service.ComponentsServices;
import com.uptc.frw.aparatoselectronicos.service.DevicesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/componentsDevice")
public class ComponentsDevicesController {
    @Autowired
    private ComponentsDevicesServices componentsDevicesServices;

    @Autowired
    private DevicesServices devicesServices;

    @Autowired
    private ComponentsServices componentsServices;

    @GetMapping
    public List<ComponentsDevices> getAllComponetsDevice(){
        return  componentsDevicesServices.getAllComponentsDevices();
    }

    @PostMapping
public  ComponentsDevices saveComponentsDevice(@RequestBody ComponentsDevices componentsDevices, @RequestParam Long componentsId, @RequestParam(required = true) Long deviceId){
            componentsDevices.setComponentsId(componentsId);
            componentsDevices.setDevicesId(deviceId);

            Devices device = devicesServices.getDeviceId(deviceId);
            componentsDevices.setDevices(device);

            Components component = componentsServices.getComponenteById(componentsId);
            componentsDevices.setComponents(component);

            //Agrega los componentes al aparato
            List<ComponentsDevices> componentsDevice = device.getComponentsDevices();
            componentsDevice.add(componentsDevices);
            device.setComponentsDevices(componentsDevice);

            return componentsDevicesServices.saveComponentsDevices(componentsDevices);
    }

    @GetMapping("/{id}")
    public ComponentsDevices getComponentsDevice(@PathVariable Long id){
        return  componentsDevicesServices.getComponentsDevices(id);
    }

}
