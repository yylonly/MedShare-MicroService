/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mydreamy.med.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lp
 */
@Entity
@Table(name = "urlforwebservice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Urlforwebservice.findAll", query = "SELECT u FROM Urlforwebservice u")
    , @NamedQuery(name = "Urlforwebservice.findById", query = "SELECT u FROM Urlforwebservice u WHERE u.id = :id")
    , @NamedQuery(name = "Urlforwebservice.findByUrl", query = "SELECT u FROM Urlforwebservice u WHERE u.url = :url")})
public class Urlforwebservice implements Serializable {

    @Size(max = 255)
    @Column(name = "URL")
    private String url;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @OneToMany(mappedBy = "urlid")
    private Collection<Querylist> querylistCollection;

    public Urlforwebservice() {
    }

    public Urlforwebservice(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @XmlTransient
    public Collection<Querylist> getQuerylistCollection() {
        return querylistCollection;
    }

    public void setQuerylistCollection(Collection<Querylist> querylistCollection) {
        this.querylistCollection = querylistCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Urlforwebservice)) {
            return false;
        }
        Urlforwebservice other = (Urlforwebservice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Urlforwebservice[ id=" + id + " ]";
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
