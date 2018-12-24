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
@Table(name = "RULES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rule.findAll", query = "SELECT r FROM Rule r")
    , @NamedQuery(name = "Rule.findById", query = "SELECT r FROM Rule r WHERE r.id = :id")
    , @NamedQuery(name = "Rule.findByDefaultHavePoint", query = "SELECT r FROM Rule r WHERE r.defaultHavePoint = :defaultHavePoint")
    , @NamedQuery(name = "Rule.findByReturnPoint", query = "SELECT r FROM Rule r WHERE r.returnPoint = :returnPoint")
    , @NamedQuery(name = "Rule.findByFirstThirdPay", query = "SELECT r FROM Rule r WHERE r.firstThirdPay = :firstThirdPay")
    , @NamedQuery(name = "Rule.findByFirstSecondPay", query = "SELECT r FROM Rule r WHERE r.firstSecondPay = :firstSecondPay")
    , @NamedQuery(name = "Rule.findByName", query = "SELECT r FROM Rule r WHERE r.name = :name")
    , @NamedQuery(name = "Rule.findByCreateAt", query = "SELECT r FROM Rule r WHERE r.createAt = :createAt")
    , @NamedQuery(name = "Rule.findByUpdateAt", query = "SELECT r FROM Rule r WHERE r.updateAt = :updateAt")})
public class Rule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEFAULT_HAVE_POINT")
    private int defaultHavePoint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RETURN_POINT")
    private int returnPoint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FIRST_THIRD_PAY")
    private int firstThirdPay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FIRST_SECOND_PAY")
    private int firstSecondPay;
    @Size(max = 10)
    @Column(name = "NAME")
    private String name;
    @Column(name = "CREATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @Column(name = "UPDATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ruleId")
    private Collection<Game> gameCollection;

    public Rule() {
    }

    public Rule(Integer id) {
        this.id = id;
    }

    public Rule(Integer id, int defaultHavePoint, int returnPoint, int firstThirdPay, int firstSecondPay) {
        this.id = id;
        this.defaultHavePoint = defaultHavePoint;
        this.returnPoint = returnPoint;
        this.firstThirdPay = firstThirdPay;
        this.firstSecondPay = firstSecondPay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDefaultHavePoint() {
        return defaultHavePoint;
    }

    public void setDefaultHavePoint(int defaultHavePoint) {
        this.defaultHavePoint = defaultHavePoint;
    }

    public int getReturnPoint() {
        return returnPoint;
    }

    public void setReturnPoint(int returnPoint) {
        this.returnPoint = returnPoint;
    }

    public int getFirstThirdPay() {
        return firstThirdPay;
    }

    public void setFirstThirdPay(int firstThirdPay) {
        this.firstThirdPay = firstThirdPay;
    }

    public int getFirstSecondPay() {
        return firstSecondPay;
    }

    public void setFirstSecondPay(int firstSecondPay) {
        this.firstSecondPay = firstSecondPay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public Collection<Game> getGameCollection() {
        return gameCollection;
    }

    public void setGameCollection(Collection<Game> gameCollection) {
        this.gameCollection = gameCollection;
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
        if (!(object instanceof Rule)) {
            return false;
        }
        Rule other = (Rule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Rule[ id=" + id + " ]";
    }
    
}
