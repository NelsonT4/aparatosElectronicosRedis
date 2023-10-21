package com.uptc.frw.aparatoselectronicos.JPA.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uptc.frw.aparatoselectronicos.JPA.entity.key.ChangesKey;
import com.uptc.frw.aparatoselectronicos.JPA.entity.key.ComponentsDevicesKey;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "COMPONENTES")

public class Components implements Serializable {
    private static final long serialVersionUID = 4446494934116004799L;
    @Id
    @Column(name = "ID_COMPONENTE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE")
    private String name;

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "components",cascade = CascadeType.REMOVE)
    private List<Changes>changes;

    @JsonIgnore
    @OneToMany(mappedBy = "components", cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private List<ComponentsDevices>componentsDevices;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RIF")
    private Manufacturers manufacturers;


    public Components() {
    }

    public Components(Long rif, String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Changes> getChanges() {
        return changes;
    }

    public void setChanges(List<Changes> changes) {
        this.changes = changes;
    }

    public List<ComponentsDevices> getComponentsDevices() {
        return componentsDevices;
    }

    public void setComponentsDevices(List<ComponentsDevices> componentsDevices) {
        this.componentsDevices = componentsDevices;
    }

    public Manufacturers getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(Manufacturers manufacturers) {
        this.manufacturers = manufacturers;
    }

    @Override
    public String toString() {
        return "Components{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
