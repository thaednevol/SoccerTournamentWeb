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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ehurtado
 */
@Entity
@Table(name = "teams")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teams.findAll", query = "SELECT t FROM Teams t"),
    @NamedQuery(name = "Teams.findById", query = "SELECT t FROM Teams t WHERE t.id = :id"),
    @NamedQuery(name = "Teams.findByName", query = "SELECT t FROM Teams t WHERE t.name = :name"),
    @NamedQuery(name = "Teams.findByLegalRepresentant", query = "SELECT t FROM Teams t WHERE t.legalRepresentant = :legalRepresentant"),
    @NamedQuery(name = "Teams.findByStadium", query = "SELECT t FROM Teams t WHERE t.stadium = :stadium"),
    @NamedQuery(name = "Teams.findByTrainer", query = "SELECT t FROM Teams t WHERE t.trainer = :trainer")})
public class Teams implements Serializable {
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
    @Column(name = "legal_representant")
    private String legalRepresentant;
    @Basic(optional = false)
    @Column(name = "stadium")
    private String stadium;
    @Basic(optional = false)
    @Column(name = "trainer")
    private String trainer;

    public Teams() {
    }

    public Teams(Integer id) {
        this.id = id;
    }

    public Teams(Integer id, String name, String legalRepresentant, String stadium, String trainer) {
        this.id = id;
        this.name = name;
        this.legalRepresentant = legalRepresentant;
        this.stadium = stadium;
        this.trainer = trainer;
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

    public String getLegalRepresentant() {
        return legalRepresentant;
    }

    public void setLegalRepresentant(String legalRepresentant) {
        this.legalRepresentant = legalRepresentant;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
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
        if (!(object instanceof Teams)) {
            return false;
        }
        Teams other = (Teams) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.users.model.Teams[ id=" + id + " ]";
    }
    
}
