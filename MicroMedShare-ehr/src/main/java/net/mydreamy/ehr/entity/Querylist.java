/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mydreamy.ehr.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "querylist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Querylist.findAll", query = "SELECT q FROM Querylist q")
    , @NamedQuery(name = "Querylist.findById", query = "SELECT q FROM Querylist q WHERE q.id = :id")
    , @NamedQuery(name = "Querylist.findByDescription", query = "SELECT q FROM Querylist q WHERE q.description = :description")
    , @NamedQuery(name = "Querylist.findBySqlquery", query = "SELECT q FROM Querylist q WHERE q.sqlquery = :sqlquery")})
public class Querylist implements Serializable {

    @Size(max = 2000)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 2000)
    @Column(name = "SQLQUERY")
    private String sqlquery;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "querylist")
    private Collection<Querytorole> querytoroleCollection;
    @JoinColumn(name = "urlid", referencedColumnName = "ID")
    @ManyToOne
    private Urlforwebservice urlid;

    public Querylist() {
    }

    public Querylist(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @XmlTransient
    public Collection<Querytorole> getQuerytoroleCollection() {
        return querytoroleCollection;
    }

    public void setQuerytoroleCollection(Collection<Querytorole> querytoroleCollection) {
        this.querytoroleCollection = querytoroleCollection;
    }

    public Urlforwebservice getUrlid() {
        return urlid;
    }

    public void setUrlid(Urlforwebservice urlid) {
        this.urlid = urlid;
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
        if (!(object instanceof Querylist)) {
            return false;
        }
        Querylist other = (Querylist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Querylist[ id=" + id + " ]";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSqlquery() {
        return sqlquery;
    }

    public void setSqlquery(String sqlquery) {
        this.sqlquery = sqlquery;
    }
    
}
