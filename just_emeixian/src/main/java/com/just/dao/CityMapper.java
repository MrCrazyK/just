package com.just.dao;

import com.just.entity.City;

import java.util.List;

public interface CityMapper {
    public List<City> selectSonCities(int cityId);
    public City selectCityById(int cityId);
}
