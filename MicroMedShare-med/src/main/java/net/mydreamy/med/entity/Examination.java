/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mydreamy.med.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lp
 */
@Entity
@Table(name = "examination")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examination.findAll", query = "SELECT e FROM Examination e")
    , @NamedQuery(name = "Examination.findByReportID", query = "SELECT e FROM Examination e WHERE e.reportID = :reportID")
    , @NamedQuery(name = "Examination.findByEndoscopyDate", query = "SELECT e FROM Examination e WHERE e.endoscopyDate = :endoscopyDate")
    , @NamedQuery(name = "Examination.findByDiagnosesText", query = "SELECT e FROM Examination e WHERE e.diagnosesText = :diagnosesText")
    , @NamedQuery(name = "Examination.findByDoctor", query = "SELECT e FROM Examination e WHERE e.doctor = :doctor")})
public class Examination implements Serializable {

    @Size(max = 255)
    @Column(name = "Diagnoses_Text")
    private String diagnosesText;
    @Size(max = 255)
    @Column(name = "Doctor")
    private String doctor;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Report_ID")
    private Integer reportID;
    @Column(name = "Endoscopy_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endoscopyDate;
    @JoinColumn(name = "Patient_ID", referencedColumnName = "PID")
    @ManyToOne
    private Patient patientID;

    public Examination() {
    }

    public Examination(Integer reportID) {
        this.reportID = reportID;
    }

    public Integer getReportID() {
        return reportID;
    }

    public void setReportID(Integer reportID) {
        this.reportID = reportID;
    }

    public Date getEndoscopyDate() {
        return endoscopyDate;
    }

    public void setEndoscopyDate(Date endoscopyDate) {
        this.endoscopyDate = endoscopyDate;
    }

    public String getDiagnosesText() {
        return diagnosesText;
    }

    public void setDiagnosesText(String diagnosesText) {
        this.diagnosesText = diagnosesText;
    }


    public Patient getPatientID() {
        return patientID;
    }

    public void setPatientID(Patient patientID) {
        this.patientID = patientID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportID != null ? reportID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examination)) {
            return false;
        }
        Examination other = (Examination) object;
        if ((this.reportID == null && other.reportID != null) || (this.reportID != null && !this.reportID.equals(other.reportID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Examination[ reportID=" + reportID + " ]";
    }



    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
    
}
