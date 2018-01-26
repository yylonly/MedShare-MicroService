/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mydreamy.med.entity;

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
@Table(name = "querytorole")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Querytorole.findAll", query = "SELECT q FROM Querytorole q")
    , @NamedQuery(name = "Querytorole.findByDescription", query = "SELECT q FROM Querytorole q WHERE q.description = :description")
    , @NamedQuery(name = "Querytorole.findByQueryid", query = "SELECT q FROM Querytorole q WHERE q.querytorolePK.queryid = :queryid")
    , @NamedQuery(name = "Querytorole.findByRoleid", query = "SELECT q FROM Querytorole q WHERE q.querytorolePK.roleid = :roleid")})
public class Querytorole implements Serializable {

    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected QuerytorolePK querytorolePK;
    @JoinColumn(name = "QUERYID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Querylist querylist;
    @JoinColumn(name = "ROLEID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role;

    public Querytorole() {
    }

    public Querytorole(QuerytorolePK querytorolePK) {
        this.querytorolePK = querytorolePK;
    }

    public Querytorole(int queryid, int roleid) {
        this.querytorolePK = new QuerytorolePK(queryid, roleid);
    }

    public QuerytorolePK getQuerytorolePK() {
        return querytorolePK;
    }

    public void setQuerytorolePK(QuerytorolePK querytorolePK) {
        this.querytorolePK = querytorolePK;
    }


    public Querylist getQuerylist() {
        return querylist;
    }

    public void setQuerylist(Querylist querylist) {
        this.querylist = querylist;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (querytorolePK != null ? querytorolePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Querytorole)) {
            return false;
        }
        Querytorole other = (Querytorole) object;
        if ((this.querytorolePK == null && other.querytorolePK != null) || (this.querytorolePK != null && !this.querytorolePK.equals(other.querytorolePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Querytorole[ querytorolePK=" + querytorolePK + " ]";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
