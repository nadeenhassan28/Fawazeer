package com.example.fawazyr.service;

import com.example.fawazyr.data.Gifts;
import com.example.fawazyr.data.GiftsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class GiftsService {

    private final GiftsRepository giftsRepository;

    public GiftsService(GiftsRepository giftsRepository) {
        this.giftsRepository = giftsRepository;
    }

    public List<Gifts> getAllGifts() {
         return (List<Gifts>) giftsRepository.findAll(); //adjust this
    }


    public ResponseEntity<String> redeemPrize(int code) {
        switch (code) {
            case 1:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Maximum one prize per day");

            case 2:
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Prize reached max capacity");

            case 3:
                return ResponseEntity.status(HttpStatus.OK)
                        .body("Prize redeemed successfully");

            default:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Invalid request code");
        }
    }

    // Add methods
}
