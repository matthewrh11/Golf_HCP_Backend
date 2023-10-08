package com.golf_hdcp.mhghexp.model;

import javax.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Long id;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "handicap")
    private double handicap;

    @OneToMany(mappedBy = "player")
    @JsonManagedReference
    private List<GolfScore> scores;

    // Constructors, getters, setters
    public Player() {
    }

    public Player(String playerName, double handicap) {
        this.playerName = playerName;
        this.handicap = handicap;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public double getHandicap() {
        return handicap;
    }

    public void setHandicap(double handicap) {
        this.handicap = handicap;
    }

    public List<GolfScore> getScores() {
        return scores;
    }

    public void setScores(List<GolfScore> scores) {
        this.scores = scores;
    }
}
