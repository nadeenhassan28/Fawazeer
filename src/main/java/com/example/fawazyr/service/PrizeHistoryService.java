package com.example.fawazyr.service;

import com.example.fawazyr.data.PrizeHistory;
import com.example.fawazyr.data.PrizeHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrizeHistoryService {

    private final PrizeHistoryRepository prizeHistoryRepository;

    public PrizeHistoryService(PrizeHistoryRepository prizeHistoryRepository) {
        this.prizeHistoryRepository = prizeHistoryRepository;
    }

    public List<PrizeHistory> getAllPrizeHistories() {
         return (List<PrizeHistory>) prizeHistoryRepository.findAll(); // adjust this
    }

    // Add methods
}
