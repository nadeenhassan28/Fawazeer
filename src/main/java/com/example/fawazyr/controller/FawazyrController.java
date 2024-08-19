package com.example.fawazyr.controller;

import com.example.fawazyr.data.*;
import com.example.fawazyr.service.WinnerService;
import com.example.fawazyr.service.GiftsService;
import com.example.fawazyr.service.PrizeHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/fawazyr")
public class FawazyrController {

    private final WinnerService winnerService;
//    private final GiftsService giftsService;
    private final PrizeHistoryService prizeHistoryService;
    private final PrizeHistoryRepository prizeHistoryRepository;

    public FawazyrController(WinnerService winnerService, GiftsService giftsService, PrizeHistoryService prizeHistoryService, PrizeHistoryRepository prizeHistoryRepository) {
        this.winnerService = winnerService;
//        this.giftsService = giftsService;
        this.prizeHistoryService = prizeHistoryService;
        this.prizeHistoryRepository = prizeHistoryRepository;
    }

//    @GetMapping("/winners")
//    public List<Winner> getAllWinners() {
//         return winnerService.getAllWinners();
//    }

//    @GetMapping("/gifts")
//    public List<Gifts> getAllGifts() {
//         return giftsService.getAllGifts();
//    }

//    @GetMapping("/prizeHistories")
//    public List<PrizeHistory> getAllPrizeHistories() {
//         return prizeHistoryService.getAllPrizeHistories();
//    }

    @GetMapping("/redeem")
    public ResponseEntity<String> redeemPrize(@RequestParam("giftId") Integer giftId) {
        int resultCode = prizeHistoryService.checkGiftCapacity(giftId);

        if (resultCode == 2) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Prize reached max capacity");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("Prize redeemed successfully");
        }
    }

    @GetMapping("/redeem-prize")
    public ResponseEntity<String> redeemPrize(@RequestParam("msisdn") String msisdn, @RequestParam("giftId") Integer giftId) {
        Winner newWinner = new Winner(msisdn, LocalDate.now(), giftId);
        int resultCode = winnerService.checkEligibilityOfWinner(newWinner);

        if (resultCode == 1) {
            return ResponseEntity.status(400).body("Not eligible to redeem the prize today.");
        }

        resultCode = prizeHistoryService.checkGiftCapacityAndRedeem(newWinner);

        if (resultCode == 2){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Prize reached mac capacity");
        } else if (resultCode == 3) {
            return ResponseEntity.ok("Prize 1 redeemed successfully");
        } else if (resultCode == 4){
            return ResponseEntity.ok("Prize 2 redeemed successfully");

        }
        winnerService.saveWinner(newWinner);

        int capacityCount= prizeHistoryRepository.incrementCapacity();
        PrizeHistory newprizeHistory =  new PrizeHistory(capacityCount,msisdn,giftId,LocalDate.now());




        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
    }

//    @GetMapping("/redeem-prize") // Nadeen's
//    public ResponseEntity<String> redeemPrize(@RequestParam("code") int code) {
//        return giftsService.redeemPrize(code);
//    }

}
