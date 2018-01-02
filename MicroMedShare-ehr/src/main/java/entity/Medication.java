/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lp
 */
@Entity
@Table(name = "medication")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medication.findAll", query = "SELECT m FROM Medication m")
    , @NamedQuery(name = "Medication.findByMid", query = "SELECT m FROM Medication m WHERE m.mid = :mid")
    , @NamedQuery(name = "Medication.findByName", query = "SELECT m FROM Medication m WHERE m.name = :name")})
public class Medication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MID")
    private Integer mid;
    @Size(max = 255)
    @Column(name = "Name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medication")
    private Collection<Prescriptmed> prescriptmedCollection;

    public Medication() {
    }

    public Medication(Integer mid) {
        this.mid = mid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Prescriptmed> getPrescriptmedCollection() {
        return prescriptmedCollection;
    }

    public void setPrescriptmedCollection(Collection<Prescriptmed> prescriptmedCollection) {
        this.prescriptmedCollection = prescriptmedCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mid != null ? mid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medication)) {
            return false;
        }
        Medication other = (Medication) object;
        if ((this.mid == null && other.mid != null) || (this.mid != null && !this.mid.equals(other.mid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Medication[ mid=" + mid + " ]";
    }
    
}
