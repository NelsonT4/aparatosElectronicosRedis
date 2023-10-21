package com.uptc.frw.aparatoselectronicos.JPA.entity.key;

import com.uptc.frw.aparatoselectronicos.JPA.entity.Components;
import com.uptc.frw.aparatoselectronicos.JPA.entity.Devices;
import org.hibernate.annotations.CollectionId;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


public class ComponentsDevicesKey implements Serializable {

    
    Long componentsId;

    Long devicesId;

    public ComponentsDevicesKey() {
    }
    public ComponentsDevicesKey(Long components, Long devices) {
        this.componentsId = components;
        this.devicesId = devices;
    }

    public Long getComponents() {
        return componentsId;
    }

    public void setComponents(Long components) {
        this.componentsId = components;
    }

    public Long getDevices() {
        return devicesId;
    }

    public void setDevices(Long devices) {
        this.devicesId = devices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComponentsDevicesKey that = (ComponentsDevicesKey) o;
        return Objects.equals(componentsId, that.componentsId) && Objects.equals(devicesId, that.devicesId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(componentsId, devicesId);
    }


}
