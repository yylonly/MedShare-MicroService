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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lp
 */
@Entity
@Table(name = "prescription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prescription.findAll", query = "SELECT p FROM Prescription p")
    , @NamedQuery(name = "Prescription.findByPid", query = "SELECT p FROM Prescription p WHERE p.pid = :pid")
    , @NamedQuery(name = "Prescription.findByPresDate", query = "SELECT p FROM Prescription p WHERE p.presDate = :presDate")})
public class Prescription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PID")
    private Integer pid;
    @Column(name = "Pres_Date")
    @Temporal(TemporalType.DATE)
    private Date presDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prescription")
    private Collection<Prescriptmed> prescriptmedCollection;
    @JoinColumn(name = "Patient_ID", referencedColumnName = "PID")
    @ManyToOne
    private Patient patientID;
    @JoinColumn(name = "Doctor_ID", referencedColumnName = "DID")
    @ManyToOne
    private Doctor doctorID;

    public Prescription() {
    }

    public Prescription(Integer pid) {
        this.pid = pid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Date getPresDate() {
        return presDate;
    }

    public void setPresDate(Date presDate) {
        this.presDate = presDate;
    }

    @XmlTransient
    public Collection<Prescriptmed> getPrescriptmedCollection() {
        return prescriptmedCollection;
    }

    public void setPrescriptmedCollection(Collection<Prescriptmed> prescriptmedCollection) {
        this.prescriptmedCollection = prescriptmedCollection;
    }

    public Patient getPatientID() {
        return patientID;
    }

    public void setPatientID(Patient patientID) {
        this.patientID = patientID;
    }

    public Doctor getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Doctor doctorID) {
        this.doctorID = doctorID;
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
        if (!(object instanceof Prescription)) {
            return false;
        }
        Prescription other = (Prescription) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Prescription[ pid=" + pid + " ]";
    }
    
}
