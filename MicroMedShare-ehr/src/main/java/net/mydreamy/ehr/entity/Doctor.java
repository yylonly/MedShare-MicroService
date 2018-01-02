/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mydreamy.ehr.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lp
 */
@Entity
@Table(name = "doctor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doctor.findAll", query = "SELECT d FROM Doctor d")
    , @NamedQuery(name = "Doctor.findByDid", query = "SELECT d FROM Doctor d WHERE d.did = :did")
    , @NamedQuery(name = "Doctor.findByName", query = "SELECT d FROM Doctor d WHERE d.name = :name")
    , @NamedQuery(name = "Doctor.findBySurname", query = "SELECT d FROM Doctor d WHERE d.surname = :surname")
    , @NamedQuery(name = "Doctor.findByGender", query = "SELECT d FROM Doctor d WHERE d.gender = :gender")
    , @NamedQuery(name = "Doctor.findByDoB", query = "SELECT d FROM Doctor d WHERE d.doB = :doB")
    , @NamedQuery(name = "Doctor.findByCountry", query = "SELECT d FROM Doctor d WHERE d.country = :country")})
public class Doctor implements Serializable {

    @Size(max = 255)
    @Column(name = "Name")
    private String name;
    @Size(max = 255)
    @Column(name = "Surname")
    private String surname;
    @Size(max = 100)
    @Column(name = "Country")
    private String country;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DID")
    private Integer did;
    @Column(name = "Gender")
    private Character gender;
    @Column(name = "DoB")
    @Temporal(TemporalType.DATE)
    private Date doB;
    @OneToMany(mappedBy = "doctorID")
    private Collection<Prescription> prescriptionCollection;

    public Doctor() {
    }

    public Doctor(Integer did) {
        this.did = did;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }


    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Date getDoB() {
        return doB;
    }

    public void setDoB(Date doB) {
        this.doB = doB;
    }


    @XmlTransient
    public Collection<Prescription> getPrescriptionCollection() {
        return prescriptionCollection;
    }

    public void setPrescriptionCollection(Collection<Prescription> prescriptionCollection) {
        this.prescriptionCollection = prescriptionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (did != null ? did.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctor)) {
            return false;
        }
        Doctor other = (Doctor) object;
        if ((this.did == null && other.did != null) || (this.did != null && !this.did.equals(other.did))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Doctor[ did=" + did + " ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
}
