package com.uptc.frw.aparatoselectronicos.JPA.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "FABRICANTES")
public class Manufacturers implements Serializable {
    @Id
    @Column(name = "RIF")
    private Long rif;
    @Column(name = "DOMICILIO_FISCAL")
    private String ficalDomicile;

    @JsonIgnore
    @OneToMany(mappedBy = "manufacturers", cascade = CascadeType.REMOVE)
    private List<Components>components;

    public Manufacturers() {
    }

    public Manufacturers(String ficalDomicile) {
        this.ficalDomicile = ficalDomicile;
    }

    public Long getRif() {
        return rif;
    }

    public void setRif(Long rif) {
        this.rif = rif;
    }

    public String getFicalDomicile() {
        return ficalDomicile;
    }

    public void setFicalDomicile(String ficalDomicile) {
        this.ficalDomicile = ficalDomicile;
    }

    public List<Components> getComponents() {
        return components;
    }

    public void setComponents(List<Components> components) {
        this.components = components;
    }

    @Override
    public String toString() {
        return "Manufacturers{" +
                "rif=" + rif +
                ", ficalDomicile='" + ficalDomicile + '\'' +
                '}';
    }
}
