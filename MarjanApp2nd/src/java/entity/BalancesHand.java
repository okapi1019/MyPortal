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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author masaki
 */
@Entity
@Table(name = "BALANCES_HANDS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BalancesHand.findAll", query = "SELECT b FROM BalancesHand b")
    , @NamedQuery(name = "BalancesHand.findById", query = "SELECT b FROM BalancesHand b WHERE b.id = :id")
    , @NamedQuery(name = "BalancesHand.findByCreateAt", query = "SELECT b FROM BalancesHand b WHERE b.createAt = :createAt")
    , @NamedQuery(name = "BalancesHand.findByUpdateAt", query = "SELECT b FROM BalancesHand b WHERE b.updateAt = :updateAt")})
public class BalancesHand implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CREATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @Column(name = "UPDATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    @JoinColumn(name = "BALANCE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Balance balanceId;
    @JoinColumn(name = "HAND_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Hand handId;

    public BalancesHand() {
    }

    public BalancesHand(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Balance getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(Balance balanceId) {
        this.balanceId = balanceId;
    }

    public Hand getHandId() {
        return handId;
    }

    public void setHandId(Hand handId) {
        this.handId = handId;
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
        if (!(object instanceof BalancesHand)) {
            return false;
        }
        BalancesHand other = (BalancesHand) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.BalancesHand[ id=" + id + " ]";
    }
    
}
