package com.sminizen.eco.eco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sminizen.eco.eco.common.ApiResponse;
import com.sminizen.eco.eco.repository.PhorismsRepository;

@RestController
@RequestMapping("/api")
public class PhorismsController {

    @Autowired
    private PhorismsRepository phorismsRepository;

    @GetMapping("/phorisms/{id}")
    public ApiResponse show(@PathVariable int id) {
        return new ApiResponse(
            200,
            "success",
            phorismsRepository.findById(id)
        );
    }

    @GetMapping("/phorisms/rand")
    public ApiResponse showByRandom() {
        return new ApiResponse(
            200,
            "success",
            phorismsRepository.findByRandom()
        );
    }
}
