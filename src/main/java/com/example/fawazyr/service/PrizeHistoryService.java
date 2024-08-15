package com.example.fawazyr.service;

import com.example.fawazyr.data.GiftsRepository;
import com.example.fawazyr.data.PrizeHistory;
import com.example.fawazyr.data.PrizeHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrizeHistoryService {

    private final PrizeHistoryRepository prizeHistoryRepository;
    private final GiftsRepository giftsRepository;

    public PrizeHistoryService(PrizeHistoryRepository prizeHistoryRepository, GiftsRepository giftsRepository) {
        this.prizeHistoryRepository = prizeHistoryRepository;
        this.giftsRepository = giftsRepository;
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
        Long currentCapacity = prizeHistoryRepository.countByGiftId(giftId);

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
                return 3; // Prize redeemed successfully
            }
        } else {
            // Handle any other giftId values, assuming they should succeed
            return 3; // Default case for other giftIds
        }
    }


    // Add methods
}
