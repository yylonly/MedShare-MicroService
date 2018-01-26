/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mydreamy.ehr.entity;

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
public class QuerytorolePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "QUERYID")
    private int queryid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROLEID")
    private int roleid;

    public QuerytorolePK() {
    }

    public QuerytorolePK(int queryid, int roleid) {
        this.queryid = queryid;
        this.roleid = roleid;
    }

    public int getQueryid() {
        return queryid;
    }

    public void setQueryid(int queryid) {
        this.queryid = queryid;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) queryid;
        hash += (int) roleid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuerytorolePK)) {
            return false;
        }
        QuerytorolePK other = (QuerytorolePK) object;
        if (this.queryid != other.queryid) {
            return false;
        }
        if (this.roleid != other.roleid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.QuerytorolePK[ queryid=" + queryid + ", roleid=" + roleid + " ]";
    }
    
}
