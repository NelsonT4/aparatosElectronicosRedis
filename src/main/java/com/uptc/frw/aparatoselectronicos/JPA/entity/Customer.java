package com.uptc.frw.aparatoselectronicos.JPA.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CLIENTE")
public class Customer implements Serializable {
    @Id
    @Column(name = "NID")
    private Long nid;
    @Column(name = "DIRECCION")
    private String address;
    @Column(name = "TELEFONO")
    private Long phone;
    @Column(name = "CORREO")
    private String mail;

    @JsonIgnore
    @OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE)
    private List<Repairs> repairs;

    public Customer() {
    }

    public Customer(String address, Long phone, String mail) {
        this.address = address;
        this.phone = phone;
        this.mail = mail;
    }

    public Long getNid() {
        return nid;
    }

    public void setNid(Long nid) {
        this.nid = nid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Repairs> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<Repairs> repairs) {
        this.repairs = repairs;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "nid=" + nid +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", mail='" + mail + '\'' +
                '}';
    }
}
