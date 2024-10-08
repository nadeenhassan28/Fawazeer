package com.example.fawazyr.service;

import com.example.fawazyr.data.Winner;
import com.example.fawazyr.data.WinnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class WinnerService {

    private final WinnerRepository winnerRepository;

    @Autowired
    public WinnerService(WinnerRepository winnerRepository) {
        this.winnerRepository = winnerRepository;
    }

    public int checkEligibilityOfWinner(Winner newWinner) {
        Optional<Winner> existingWinner = winnerRepository.findLatestByMsisdn(newWinner.msisdn());

        if (existingWinner.isPresent()) {
            LocalDate lastDate = existingWinner.get().date();

            if (lastDate.equals(LocalDate.now())) {
                return 1; // code 1
            }
        }
        // if eligible the capacity will be checked first
        return 0;
    }

    public void saveWinner(Winner winner){
        winnerRepository.save(new Winner(null, winner.msisdn(), winner.date(),winner.giftId()));
    }
}
