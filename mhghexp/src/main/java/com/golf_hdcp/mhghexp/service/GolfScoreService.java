package com.golf_hdcp.mhghexp.service;

import com.golf_hdcp.mhghexp.model.GolfScore;
import com.golf_hdcp.mhghexp.repository.GolfScoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GolfScoreService {

    private final GolfScoreRepository golfScoreRepository;

    public GolfScoreService(GolfScoreRepository golfScoreRepository) {
        this.golfScoreRepository = golfScoreRepository;
    }

    public List<GolfScore> getAllGolfScores() {
        return golfScoreRepository.findAll();
    }

    public GolfScore createGolfScore(GolfScore golfScore) {
        return golfScoreRepository.save(golfScore);
    }

    public List<GolfScore> getGolfScoresByPlayerName(String playerName) {
        return golfScoreRepository.findByPlayer_PlayerName(playerName);
    }
}
