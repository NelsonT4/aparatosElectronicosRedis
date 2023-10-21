package com.uptc.frw.aparatoselectronicos.JPA.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uptc.frw.aparatoselectronicos.JPA.entity.key.ComponentsDevicesKey;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "COMPONENTE_APARATO")
@IdClass(ComponentsDevicesKey.class)
public class ComponentsDevices implements Serializable {
    private static final long serialVersionUID = -5281264929689239990L;
    @Id
    @Column(name = "ID_COMPONENTE")
    private Long componentsId;
    @Id
    @Column(name = "ID_APARATO")
    private Long devicesId;

    @Column(name = "CANTIDAD")
    private Long quantity;
    @Column(name = "PRECIO_UNIDAD")
    private Float priceUnit;


    @JsonIgnore
    @ManyToOne
    @MapsId("componentsId")
    @JoinColumn(name = "ID_APARATO")
    private Devices devices;

    @JsonIgnore
    @ManyToOne
    @MapsId("devicesId")
    @JoinColumn(name = "ID_COMPONENTE")
    private Components components;

    public ComponentsDevices() {
    }

    public ComponentsDevices(Long componentsId, Long devicesId, Long quantity, Float priceUnit) {
        this.componentsId = componentsId;
        this.devicesId = devicesId;
        this.quantity = quantity;
        this.priceUnit = priceUnit;
    }

    public Long getComponentsId() {
        return componentsId;
    }

    public void setComponentsId(Long componentsId) {
        this.componentsId = componentsId;
    }

    public Long getDevicesId() {
        return devicesId;
    }

    public void setDevicesId(Long devicesId) {
        this.devicesId = devicesId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Float getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(Float priceUnit) {
        this.priceUnit = priceUnit;
    }

    public Devices getDevices() {
        return devices;
    }

    public void setDevices(Devices devices) {
        this.devices = devices;
    }

    public Components getComponents() {
        return components;
    }

    public void setComponents(Components components) {
        this.components = components;
    }

    @Override
    public String toString() {
        return "ComponentsDevices{" +
                "deviceId=" + devices +
                ", componentsId=" + components +
                ", quantity=" + quantity +
                ", priceUnit=" + priceUnit +
                '}';
    }
}
