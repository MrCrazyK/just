package com.just.service;

import com.just.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by just on 2017/12/4.
 */

public interface CityService {
    public List<City> selectCity(Integer city);


}
