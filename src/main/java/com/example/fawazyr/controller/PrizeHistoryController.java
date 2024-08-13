package com.example.fawazyr.controller;

import com.example.fawazyr.data.PrizeHistory;
import com.example.fawazyr.service.PrizeHistoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prizeHistory")
public class PrizeHistoryController {

    private final PrizeHistoryService prizeHistoryService;

    public PrizeHistoryController(PrizeHistoryService prizeHistoryService) {
        this.prizeHistoryService = prizeHistoryService;
    }

    @GetMapping
    public List<PrizeHistory> getAllPrizeHistories() {
         return prizeHistoryService.getAllPrizeHistories(); // adjust this
    }

}
