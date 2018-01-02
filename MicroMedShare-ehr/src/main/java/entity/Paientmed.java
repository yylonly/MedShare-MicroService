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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lp
 */
@Entity
@Table(name = "paientmed")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paientmed.findAll", query = "SELECT p FROM Paientmed p")
    , @NamedQuery(name = "Paientmed.findByPid", query = "SELECT p FROM Paientmed p WHERE p.pid = :pid")
    , @NamedQuery(name = "Paientmed.findByDoB", query = "SELECT p FROM Paientmed p WHERE p.doB = :doB")
    , @NamedQuery(name = "Paientmed.findByName", query = "SELECT p FROM Paientmed p WHERE p.name = :name")})
public class Paientmed implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PID")
    @Id
    private int pid;
    @Column(name = "DoB")
    @Temporal(TemporalType.DATE)
    private Date doB;
    @Size(max = 255)
    @Column(name = "Name")
    private String name;

    public Paientmed() {
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Date getDoB() {
        return doB;
    }

    public void setDoB(Date doB) {
        this.doB = doB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
