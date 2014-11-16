/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ehurtado
 */
@Entity
@Table(name = "Users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findAllCount", query = "SELECT COUNT(u) FROM Users u"),
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"),
    @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.name = :name"),
    @NamedQuery(name = "Users.findByFirstsurname", query = "SELECT u FROM Users u WHERE u.firstsurname = :firstsurname"),
    @NamedQuery(name = "Users.findByLastsurname", query = "SELECT u FROM Users u WHERE u.lastsurname = :lastsurname"),
    @NamedQuery(name = "Users.findByDocid", query = "SELECT u FROM Users u WHERE u.docid = :docid"),
    @NamedQuery(name = "Users.findByDocidtype", query = "SELECT u FROM Users u WHERE u.docidtype = :docidtype"),
    @NamedQuery(name = "Users.findByBirthdate", query = "SELECT u FROM Users u WHERE u.birthdate = :birthdate"),
    @NamedQuery(name = "Users.findBySex", query = "SELECT u FROM Users u WHERE u.sex = :sex"),
    @NamedQuery(name = "Users.findByNationality", query = "SELECT u FROM Users u WHERE u.nationality = :nationality"),
    @NamedQuery(name = "Users.findByPhone", query = "SELECT u FROM Users u WHERE u.phone = :phone"),
    @NamedQuery(name = "Users.findByMobile", query = "SELECT u FROM Users u WHERE u.mobile = :mobile"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByImage", query = "SELECT u FROM Users u WHERE u.image = :image")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "firstsurname")
    private String firstsurname;
    @Column(name = "lastsurname")
    private String lastsurname;
    @Basic(optional = false)
    @Column(name = "docid")
    private int docid;
    @Basic(optional = false)
    @Column(name = "docidtype")
    private String docidtype;
    @Basic(optional = false)
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Basic(optional = false)
    @Column(name = "sex")
    private String sex;
    @Basic(optional = false)
    @Column(name = "nationality")
    private String nationality;
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @Column(name = "mobile")
    private String mobile;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "image")
    private String image;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usersId")
    private Collection<Players> playersCollection;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, String name, String firstsurname, int docid, String docidtype, Date birthdate, String sex, String nationality, String phone, String mobile, String email, String image) {
        this.id = id;
        this.name = name;
        this.firstsurname = firstsurname;
        this.docid = docid;
        this.docidtype = docidtype;
        this.birthdate = birthdate;
        this.sex = sex;
        this.nationality = nationality;
        this.phone = phone;
        this.mobile = mobile;
        this.email = email;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstsurname() {
        return firstsurname;
    }

    public void setFirstsurname(String firstsurname) {
        this.firstsurname = firstsurname;
    }

    public String getLastsurname() {
        return lastsurname;
    }

    public void setLastsurname(String lastsurname) {
        this.lastsurname = lastsurname;
    }

    public int getDocid() {
        return docid;
    }

    public void setDocid(int docid) {
        this.docid = docid;
    }

    public String getDocidtype() {
        return docidtype;
    }

    public void setDocidtype(String docidtype) {
        this.docidtype = docidtype;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlTransient
    public Collection<Players> getPlayersCollection() {
        return playersCollection;
    }

    public void setPlayersCollection(Collection<Players> playersCollection) {
        this.playersCollection = playersCollection;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.users.model.Users[ id=" + id + " ]";
    }
    
}
