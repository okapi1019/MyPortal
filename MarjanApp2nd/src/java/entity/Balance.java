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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author masaki
 */
@Entity
@Table(name = "BALANCES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Balance.findAll", query = "SELECT b FROM Balance b")
    , @NamedQuery(name = "Balance.findById", query = "SELECT b FROM Balance b WHERE b.id = :id")
    , @NamedQuery(name = "Balance.findByGetPoint", query = "SELECT b FROM Balance b WHERE b.getPoint = :getPoint")
    , @NamedQuery(name = "Balance.findByIsSelfWin", query = "SELECT b FROM Balance b WHERE b.isSelfWin = :isSelfWin")
    , @NamedQuery(name = "Balance.findByIsNoCall", query = "SELECT b FROM Balance b WHERE b.isNoCall = :isNoCall")
    , @NamedQuery(name = "Balance.findByHandPoint", query = "SELECT b FROM Balance b WHERE b.handPoint = :handPoint")
    , @NamedQuery(name = "Balance.findByHandTypePoint", query = "SELECT b FROM Balance b WHERE b.handTypePoint = :handTypePoint")
    , @NamedQuery(name = "Balance.findByCreateAt", query = "SELECT b FROM Balance b WHERE b.createAt = :createAt")
    , @NamedQuery(name = "Balance.findByUpdateAt", query = "SELECT b FROM Balance b WHERE b.updateAt = :updateAt")})
public class Balance implements Serializable {

    @JoinColumn(name = "TURN_ID", referencedColumnName = "ID")
    @ManyToOne
    private Turn turnId;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GET_POINT")
    private int getPoint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IS_SELF_WIN")
    private Boolean isSelfWin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IS_NO_CALL")
    private Boolean isNoCall;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HAND_POINT")
    private int handPoint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HAND_TYPE_POINT")
    private int handTypePoint;
    @Column(name = "CREATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @Column(name = "UPDATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    @JoinColumn(name = "GAME_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Game gameId;
    @JoinColumn(name = "LOSER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Player loserId;
    @JoinColumn(name = "WINNER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Player winnerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "balanceId")
    private Collection<BalancesHand> balancesHandCollection;

    public Balance() {
    }

    public Balance(Integer id) {
        this.id = id;
    }

    public Balance(Integer id, int getPoint, Boolean isSelfWin, Boolean isNoCall, int handPoint, int handTypePoint) {
        this.id = id;
        this.getPoint = getPoint;
        this.isSelfWin = isSelfWin;
        this.isNoCall = isNoCall;
        this.handPoint = handPoint;
        this.handTypePoint = handTypePoint;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getGetPoint() {
        return getPoint;
    }

    public void setGetPoint(int getPoint) {
        this.getPoint = getPoint;
    }

    public Boolean getIsSelfWin() {
        return isSelfWin;
    }

    public void setIsSelfWin(Boolean isSelfWin) {
        this.isSelfWin = isSelfWin;
    }

    public Boolean getIsNoCall() {
        return isNoCall;
    }

    public void setIsNoCall(Boolean isNoCall) {
        this.isNoCall = isNoCall;
    }

    public int getHandPoint() {
        return handPoint;
    }

    public void setHandPoint(int handPoint) {
        this.handPoint = handPoint;
    }

    public int getHandTypePoint() {
        return handTypePoint;
    }

    public void setHandTypePoint(int handTypePoint) {
        this.handTypePoint = handTypePoint;
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

    public Game getGameId() {
        return gameId;
    }

    public void setGameId(Game gameId) {
        this.gameId = gameId;
    }

    public Player getLoserId() {
        return loserId;
    }

    public void setLoserId(Player loserId) {
        this.loserId = loserId;
    }

    public Player getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(Player winnerId) {
        this.winnerId = winnerId;
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
        if (!(object instanceof Balance)) {
            return false;
        }
        Balance other = (Balance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Balance[ id=" + id + " ]";
    }

    public Turn getTurnId() {
        return turnId;
    }

    public void setTurnId(Turn turnId) {
        this.turnId = turnId;
    }
    
}
