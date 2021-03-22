/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoproject;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BEL
 */
@Entity
@Table(name = "emp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emp.findAll", query = "SELECT e FROM Emp e")
    , @NamedQuery(name = "Emp.findByEid", query = "SELECT e FROM Emp e WHERE e.eid = :eid")
    , @NamedQuery(name = "Emp.findByUsername", query = "SELECT e FROM Emp e WHERE e.username = :username")
    , @NamedQuery(name = "Emp.updatePassword", query = "UPDATE Emp e SET e.password = :password WHERE e.username = :username")
    , @NamedQuery(name = "Emp.deleteByEid", query = "DELETE FROM Emp e WHERE e.eid = :eid")
    , @NamedQuery(name = "Emp.findByPassword", query = "SELECT e FROM Emp e WHERE e.password = :password")})
public class Emp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "eid")
    private Integer eid;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;

    public Emp() {
    }

    public Emp(Integer eid) {
        this.eid = eid;
    }

    public Emp(Integer eid, String username, String password) {
        this.eid = eid;
        this.username = username;
        this.password = password;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eid != null ? eid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emp)) {
            return false;
        }
        Emp other = (Emp) object;
        if ((this.eid == null && other.eid != null) || (this.eid != null && !this.eid.equals(other.eid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demoproject.Emp[ eid=" + eid + " ]";
    }
    
}
