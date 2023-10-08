package com.golf_hdcp.mhghexp.model;

import javax.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name = "golf_scores")
public class GolfScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "score_id")
    private Long id;

    @ManyToOne // Assuming a Many-to-One relationship with Player
    @JoinColumn(name = "player_id")
    @JsonBackReference
    private Player player;

    @Column(name = "score")
    private Integer score;

    @Column(name = "score_date")
    private java.sql.Timestamp scoreDate;

    // Constructors, getters, setters
    public GolfScore() {
    }

    public GolfScore(Player player, int score, java.sql.Timestamp scoreDate) {
        this.player = player;
        this.score = score;
        this.scoreDate = scoreDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public java.sql.Timestamp getScoreDate() {
        return scoreDate;
    }

    public void setScoreDate(java.sql.Timestamp scoreDate) {
        this.scoreDate = scoreDate;
    }
}
