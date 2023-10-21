package com.uptc.frw.aparatoselectronicos.controller;

import com.uptc.frw.aparatoselectronicos.JPA.entity.Changes;
import com.uptc.frw.aparatoselectronicos.JPA.entity.Components;
import com.uptc.frw.aparatoselectronicos.JPA.entity.Repairs;
import com.uptc.frw.aparatoselectronicos.service.ChangesServices;
import com.uptc.frw.aparatoselectronicos.service.ComponentsServices;
import com.uptc.frw.aparatoselectronicos.service.RepairServices;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/changes")
public class ChangesController {
    @Autowired
    private ChangesServices changesServices;

    @Autowired
    private RepairServices repairServices;

    @Autowired
    private ComponentsServices componentsServices;

    @GetMapping
    public List<Changes>findAll(){
        return changesServices.findAllChanges();
    }
    @PostMapping
    public Changes saveChanges(@RequestBody Changes changes, @RequestParam Long repairId,@RequestParam Long componentId){
        changes.setRepairId(repairId);
        changes.setComponentId(componentId);

        Repairs repairs = repairServices.getRepair(repairId);
        changes.setRepairs(repairs);

        Components component = componentsServices.getComponenteById(componentId);
        changes.setComponents(component);

        //Agrega los cambios a la reparacion
        List<Changes> changesRepair = repairs.getChanges();
        changesRepair.add(changes);
        repairs.setChanges(changesRepair);

        return changesServices.saveChanges(changes);
    }
    @PostMapping("/{id}")
    public Changes findChanges(@PathVariable Long id){
        return changesServices.findChanges(id);
    }
    @DeleteMapping("/{id}")
    public void deleteChanges(@PathVariable Long id){
        changesServices.deleteChanges(id);
    };
    @PutMapping("/{id}")
    public Changes updateChanges(@PathVariable Long id, @RequestParam Long quantity){
        return  changesServices.updateChanges(id, quantity);
    }
}
