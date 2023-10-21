package com.uptc.frw.aparatoselectronicos.controller;

import com.uptc.frw.aparatoselectronicos.JPA.entity.Components;
import com.uptc.frw.aparatoselectronicos.JPA.entity.Manufacturers;
import com.uptc.frw.aparatoselectronicos.service.ComponentsServices;
import com.uptc.frw.aparatoselectronicos.service.ManufacturersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/component")
public class ComponentsController {

    @Autowired
    private ComponentsServices componentsServices;

    @Autowired
    private ManufacturersServices manufacturersServices;

    @GetMapping
    public List<Components> getAllComponents(){
        return componentsServices.getAllComponents();
    }

    @PostMapping
    public Components saveComponents(@RequestBody Components components, @RequestParam Long idRif){
        Manufacturers manufacturers = manufacturersServices.getManufacturer(idRif);
        components.setManufacturers(manufacturers);

        return componentsServices.saveComponents(components);
    }

    @GetMapping("/{id}")
    public  Components getComponent(@PathVariable Long id){
        return componentsServices.getComponenteById(id);
    }

    @PutMapping
    public Components updateComponents(@RequestParam Long id, @RequestParam String newName){
        return componentsServices.updateName(id,newName);
    }

    @DeleteMapping
    public void delComponents(@PathVariable Long id){
       componentsServices.delComponents(id);
    }


}
