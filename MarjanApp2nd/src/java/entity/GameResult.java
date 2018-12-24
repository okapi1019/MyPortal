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
@Table(name = "GAME_RESULTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GameResult.findAll", query = "SELECT g FROM GameResult g")
    , @NamedQuery(name = "GameResult.findById", query = "SELECT g FROM GameResult g WHERE g.id = :id")
    , @NamedQuery(name = "GameResult.findByGamePoint", query = "SELECT g FROM GameResult g WHERE g.gamePoint = :gamePoint")
    , @NamedQuery(name = "GameResult.findByRank", query = "SELECT g FROM GameResult g WHERE g.rank = :rank")
    , @NamedQuery(name = "GameResult.findByCreateAt", query = "SELECT g FROM GameResult g WHERE g.createAt = :createAt")
    , @NamedQuery(name = "GameResult.findByUpdateAt", query = "SELECT g FROM GameResult g WHERE g.updateAt = :updateAt")})
public class GameResult implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GAME_POINT")
    private int gamePoint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RANK")
    private int rank;
    @Column(name = "CREATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @Column(name = "UPDATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    @JoinColumn(name = "GAME_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Game gameId;
    @JoinColumn(name = "PLAYER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Player playerId;

    public GameResult() {
    }

    public GameResult(Integer id) {
        this.id = id;
    }

    public GameResult(Integer id, int gamePoint, int rank) {
        this.id = id;
        this.gamePoint = gamePoint;
        this.rank = rank;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getGamePoint() {
        return gamePoint;
    }

    public void setGamePoint(int gamePoint) {
        this.gamePoint = gamePoint;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
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

    public Player getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Player playerId) {
        this.playerId = playerId;
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
        if (!(object instanceof GameResult)) {
            return false;
        }
        GameResult other = (GameResult) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.GameResult[ id=" + id + " ]";
    }
    
}
