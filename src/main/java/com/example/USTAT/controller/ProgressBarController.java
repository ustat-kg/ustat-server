package com.example.USTAT.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ProgressBarController.URL_PROGRESS_BAR)
public class ProgressBarController {

    public static final String URL_PROGRESS_BAR = "/ustat/progressBar/";
    
}
