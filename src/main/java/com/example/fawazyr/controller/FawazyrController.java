package com.example.fawazyr.controller;

import com.example.fawazyr.data.*;
import com.example.fawazyr.service.WinnerService;
import com.example.fawazyr.service.GiftsService;
import com.example.fawazyr.service.PrizeHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fawazyr")
public class FawazyrController {

    private final WinnerService winnerService;
    private final GiftsService giftsService;
    private final PrizeHistoryService prizeHistoryService;

    public FawazyrController(WinnerService winnerService, GiftsService giftsService, PrizeHistoryService prizeHistoryService) {
        this.winnerService = winnerService;
        this.giftsService = giftsService;
        this.prizeHistoryService = prizeHistoryService;
    }

    // All the return values are just to avoid errors still haven't started in the logics of the code
    @GetMapping("/winners")
    public List<Winner> getAllWinners() {
         return winnerService.getAllWinners();
    }

    @GetMapping("/gifts")
    public List<Gifts> getAllGifts() {
         return giftsService.getAllGifts();
    }

    @GetMapping("/prizeHistories")
    public List<PrizeHistory> getAllPrizeHistories() {
         return prizeHistoryService.getAllPrizeHistories();
    }

    @GetMapping("/redeem-prize")
    public ResponseEntity<String> redeemPrize(@RequestParam("code") int code) {
        return giftsService.redeemPrize(code);
    }

}
