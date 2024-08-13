package com.example.fawazyr.service;

import com.example.fawazyr.data.Winner;
import com.example.fawazyr.data.WinnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WinnerService {

    private final WinnerRepository winnerRepository;

    public WinnerService(WinnerRepository winnerRepository) {
        this.winnerRepository = winnerRepository;
    }

    public List<Winner> getAllWinners() {
         return (List<Winner>) winnerRepository.findAll(); // adjust this
    }

    // Add methods
}
