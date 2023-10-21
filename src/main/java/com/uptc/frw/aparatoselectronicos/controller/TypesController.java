package com.uptc.frw.aparatoselectronicos.controller;

import com.uptc.frw.aparatoselectronicos.JPA.entity.Types;
import com.uptc.frw.aparatoselectronicos.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypesController {
    @Autowired
    private TypesService typesService;

    @GetMapping
    public List<Types> getAllTypes(){
        return typesService.getAllTypes();
    }

    @PostMapping("/create")
    public Types saveType(@RequestBody Types type){
        return typesService.saveType(type);

    }

    @GetMapping("/search")
    public Types getType(@RequestParam  Long id){
        return typesService.findType(id);
    }

    @DeleteMapping("/{id}")
    public void deleteType(@PathVariable Long id){
        typesService.deleteType(id);
    }
    @PutMapping("/{id}")
    public Types updateType(@PathVariable Long id, @RequestParam String name){
        return typesService.updateTypeName(id,name);
    }
}
