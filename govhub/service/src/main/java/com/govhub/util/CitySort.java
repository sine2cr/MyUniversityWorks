package com.govhub.util;

import com.govhub.domain.City;

import java.util.Comparator;

/**
 * @author Sin
 * @date 2022/9/8
 */
public class CitySort implements Comparator<City> {




    @Override
    public int compare(City o1, City o2) {

        if (o2.getTime().equals(o1.getTime())){
            return 0;
        }else if (o2.getTime().after(o1.getTime())){
            return -1;
        }
        return 1;
    }
}
