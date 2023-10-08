package com.golf_hdcp.mhghexp.repository;

import com.golf_hdcp.mhghexp.model.GolfScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GolfScoreRepository extends JpaRepository<GolfScore, Long> {
    List<GolfScore> findByPlayer_PlayerName(String playerName);
}
