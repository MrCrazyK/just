package com.just.service;

import com.just.entity.Address;
import com.just.entity.City;

import java.util.List;

public interface AddressService {

    //选择城市
    public List<City> selectSonCities(int cityId);
    public City selectCityById(int cityId);
    //地址部分
    public  void insertAddress(Address address);
    public List<Address> selectAddress(int uId);
    public void deleteAddress(Integer dId);
    public Address selectAddressDid(int dId);
    public void updateAddress(Address address);
    public boolean setDefaultById(int addressId,int uId);
}
