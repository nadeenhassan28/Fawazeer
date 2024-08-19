package com.example.fawazyr.service;

import com.example.fawazyr.data.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PrizeHistoryService {

    private final PrizeHistoryRepository prizeHistoryRepository;
    private final GiftsRepository giftsRepository;
    private final WinnerRepository winnerRepository;
    private final WinnerService winnerService;

    public PrizeHistoryService(PrizeHistoryRepository prizeHistoryRepository, GiftsRepository giftsRepository, WinnerService winnerService, WinnerRepository winnerRepository) {
        this.prizeHistoryRepository = prizeHistoryRepository;
        this.giftsRepository = giftsRepository;
        this.winnerService = winnerService;
        this.winnerRepository = winnerRepository;
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
        Optional<Number> currentCapacity = prizeHistoryRepository.countByGiftId(giftId);

        // Logic based on the giftId and capacity
        if (giftId == 1) {
            if (currentCapacity.get().intValue() >= 2) {
                // If giftId is 1 and capacity is reached, increment giftId to 2 and return code 3
                giftId = 2; //CHECK THIS PART LATER
                return 3; // Prize redeemed successfully, implying next giftId should be used
            } else {
                return 3; // Prize redeemed successfully
            }
        } else if (giftId == 2) {
            if (currentCapacity.get().intValue() >= quantity) {
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

    public int checkGiftCapacityAndRedeem(String msisdn, Integer giftId) {
//        Integer giftId = winner.giftId();
//        String ms = winner.msisdn();
        Optional<Number> currentCapacity = prizeHistoryRepository.countByGiftId(giftId);

        if (currentCapacity.isEmpty()){
           // PrizeHistory newprizeHistory =  new PrizeHistory(1,ms,giftId,LocalDate.now());
            prizeHistoryRepository.save(new PrizeHistory(null,1, msisdn, giftId, LocalDate.now()));
            return 3;

        }


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

//        int capacityCount= prizeHistoryRepository.incrementCapacity(ms);

            // determine gift according to capacity
            if (currentCapacity.get().intValue() < 2){
//                giftId = ;
//                winner.setGiftId(giftId);
                winnerRepository.save(new Winner(null,msisdn,LocalDate.now(),1));
                prizeHistoryRepository.save(new PrizeHistory(null,currentCapacity.get().intValue()+1, msisdn, giftId, LocalDate.now()));
               // winnerService.saveWinner(winner);
                return 3
                        ; // prize 1
            } else if (currentCapacity.get().intValue() < 150) {
//                giftId = 2;
//                winner.setGiftId(giftId);
                winnerRepository.save(new Winner(null,msisdn,LocalDate.now(),2));
                prizeHistoryRepository.save(new PrizeHistory(null,currentCapacity.get().intValue()+1, msisdn, giftId, LocalDate.now()));
                //winnerService.saveWinner(winner);
                return 4; //prize 2 granted
            }

            return 2;
        }



    public void savePrizeHistory(PrizeHistory prizeHistory) {

        prizeHistoryRepository.incrementCapacity(prizeHistory.msisdn());
        int capacityCount= prizeHistoryRepository.incrementCapacity(prizeHistory.msisdn());
        prizeHistoryRepository.save(new PrizeHistory(null,capacityCount,prizeHistory.msisdn(), prizeHistory.giftId(), LocalDate.now()));

    }

    public void deleteContentPrizeHistory() {
        LocalDate del = prizeHistoryRepository.latestEntryPrizeHistory();
        if (LocalDate.now().isAfter(del)) {
            prizeHistoryRepository.deletePrizeHistoryQuery();
        }
    }


    // Add methods
}
