/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ehurtado
 */
@Entity
@Table(name = "players")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Players.findAll", query = "SELECT p FROM Players p"),
    @NamedQuery(name = "Players.findById", query = "SELECT p FROM Players p WHERE p.id = :id"),
    @NamedQuery(name = "Players.findByBack", query = "SELECT p FROM Players p WHERE p.back = :back"),
    @NamedQuery(name = "Players.findByNumber", query = "SELECT p FROM Players p WHERE p.number = :number"),
    @NamedQuery(name = "Players.findByPosition", query = "SELECT p FROM Players p WHERE p.position = :position"),
    @NamedQuery(name = "Players.findByFoot", query = "SELECT p FROM Players p WHERE p.foot = :foot")})
public class Players implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "back")
    private String back;
    @Basic(optional = false)
    @Column(name = "number")
    private String number;
    @Basic(optional = false)
    @Column(name = "position")
    private String position;
    @Basic(optional = false)
    @Column(name = "foot")
    private String foot;
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users usersId;

    public Players() {
    }

    public Players(Integer id) {
        this.id = id;
    }

    public Players(Integer id, String back, String number, String position, String foot) {
        this.id = id;
        this.back = back;
        this.number = number;
        this.position = position;
        this.foot = foot;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    public Users getUsersId() {
        return usersId;
    }

    public void setUsersId(Users usersId) {
        this.usersId = usersId;
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
        if (!(object instanceof Players)) {
            return false;
        }
        Players other = (Players) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.users.model.Players[ id=" + id + " ]";
    }
    
}
