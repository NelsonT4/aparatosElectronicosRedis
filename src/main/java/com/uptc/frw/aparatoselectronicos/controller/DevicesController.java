package com.uptc.frw.aparatoselectronicos.controller;

import com.uptc.frw.aparatoselectronicos.JPA.entity.*;
import com.uptc.frw.aparatoselectronicos.service.ComponentsServices;
import com.uptc.frw.aparatoselectronicos.service.DevicesServices;
import com.uptc.frw.aparatoselectronicos.service.RepairServices;
import com.uptc.frw.aparatoselectronicos.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/device")
public class DevicesController {

    @Autowired
    private DevicesServices devicesServices;

    @Autowired
    private RepairServices repairServices;

    @Autowired
    private TypesService typesService;

    @Autowired
    private ComponentsServices componentsServices;

    @GetMapping
    public List<Devices> getAllDevices(){
        List<Devices> devices = devicesServices.getAllDevices();

        return  devices;
    }

    @PostMapping()
    public Devices saveDevice( @RequestBody Devices device,@RequestParam Long idRepair,@RequestParam Long idType){

            Repairs repairs = repairServices.getRepair(idRepair);
            device.setRepairs(repairs);

            Types type = typesService.findType(idType);
            device.setTypes(type);
            return devicesServices.saveDevice(device);
    }

    @GetMapping("/search")
    public Devices getDevice( @RequestParam Long id){
            return  devicesServices.getDeviceId(id);
    }


    @PutMapping
    public Devices updateDescriptionDevice (@RequestParam Long idRepair,@RequestParam String newDescription){
        return devicesServices.updateDescriptionDevice(idRepair,newDescription);
    }

    @DeleteMapping()
    public void delDevice(@RequestParam Long idDevice){
        devicesServices.delDevice(idDevice);
    }
}
