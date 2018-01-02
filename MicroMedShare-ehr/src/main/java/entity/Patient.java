/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
@Table(name = "patient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p")
    , @NamedQuery(name = "Patient.findByPid", query = "SELECT p FROM Patient p WHERE p.pid = :pid")
    , @NamedQuery(name = "Patient.findByName", query = "SELECT p FROM Patient p WHERE p.name = :name")
    , @NamedQuery(name = "Patient.findBySurname", query = "SELECT p FROM Patient p WHERE p.surname = :surname")
    , @NamedQuery(name = "Patient.findByGender", query = "SELECT p FROM Patient p WHERE p.gender = :gender")
    , @NamedQuery(name = "Patient.findByDoB", query = "SELECT p FROM Patient p WHERE p.doB = :doB")
    , @NamedQuery(name = "Patient.findByCountry", query = "SELECT p FROM Patient p WHERE p.country = :country")
    , @NamedQuery(name = "Patient.findByStreetAddress", query = "SELECT p FROM Patient p WHERE p.streetAddress = :streetAddress")
    , @NamedQuery(name = "Patient.findByCity", query = "SELECT p FROM Patient p WHERE p.city = :city")
    , @NamedQuery(name = "Patient.findByPostal", query = "SELECT p FROM Patient p WHERE p.postal = :postal")})
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PID")
    private Integer pid;
    @Size(max = 255)
    @Column(name = "Name")
    private String name;
    @Size(max = 255)
    @Column(name = "Surname")
    private String surname;
    @Column(name = "Gender")
    private Character gender;
    @Column(name = "DoB")
    @Temporal(TemporalType.DATE)
    private Date doB;
    @Size(max = 100)
    @Column(name = "Country")
    private String country;
    @Size(max = 255)
    @Column(name = "StreetAddress")
    private String streetAddress;
    @Size(max = 255)
    @Column(name = "City")
    private String city;
    @Size(max = 10)
    @Column(name = "Postal")
    private String postal;
    @OneToMany(mappedBy = "patientID")
    private Collection<Clinicaldetection> clinicaldetectionCollection;
    @OneToMany(mappedBy = "patientID")
    private Collection<Prescription> prescriptionCollection;
    @OneToMany(mappedBy = "patientID")
    private Collection<Examination> examinationCollection;

    public Patient() {
    }

    public Patient(Integer pid) {
        this.pid = pid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    @XmlTransient
    public Collection<Clinicaldetection> getClinicaldetectionCollection() {
        return clinicaldetectionCollection;
    }

    public void setClinicaldetectionCollection(Collection<Clinicaldetection> clinicaldetectionCollection) {
        this.clinicaldetectionCollection = clinicaldetectionCollection;
    }

    @XmlTransient
    public Collection<Prescription> getPrescriptionCollection() {
        return prescriptionCollection;
    }

    public void setPrescriptionCollection(Collection<Prescription> prescriptionCollection) {
        this.prescriptionCollection = prescriptionCollection;
    }

    @XmlTransient
    public Collection<Examination> getExaminationCollection() {
        return examinationCollection;
    }

    public void setExaminationCollection(Collection<Examination> examinationCollection) {
        this.examinationCollection = examinationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pid != null ? pid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Patient[ pid=" + pid + " ]";
    }
    
}
