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
@Table(name = "PLAYERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p")
    , @NamedQuery(name = "Player.findById", query = "SELECT p FROM Player p WHERE p.id = :id")
    , @NamedQuery(name = "Player.findByName", query = "SELECT p FROM Player p WHERE p.name = :name")
    , @NamedQuery(name = "Player.findByCreateAt", query = "SELECT p FROM Player p WHERE p.createAt = :createAt")
    , @NamedQuery(name = "Player.findByUpdateAt", query = "SELECT p FROM Player p WHERE p.updateAt = :updateAt")})
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NAME")
    private String name;
    @Column(name = "CREATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @Column(name = "UPDATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loserId")
    private Collection<Balance> balanceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "winnerId")
    private Collection<Balance> balanceCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "playerId")
    private Collection<GameResult> gameResultCollection;

    public Player() {
    }

    public Player(Integer id) {
        this.id = id;
    }

    public Player(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @XmlTransient
    public Collection<Balance> getBalanceCollection1() {
        return balanceCollection1;
    }

    public void setBalanceCollection1(Collection<Balance> balanceCollection1) {
        this.balanceCollection1 = balanceCollection1;
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
        if (!(object instanceof Player)) {
            return false;
        }
        Player other = (Player) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Player[ id=" + id + " ]";
    }
    
}
