package com.uptc.frw.aparatoselectronicos.service;

import com.uptc.frw.aparatoselectronicos.JPA.entity.Devices;
import com.uptc.frw.aparatoselectronicos.JPA.entity.Repairs;
import com.uptc.frw.aparatoselectronicos.JPA.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairServices {
    @Autowired
    private RepairRepository repairRepository;

    @Cacheable(value = "Repairs",key = "#id")
    public Repairs getRepair(Long id){
        return repairRepository.findById(id).get();
    }

    @Cacheable(value = "Repairs")
    public List<Repairs> getAllRepairs(){
        return repairRepository.findAll();
    }

    public Repairs saveRepair(Repairs repair){
        return repairRepository.save(repair);
    }

    @CacheEvict(value = "Repairs",key = "#id")
    public void deleteRepair(Long id){
        repairRepository.deleteById(id);
    }

    @CachePut(value = "Repairs",key = "#id")
    public Repairs updateDescribe (Long id, String describe){
        Repairs repairs = getRepair(id);
        repairs.setDescription(describe);
        return saveRepair(repairs);
    }

}
