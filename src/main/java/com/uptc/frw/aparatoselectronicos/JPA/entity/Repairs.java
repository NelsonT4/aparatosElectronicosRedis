package com.uptc.frw.aparatoselectronicos.JPA.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uptc.frw.aparatoselectronicos.JPA.entity.key.ChangesKey;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "REPARACIONES")

public class Repairs implements Serializable {
    private static final long serialVersionUID = -1683851048994125961L;
    @Id
    @Column(name = "ID_REPARACION")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRIPCION")
    private String description;
    @Column(name = "FECHA")
    private Date date;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "NID", nullable = false)
    private Customer  customer;


    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "repairs", cascade = CascadeType.REMOVE)
    private List<Changes>changes;


    @OneToMany(mappedBy = "repairs", cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private List<Devices>devices;

    public Repairs() {
    }

    public Repairs( String description, Date date) {

        this.description = description;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Changes> getChanges() {
        return changes;
    }

    public void setChanges(List<Changes> changes) {
        this.changes = changes;
    }

    public List<Devices> getDevices() {
        return devices;
    }

    public void setDevices(List<Devices> devices) {
        this.devices = devices;
    }


    @Override
    public String toString() {
        return "Repairs{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
