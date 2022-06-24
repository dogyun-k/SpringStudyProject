package com.study.board.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.study.board.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;

@RequiredArgsConstructor
@RestController
public class LogController {

    private final LogService logService;

    @GetMapping("/log")
    public void log() throws JsonProcessingException, UnknownHostException {
        logService.log();
    }

}
