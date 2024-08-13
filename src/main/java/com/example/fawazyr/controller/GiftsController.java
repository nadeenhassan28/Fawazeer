package com.example.fawazyr.controller;

import com.example.fawazyr.data.Gifts;
import com.example.fawazyr.service.GiftsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gifts")
public class GiftsController {

    private final GiftsService giftsService;

    public GiftsController(GiftsService giftsService) {
        this.giftsService = giftsService;
    }

    @GetMapping
    public List<Gifts> getAllGifts() {
         return giftsService.getAllGifts();// adjust this
    }

}
