package com.example.fawazyr.service;

import com.example.fawazyr.data.Gifts;
import com.example.fawazyr.data.GiftsRepository;
import org.springframework.stereotype.Service;

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

    // Add methods
}
