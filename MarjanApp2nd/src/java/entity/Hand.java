/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author masaki
 */
@Entity
@Table(name = "HANDS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hand.findAll", query = "SELECT h FROM Hand h")
    , @NamedQuery(name = "Hand.findById", query = "SELECT h FROM Hand h WHERE h.id = :id")
    , @NamedQuery(name = "Hand.findByName", query = "SELECT h FROM Hand h WHERE h.name = :name")
    , @NamedQuery(name = "Hand.findByDefaultPoint", query = "SELECT h FROM Hand h WHERE h.defaultPoint = :defaultPoint")
    , @NamedQuery(name = "Hand.findByIsCallDown", query = "SELECT h FROM Hand h WHERE h.isCallDown = :isCallDown")
    , @NamedQuery(name = "Hand.findByIsNoWinner", query = "SELECT h FROM Hand h WHERE h.isNoWinner = :isNoWinner")
    , @NamedQuery(name = "Hand.findByCreateAt", query = "SELECT h FROM Hand h WHERE h.createAt = :createAt")
    , @NamedQuery(name = "Hand.findByUpdateAt", query = "SELECT h FROM Hand h WHERE h.updateAt = :updateAt")})
public class Hand implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 10)
    @Column(name = "NAME")
    private String name;
    @Column(name = "DEFAULT_POINT")
    private Integer defaultPoint;
    @Column(name = "IS_CALL_DOWN")
    private Boolean isCallDown;
    @Column(name = "IS_NO_WINNER")
    private Boolean isNoWinner;
    @Column(name = "CREATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @Column(name = "UPDATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "handId")
    private Collection<BalancesHand> balancesHandCollection;

    public Hand() {
    }

    public Hand(Integer id) {
        this.id = id;
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

    public Integer getDefaultPoint() {
        return defaultPoint;
    }

    public void setDefaultPoint(Integer defaultPoint) {
        this.defaultPoint = defaultPoint;
    }

    public Boolean getIsCallDown() {
        return isCallDown;
    }

    public void setIsCallDown(Boolean isCallDown) {
        this.isCallDown = isCallDown;
    }

    public Boolean getIsNoWinner() {
        return isNoWinner;
    }

    public void setIsNoWinner(Boolean isNoWinner) {
        this.isNoWinner = isNoWinner;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @XmlTransient
    public Collection<BalancesHand> getBalancesHandCollection() {
        return balancesHandCollection;
    }

    public void setBalancesHandCollection(Collection<BalancesHand> balancesHandCollection) {
        this.balancesHandCollection = balancesHandCollection;
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
        if (!(object instanceof Hand)) {
            return false;
        }
        Hand other = (Hand) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Hand[ id=" + id + " ]";
    }
    
}
