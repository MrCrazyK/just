package com.just.dao;

import com.just.entity.Address;

import java.util.List;

public interface AddressMapper {


    public void insertAddress(Address address);
    public List<Address> selectAddress(int uId);
    public void deleteAddress(Integer dId);
    public void updateAddress(Address address);
    public boolean setDefaultById(int addressId);
    public boolean disDefaultByUser(int uId);

    public Address selectAddressDid(int dId);

}
