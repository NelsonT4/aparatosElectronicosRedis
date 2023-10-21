package com.uptc.frw.aparatoselectronicos.JPA.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uptc.frw.aparatoselectronicos.JPA.entity.key.ComponentsDevicesKey;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "APARATO")
public class Devices implements Serializable {


    private static final long serialVersionUID = -1009110459433514478L;

    @Id
    @Column(name = "ID_APARATO")
    private Long id;

    @Column(name = "DESCRIPCION")
    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_REPARACION")
    private Repairs repairs;


    @OneToMany(mappedBy = "devices",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private List<ComponentsDevices>componentsDevices;

     @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TIPO")
    private Types types;

    public Devices() {
    }

    public Devices(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Repairs getRepairs() {
        return repairs;
    }

    public void setRepairs(Repairs repairs) {
        this.repairs = repairs;
    }

    public List<ComponentsDevices> getComponentsDevices() {
        return componentsDevices;
    }

    public void setComponentsDevices(List<ComponentsDevices> componentsDevices) {
        this.componentsDevices = componentsDevices;
    }



    public Types getTypes() {
        return types;
    }

    public void setTypes(Types types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "Devices{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", repairs=" + repairs +
                ", componentsDevices=" + componentsDevices +
                ", types=" + types +
                '}';
    }
}
