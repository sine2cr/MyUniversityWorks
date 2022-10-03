package com.govhub.controller;

import com.govhub.domain.News;
import com.govhub.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Sin
 * @date 2022/8/23
 */
@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;


    @RequestMapping("getByDate")
    @ResponseBody
    public List<News> getByDate(@RequestHeader("city") String city,
                                @RequestHeader("time") @DateTimeFormat(pattern = "yyyy-MM-dd") Date time) {
        List<News> result = newsService.getByDate(city, time);
        return result;
    }

    @RequestMapping("getByTimeQuantum")
    @ResponseBody
    public List<News> getByTimeQuantum(@RequestHeader("city") String city,
                                       @RequestHeader("startTime") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startTime,
                                       @RequestHeader("endTime") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime) {
        List<News> result = newsService.getByTimeQuantum(city, startTime, endTime);
        return result;
    }

    @RequestMapping("getAll")
    @ResponseBody
    public List<News> getAll(@RequestHeader("city") String city) {
        List<News> result = newsService.getAll(city);

        return result;
    }

}
