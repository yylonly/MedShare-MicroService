/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mydreamy.ehr.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lp
 */
@Entity
@Table(name = "prescriptmed")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prescriptmed.findAll", query = "SELECT p FROM Prescriptmed p")
    , @NamedQuery(name = "Prescriptmed.findByDescription", query = "SELECT p FROM Prescriptmed p WHERE p.description = :description")
    , @NamedQuery(name = "Prescriptmed.findByPrescriptid", query = "SELECT p FROM Prescriptmed p WHERE p.prescriptmedPK.prescriptid = :prescriptid")
    , @NamedQuery(name = "Prescriptmed.findByMedid", query = "SELECT p FROM Prescriptmed p WHERE p.prescriptmedPK.medid = :medid")})
public class Prescriptmed implements Serializable {

    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrescriptmedPK prescriptmedPK;
    @JoinColumn(name = "MEDID", referencedColumnName = "MID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Medication medication;
    @JoinColumn(name = "PRESCRIPTID", referencedColumnName = "PID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Prescription prescription;

    public Prescriptmed() {
    }

    public Prescriptmed(PrescriptmedPK prescriptmedPK) {
        this.prescriptmedPK = prescriptmedPK;
    }

    public Prescriptmed(int prescriptid, int medid) {
        this.prescriptmedPK = new PrescriptmedPK(prescriptid, medid);
    }

    public PrescriptmedPK getPrescriptmedPK() {
        return prescriptmedPK;
    }

    public void setPrescriptmedPK(PrescriptmedPK prescriptmedPK) {
        this.prescriptmedPK = prescriptmedPK;
    }


    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prescriptmedPK != null ? prescriptmedPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prescriptmed)) {
            return false;
        }
        Prescriptmed other = (Prescriptmed) object;
        if ((this.prescriptmedPK == null && other.prescriptmedPK != null) || (this.prescriptmedPK != null && !this.prescriptmedPK.equals(other.prescriptmedPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Prescriptmed[ prescriptmedPK=" + prescriptmedPK + " ]";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
