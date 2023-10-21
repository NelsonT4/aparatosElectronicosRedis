package com.uptc.frw.aparatoselectronicos.JPA.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TIPOS")
public class Types implements Serializable {
    private static final long serialVersionUID = 8258248525476892210L;
    @Id
    @Column(name = "ID_TIPO")
    private Long typeId;
    @Column(name = "NOMBRE")
    private String name;
    @Column(name = "CARACTERISTICAS")
    private String characteristics;

    @Column(name = "TIPO_PADRE")
    private Long typeFather;


    @OneToMany(mappedBy = "types", cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private List<Devices> devices;

    //@JsonIgnore
    //@OneToMany(mappedBy = "types")
    //private List<Types> typesChildren;

    //@JsonIgnore
    //@ManyToOne
    //@JoinColumn(name = "TIPO_PADRE", referencedColumnName = "ID_TIPO",nullable = false)
    //private Types types;

    public Types() {
    }

    public Types(Long typeId, String name, String characteristics, Long typeFather) {
        this.typeId = typeId;
        this.name = name;
        this.characteristics = characteristics;
        this.typeFather = typeFather;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {

        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public Long getTypeFather() {
        return typeFather;
    }

    public void setTypeFather(Long typeFather) {
        this.typeFather = typeFather;
    }


    public List<Devices> getDevices() {
        return devices;
    }

    public void setDevices(List<Devices> devices) {
        this.devices = devices;
    }

    @Override
    public String toString() {
        return "Types{" +
                "typeId=" + typeId +
                ", name='" + name + '\'' +
                ", characteristics='" + characteristics + '\'' +
                ", typeFather=" + typeFather +
                '}';
    }
}
