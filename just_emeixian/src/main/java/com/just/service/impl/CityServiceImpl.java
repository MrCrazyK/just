package com.just.service.impl;

import com.just.service.CityService;
import com.just.dao.CityMapper;
import com.just.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by just on 2017/12/4.
 */
@Service("cityService")
public class CityServiceImpl implements CityService{
    @Autowired
    private CityMapper cityMapper;
    @Transactional
    public List<City> selectCity(Integer cityid) {

        return cityMapper.selectSonCities(cityid);
    }


}
