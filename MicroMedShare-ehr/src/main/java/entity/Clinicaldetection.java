/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "clinicaldetection")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clinicaldetection.findAll", query = "SELECT c FROM Clinicaldetection c")
    , @NamedQuery(name = "Clinicaldetection.findByDetectionID", query = "SELECT c FROM Clinicaldetection c WHERE c.detectionID = :detectionID")
    , @NamedQuery(name = "Clinicaldetection.findByDetectedDate", query = "SELECT c FROM Clinicaldetection c WHERE c.detectedDate = :detectedDate")})
public class Clinicaldetection implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Detection_ID")
    private Integer detectionID;
    @Column(name = "DetectedDate")
    @Temporal(TemporalType.DATE)
    private Date detectedDate;
    @Lob
    @Size(max = 65535)
    @Column(name = "Times")
    private String times;
    @Lob
    @Size(max = 65535)
    @Column(name = "AntiHBs")
    private String antiHBs;
    @Lob
    @Size(max = 65535)
    @Column(name = "HBsAg")
    private String hBsAg;
    @Lob
    @Size(max = 65535)
    @Column(name = "HIV")
    private String hiv;
    @Lob
    @Size(max = 65535)
    @Column(name = "HDV")
    private String hdv;
    @Lob
    @Size(max = 65535)
    @Column(name = "HCV")
    private String hcv;
    @JoinColumn(name = "Patient_ID", referencedColumnName = "PID")
    @ManyToOne
    private Patient patientID;

    public Clinicaldetection() {
    }

    public Clinicaldetection(Integer detectionID) {
        this.detectionID = detectionID;
    }

    public Integer getDetectionID() {
        return detectionID;
    }

    public void setDetectionID(Integer detectionID) {
        this.detectionID = detectionID;
    }

    public Date getDetectedDate() {
        return detectedDate;
    }

    public void setDetectedDate(Date detectedDate) {
        this.detectedDate = detectedDate;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getAntiHBs() {
        return antiHBs;
    }

    public void setAntiHBs(String antiHBs) {
        this.antiHBs = antiHBs;
    }

    public String getHBsAg() {
        return hBsAg;
    }

    public void setHBsAg(String hBsAg) {
        this.hBsAg = hBsAg;
    }

    public String getHiv() {
        return hiv;
    }

    public void setHiv(String hiv) {
        this.hiv = hiv;
    }

    public String getHdv() {
        return hdv;
    }

    public void setHdv(String hdv) {
        this.hdv = hdv;
    }

    public String getHcv() {
        return hcv;
    }

    public void setHcv(String hcv) {
        this.hcv = hcv;
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
        hash += (detectionID != null ? detectionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clinicaldetection)) {
            return false;
        }
        Clinicaldetection other = (Clinicaldetection) object;
        if ((this.detectionID == null && other.detectionID != null) || (this.detectionID != null && !this.detectionID.equals(other.detectionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Clinicaldetection[ detectionID=" + detectionID + " ]";
    }
    
}
