package com.uptc.frw.aparatoselectronicos.controller;

import com.uptc.frw.aparatoselectronicos.JPA.entity.Customer;
import com.uptc.frw.aparatoselectronicos.JPA.entity.Devices;
import com.uptc.frw.aparatoselectronicos.JPA.entity.Repairs;
import com.uptc.frw.aparatoselectronicos.JPA.entity.Types;
import com.uptc.frw.aparatoselectronicos.service.CustomerServices;
import com.uptc.frw.aparatoselectronicos.service.DevicesServices;
import com.uptc.frw.aparatoselectronicos.service.RepairServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    private RepairServices repairServices;

    @Autowired
    private CustomerServices customerServices;

    @Autowired
    private DevicesServices devicesServices;


    @GetMapping
    public List<Repairs> getAllRepairs(){
        return repairServices.getAllRepairs();
    }

    @PostMapping
    public  Repairs saveRepair(@RequestBody Repairs repair,@RequestParam Long nid,@RequestParam Long idAparato){
        Customer customer = customerServices.getCustomer(nid);
        repair.setCustomer(customer);

        //Agrega el aparato que se va a reparar
        List<Devices> devicesRepair = repair.getDevices();
        Devices device = devicesServices.getDeviceId(idAparato);
        devicesRepair.add(device);
        repair.setDevices(devicesRepair);

        return repairServices.saveRepair(repair);
    }
    @DeleteMapping("/{id}")
    public void deleteType(@PathVariable Long id){
        repairServices.deleteRepair(id);
    }
    @PutMapping("/{id}")
    public Repairs updateType(@PathVariable Long id, @RequestParam String describe){
        return repairServices.updateDescribe(id,describe);
    }

}
