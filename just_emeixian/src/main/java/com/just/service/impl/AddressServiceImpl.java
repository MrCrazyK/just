package com.just.service.impl;

import com.just.dao.AddressMapper;
import com.just.dao.CityMapper;
import com.just.entity.Address;
import com.just.entity.City;
import com.just.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("addressService")
public class AddressServiceImpl implements AddressService {
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private AddressMapper addressMapper;
    //根据传入的城市id获取下一级城市单位目录
    public List<City> selectSonCities(int cityId) {
        return cityMapper.selectSonCities(cityId);
    }
    //根据传入的某一个id查看当前的城市信息
    public City selectCityById(int cityId) {
        return cityMapper.selectCityById(cityId);
    }
    //插入新的城市
    public void insertAddress(Address address) {
        addressMapper.insertAddress(address);
    }
    //根据某个用户的id选中该用户的所有收货地址
    public List<Address> selectAddress(int uId) {
        List<Address> addresses= addressMapper.selectAddress(uId);
        return  addresses;
    }
    //根据地址id删除某个id
    //后期应新增用户判断,非当前用户地址不予删除
    public void deleteAddress(Integer dId) {
        addressMapper.deleteAddress(dId);
    }
    public Address selectAddressDid(int dId) {
        Address address= (Address) addressMapper.selectAddressDid(dId);
        return  address;
    }
    //根据地址id更新地址的一系列信息
    public void updateAddress(Address address) {
        addressMapper.updateAddress(address);
    }
    //将某个用户的某条地址选为默认地址
    @Transactional
    public boolean setDefaultById(int addressId,int uId){
        addressMapper.disDefaultByUser(uId);
        return addressMapper.setDefaultById(addressId);
    }
}
