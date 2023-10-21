package com.uptc.frw.aparatoselectronicos.service;

import com.uptc.frw.aparatoselectronicos.JPA.entity.Types;
import com.uptc.frw.aparatoselectronicos.JPA.repository.TypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypesService {
    @Autowired
    private TypesRepository typesRepository;

    @Cacheable(value = "Types")
    public List<Types> getAllTypes(){
        return  typesRepository.findAll();
    }

    @Cacheable(value = "Types",key = "#id") //typeId
    public Types findType(Long id){
        return typesRepository.findById(id).get();
    }

    public Types saveType(Types type){
        return  typesRepository.save(type);
    }

    @CacheEvict(value = "Types",key = "#id")
    public void deleteType(Long id){
        typesRepository.deleteById(id);
    }

    @CachePut(value = "Types",key = "#id")
    public Types updateTypeName (Long id, String name){
        Types types = findType(id);
        types.setName(name);
        return saveType(types);
    }
}
