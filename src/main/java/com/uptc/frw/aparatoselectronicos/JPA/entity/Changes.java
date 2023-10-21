package com.uptc.frw.aparatoselectronicos.JPA.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uptc.frw.aparatoselectronicos.JPA.entity.key.ChangesKey;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CAMBIOS")
@IdClass(ChangesKey.class)
public class Changes implements Serializable {

    @Id
    @Column( name = "ID_REPARACION")
    private Long repairId;

    @Id
    @Column(name = "ID_COMPONENTE")
    private Long componentId;

    @Column(name = "CANTIDAD")
    private Long quantity;


    @JsonIgnore
    @ManyToOne
    @MapsId("repairId")
    @JoinColumn(name = "ID_REPARACION")
    private Repairs repairs;

    @JsonIgnore
    @ManyToOne
    @MapsId("componentId")
    @JoinColumn(name = "ID_COMPONENTE")
    private Components components;


    public Changes() {
    }

    public Changes(Long repairId, Long componentId, Long quantity) {
        this.repairId = repairId;
        this.componentId = componentId;
        this.quantity = quantity;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Repairs getRepairs() {
        return repairs;
    }

    public void setRepairs(Repairs repairs) {
        this.repairs = repairs;
    }

    public Components getComponents() {
        return components;
    }

    public void setComponents(Components components) {
        this.components = components;
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
    public String toString() {
        return "Changes{" +
                "repairId=" + repairId +
                ", componentId=" + componentId +
                ", quantity=" + quantity +
                ", repairs=" + repairs +
                ", components=" + components +
                '}';
    }
}
