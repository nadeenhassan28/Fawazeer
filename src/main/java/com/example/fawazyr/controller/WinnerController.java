//package com.example.fawazyr.controller;
//
//import com.example.fawazyr.data.Winner;
//import com.example.fawazyr.service.WinnerService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/winners")
//public class WinnerController {
//
//    private final WinnerService winnerService;
//
//    public WinnerController(WinnerService winnerService) {
//        this.winnerService = winnerService;
//    }
//
//    @GetMapping
//    public List<Winner> getAllWinners() {
//         return winnerService.getAllWinners(); //adjust this
//    }
//
//}
