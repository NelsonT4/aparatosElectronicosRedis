package com.uptc.frw.aparatoselectronicos.JPA.entity.key;

import com.uptc.frw.aparatoselectronicos.JPA.entity.Components;
import com.uptc.frw.aparatoselectronicos.JPA.entity.Repairs;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


public class ChangesKey implements Serializable {

    Long repairId;


    Long componentId;

    public ChangesKey() {
    }

    public Long getRepairId() {
        return repairId;
    }

    public void setRepairId(Long repairId) {
        this.repairId = repairId;
    }

    public Long getComponentId() {
        return componentId;
    }

    public void setComponentId(Long componentId) {
        this.componentId = componentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChangesKey that = (ChangesKey) o;
        return Objects.equals(repairId, that.repairId) && Objects.equals(componentId, that.componentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repairId, componentId);
    }
}
