package com.uptc.frw.aparatoselectronicos.service;

import com.uptc.frw.aparatoselectronicos.JPA.entity.Components;
import com.uptc.frw.aparatoselectronicos.JPA.entity.Manufacturers;
import com.uptc.frw.aparatoselectronicos.JPA.repository.ComponentsRepository;
import com.uptc.frw.aparatoselectronicos.JPA.repository.ManufacturersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ComponentsServices {
    @Autowired
    private ComponentsRepository componentsRepository;


    public Components saveComponents(Components componente){
        return componentsRepository.save(componente);
    }

    @Cacheable(value = "Components")
    public List<Components> getAllComponents(){
        return componentsRepository.findAll();
    }
    @Cacheable(value = "Components",key = "#id")
    public Components getComponenteById(Long id){
        return componentsRepository.findById(id).get();
    }

    public List<Components> getComponentsForId(Set<Long> idComponents){
        List<Components> components = null;

        for(Long idComponent : idComponents){
            components.add(getComponenteById(idComponent));
        }

        return  components;
    }

    @CacheEvict(value = "Components",key = "#id")
    public void delComponents(Long id){
        componentsRepository.deleteById(id);
    }

    @CachePut(value = "Components",key = "#id")
    public Components updateName(Long id, String newName){
        Components component = getComponenteById(id);
        component.setName(newName);

        return componentsRepository.save(component);
    }
}
