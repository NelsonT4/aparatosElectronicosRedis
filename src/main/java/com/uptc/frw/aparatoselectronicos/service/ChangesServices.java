package com.uptc.frw.aparatoselectronicos.service;

import com.uptc.frw.aparatoselectronicos.JPA.entity.Changes;
import com.uptc.frw.aparatoselectronicos.JPA.repository.ChangesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChangesServices {
    @Autowired
    private ChangesRepository changesRepository;

    public List<Changes> findAllChanges(){
        return changesRepository.findAll();
    }
    public Changes saveChanges(Changes changes){
        return changesRepository.save(changes);
    }
    public Changes findChanges(Long id){
        return changesRepository.findById(id).get();
    }
    public void deleteChanges(Long id){
        changesRepository.deleteById(id);
    }
    public Changes updateChanges (Long id, Long quantity) {
        Changes changes = findChanges(id);
        changes.setQuantity(quantity);
        return saveChanges(changes);
    }
}
