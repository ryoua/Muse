package com.muse.manager.statistics.controller;

import com.muse.common.model.Result;
import com.muse.manager.statistics.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/24
 **/
@RestController("/api/statistics")
public class StatisticsController {
    @Autowired
    StatisticsService statisticsService;

    @GetMapping("/send/today")
    public Result getSendNumToday() {
        return Result.SUCCESS(statisticsService.sendNumToday());
    }
}
