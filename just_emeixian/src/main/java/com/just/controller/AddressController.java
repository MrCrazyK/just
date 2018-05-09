package com.just.controller;

import com.just.Util.FastJson_All;
import com.just.entity.Address;
import com.just.entity.City;
import com.just.entity.User;
import com.just.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Controller
@RequestMapping("/address")
public class AddressController {

        @Autowired
        private AddressService addressService;
        //为当前用户进行添加地址的操作
        @RequestMapping("/add")
        public void insertAddress(String detailedAddress, String recUser, String phone, Integer cityId, HttpServletResponse response, HttpServletRequest request) {
            City city = new City(cityId);
            User user = (User)request.getSession().getAttribute("currentUser");
            System.out.println(user);
            Address address=new Address(user.getuId(),detailedAddress,recUser,phone, city);
            address.setCity(city);
            addressService.insertAddress(address);
            FastJson_All.toJson("成功",response);
        }
        //根据用户id(session)获取对应用户的地址集合
        //
        @RequestMapping("/select")
        public void selectAddress(HttpServletResponse response,HttpServletRequest request){
            User user = (User)request.getSession().getAttribute("currentUser");
            List<Address> addresses=addressService.selectAddress(user.getuId());
            FastJson_All.toJson(addresses,response);
        }
        //更新用户地址信息
        //需要当前编辑的地址id
        @RequestMapping("/update")
        public void updateAddress(Integer addressId,String detailedAddress,String recUser,String phone,Integer cityId, HttpServletResponse response,HttpServletRequest request) {
            City city = new City(cityId);
            User user = (User)request.getSession().getAttribute("currentUser");
            Address address=new Address(user.getuId(),detailedAddress,recUser,phone, city);
            address.setAddressId(addressId);
            address.setCity(city);
            addressService.updateAddress(address);
            FastJson_All.toJson("成功",response);
        }
        //根据某个用户地址id作删除处理
        @RequestMapping("/delete")
        public void deleteAddress(HttpServletResponse response,Integer addressId) {
            addressService.deleteAddress(addressId);
            FastJson_All.toJson("成功",response);
        }
        //
        @RequestMapping("/selectAddressDid.do")
        public void selectAddressDid(int dId,HttpServletResponse response){
            Address addresses= addressService.selectAddressDid(dId);
            FastJson_All.toJson(addresses,response);
        }
        @RequestMapping("/setAddressDefault")
        public void setDefaultById(int addressId,HttpServletResponse response,HttpServletRequest request) {
            User user = (User) request.getSession().getAttribute("currentUser");
            if (addressService.setDefaultById(addressId, user.getuId())) {
                FastJson_All.toJson("success", response);
            }
            FastJson_All.toJson("success", response);
        }
        @RequestMapping("/SonCity")
        public void selectSonCities(int cityId,HttpServletResponse response){
            FastJson_All.toJson(addressService.selectSonCities(cityId),response);
        }
        //根据地址id选中某个具体的用户地址信息
        @RequestMapping("/CityById")
        public void selectCityById(int cityId,HttpServletResponse response){
            FastJson_All.toJson(addressService.selectCityById(cityId),response);
        }
}
