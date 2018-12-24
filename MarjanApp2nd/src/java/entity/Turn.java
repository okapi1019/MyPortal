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
@Table(name = "TURN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turn.findAll", query = "SELECT t FROM Turn t")
    , @NamedQuery(name = "Turn.findById", query = "SELECT t FROM Turn t WHERE t.id = :id")
    , @NamedQuery(name = "Turn.findByTurnName", query = "SELECT t FROM Turn t WHERE t.turnName = :turnName")
    , @NamedQuery(name = "Turn.findBySemiTurn", query = "SELECT t FROM Turn t WHERE t.semiTurn = :semiTurn")
    , @NamedQuery(name = "Turn.findByTurnNumber", query = "SELECT t FROM Turn t WHERE t.turnNumber = :turnNumber")
    , @NamedQuery(name = "Turn.findByCreateAt", query = "SELECT t FROM Turn t WHERE t.createAt = :createAt")
    , @NamedQuery(name = "Turn.findByUpdateAt", query = "SELECT t FROM Turn t WHERE t.updateAt = :updateAt")})
public class Turn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 10)
    @Column(name = "TURN_NAME")
    private String turnName;
    @Column(name = "SEMI_TURN")
    private Integer semiTurn;
    @Column(name = "TURN_NUMBER")
    private Integer turnNumber;
    @Column(name = "CREATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @Column(name = "UPDATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    @OneToMany(mappedBy = "turnId")
    private Collection<Balance> balanceCollection;

    public Turn() {
    }

    public Turn(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTurnName() {
        return turnName;
    }

    public void setTurnName(String turnName) {
        this.turnName = turnName;
    }

    public Integer getSemiTurn() {
        return semiTurn;
    }

    public void setSemiTurn(Integer semiTurn) {
        this.semiTurn = semiTurn;
    }

    public Integer getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(Integer turnNumber) {
        this.turnNumber = turnNumber;
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
    public Collection<Balance> getBalanceCollection() {
        return balanceCollection;
    }

    public void setBalanceCollection(Collection<Balance> balanceCollection) {
        this.balanceCollection = balanceCollection;
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
        if (!(object instanceof Turn)) {
            return false;
        }
        Turn other = (Turn) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Turn[ id=" + id + " ]";
    }
    
}
