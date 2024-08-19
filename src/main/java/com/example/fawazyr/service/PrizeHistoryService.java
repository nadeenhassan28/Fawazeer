package com.example.fawazyr.service;

import com.example.fawazyr.data.GiftsRepository;
import com.example.fawazyr.data.PrizeHistory;
import com.example.fawazyr.data.PrizeHistoryRepository;
import com.example.fawazyr.data.Winner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrizeHistoryService {

    private final PrizeHistoryRepository prizeHistoryRepository;
    private final GiftsRepository giftsRepository;
    private final WinnerService winnerService;

    public PrizeHistoryService(PrizeHistoryRepository prizeHistoryRepository, GiftsRepository giftsRepository, WinnerService winnerService) {
        this.prizeHistoryRepository = prizeHistoryRepository;
        this.giftsRepository = giftsRepository;
        this.winnerService = winnerService;
    }

    public List<PrizeHistory> getAllPrizeHistories() {
         return (List<PrizeHistory>) prizeHistoryRepository.findAll(); // adjust this
    }

    public int checkGiftCapacity(Integer giftId) {
        // Get the  quantity from the gifts table
        Integer quantity = giftsRepository.findQuantityByGiftId(giftId);

        if (quantity == null) {
            throw new IllegalArgumentException("Gift ID " + giftId + " does not exist.");
        }

        // Get the capacity from ph table
        int currentCapacity = prizeHistoryRepository.countByGiftId(giftId);

        // Logic based on the giftId and capacity
        if (giftId == 1) {
            if (currentCapacity >= quantity) {
                // If giftId is 1 and capacity is reached, increment giftId to 2 and return code 3
                giftId = 2; //CHECK THIS PART LATER
                return 3; // Prize redeemed successfully, implying next giftId should be used
            } else {
                return 3; // Prize redeemed successfully
            }
        } else if (giftId == 2) {
            if (currentCapacity >= quantity) {
                // If giftId is 2 and capacity is reached, return code 2
                return 2; // Prize reached max capacity
            } else {
                return 4; // Prize redeemed successfully (code 4)
            }
        } else {
            // Handle any other giftId values, assuming they should succeed
            return 3; // Default case for other giftIds
        }
    }

    public int checkGiftCapacityAndRedeem(Winner winner){
        Integer giftId = winner.getGiftId();
        int currentCapacity = prizeHistoryRepository.countByGiftId(giftId);

        // Nadeen's
        // Get the  quantity from the gifts table
//        Integer quantity = giftsRepository.findQuantityByGiftId(giftId);
//        if (quantity == null) {
//            throw new IllegalArgumentException("Gift ID " + giftId + " does not exist.");
//        }
//
//        //check and determine range
//        if (currentCapacity >= quantity){
//            return 2; //prize reached max capacity
//        }

        // determine gift according to capacity
        if (currentCapacity < 2){
            giftId = 1;
            winner.setGiftId(giftId);
            prizeHistoryRepository.save(new PrizeHistory(currentCapacity+1, winner.getMsisdn(), giftId, LocalDate.now()));
            winnerService.saveWinner(winner);
            return 3
                    ; // prize 1
        } else if (currentCapacity < 150) {
            giftId = 2;
            winner.setGiftId(giftId);
            prizeHistoryRepository.save(new PrizeHistory(currentCapacity+1, winner.getMsisdn(), giftId, LocalDate.now()));
            winnerService.saveWinner(winner);
            return 4; //prize 2 granted
        }

        return 2;
    }


    // Add methods
}
