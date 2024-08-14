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

    public int checkEligibilityAndRedeem(Winner newWinner) {
        Optional<Winner> existingWinner = winnerRepository.findLatestByMsisdn(newWinner.getMsisdn());

        if (existingWinner.isPresent()) {
            LocalDate lastDate = existingWinner.get().getDate();

            if (lastDate.equals(LocalDate.now())) {
                return 1; // code 1
            } else {
                // insert new entry with the current date
                winnerRepository.save(newWinner);
                return 0; // eligible but need to check the capacity first
            }
        } else {
            // insert new entry
            winnerRepository.save(newWinner);
            return 0; // eligible but need to check the capacity first
        }
    }
}
