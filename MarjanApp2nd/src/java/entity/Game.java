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
@Table(name = "GAMES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Game.findAll", query = "SELECT g FROM Game g")
    , @NamedQuery(name = "Game.findById", query = "SELECT g FROM Game g WHERE g.id = :id")
    , @NamedQuery(name = "Game.findByReturnPoint", query = "SELECT g FROM Game g WHERE g.returnPoint = :returnPoint")
    , @NamedQuery(name = "Game.findByStartTime", query = "SELECT g FROM Game g WHERE g.startTime = :startTime")
    , @NamedQuery(name = "Game.findByEndTime", query = "SELECT g FROM Game g WHERE g.endTime = :endTime")
    , @NamedQuery(name = "Game.findByCreateAt", query = "SELECT g FROM Game g WHERE g.createAt = :createAt")
    , @NamedQuery(name = "Game.findByUpdateAt", query = "SELECT g FROM Game g WHERE g.updateAt = :updateAt")})
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RETURN_POINT")
    private int returnPoint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "START_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "END_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Column(name = "CREATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @Column(name = "UPDATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    @JoinColumn(name = "RULE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Rule ruleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gameId")
    private Collection<Balance> balanceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gameId")
    private Collection<GameResult> gameResultCollection;

    public Game() {
    }

    public Game(Integer id) {
        this.id = id;
    }

    public Game(Integer id, int returnPoint, Date startTime, Date endTime) {
        this.id = id;
        this.returnPoint = returnPoint;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getReturnPoint() {
        return returnPoint;
    }

    public void setReturnPoint(int returnPoint) {
        this.returnPoint = returnPoint;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public Rule getRuleId() {
        return ruleId;
    }

    public void setRuleId(Rule ruleId) {
        this.ruleId = ruleId;
    }

    @XmlTransient
    public Collection<Balance> getBalanceCollection() {
        return balanceCollection;
    }

    public void setBalanceCollection(Collection<Balance> balanceCollection) {
        this.balanceCollection = balanceCollection;
    }

    @XmlTransient
    public Collection<GameResult> getGameResultCollection() {
        return gameResultCollection;
    }

    public void setGameResultCollection(Collection<GameResult> gameResultCollection) {
        this.gameResultCollection = gameResultCollection;
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
        if (!(object instanceof Game)) {
            return false;
        }
        Game other = (Game) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Game[ id=" + id + " ]";
    }
    
}
