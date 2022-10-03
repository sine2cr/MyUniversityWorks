package com.govhub.controller;

import com.govhub.domain.City;
import com.govhub.service.CityService;
import com.govhub.util.CitySort;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Sin
 * @date 2022/7/29
 */
@RestController
@RequestMapping("/citys")
@Slf4j
public class CityController {
    @Autowired
    private CityService cityService;

    @PostMapping("getByUrl")
    @ResponseBody
    public City getByUrl(@RequestParam("city") String city, @RequestBody String url) {
        log.info("");
        City result = cityService.getByUrl(city, url);
        return result;
    }

    @RequestMapping("getByDate")
    @ResponseBody
    public List<City> getByDate(@RequestHeader("city") String city,
                                @RequestHeader("time") @DateTimeFormat(pattern = "yyyy-MM-dd") Date time) {
        List<City> result = cityService.getByDate(city, time);
        return result;
    }

    @RequestMapping("getByTimeQuantum")
    @ResponseBody
    public List<City> getByTimeQuantum(@RequestHeader("city") String city,
                                       @RequestHeader("startTime") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startTime,
                                       @RequestHeader("endTime") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime) {
        List<City> result = cityService.getByTimeQuantum(city, startTime, endTime);

        return result;
    }

    @RequestMapping("getAll")
    @ResponseBody
    public List<City> getAll(@RequestHeader("city") String city) {
        List<City> result = cityService.getAll(city);

        return result;
    }

    // TODO: 2022/7/29 删除功能暂时不实现

//    public City delectByUrl(String city, String url) {
//        System.out.println("暂时不实现");
//        return null;
//    }
//    @DeleteMapping
//    public List<City> delectByDate(String city, Date time) {
//        System.out.println("暂时不实现");
//
//        return null;
//    }
//    @DeleteMapping
//    public List<City> delectAll(String city) {
//        System.out.println("暂时不实现");
//
//        return null;
//    }

}
