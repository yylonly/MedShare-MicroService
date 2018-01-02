/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author lp
 */
@Embeddable
public class PrescriptmedPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "PRESCRIPTID")
    private int prescriptid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEDID")
    private int medid;

    public PrescriptmedPK() {
    }

    public PrescriptmedPK(int prescriptid, int medid) {
        this.prescriptid = prescriptid;
        this.medid = medid;
    }

    public int getPrescriptid() {
        return prescriptid;
    }

    public void setPrescriptid(int prescriptid) {
        this.prescriptid = prescriptid;
    }

    public int getMedid() {
        return medid;
    }

    public void setMedid(int medid) {
        this.medid = medid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) prescriptid;
        hash += (int) medid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrescriptmedPK)) {
            return false;
        }
        PrescriptmedPK other = (PrescriptmedPK) object;
        if (this.prescriptid != other.prescriptid) {
            return false;
        }
        if (this.medid != other.medid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PrescriptmedPK[ prescriptid=" + prescriptid + ", medid=" + medid + " ]";
    }
    
}
