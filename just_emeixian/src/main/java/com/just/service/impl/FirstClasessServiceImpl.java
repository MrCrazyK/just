//package com.just.service.impl;
//
//import com.just.service.FirstClasessService;
//import com.just.dao.FirstClasessMapper;
//import com.just.entity.FirstClasess;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
///**
// * Created by just on 2017/12/8.
// */
//
//@Service("firstClasessService")
//public class FirstClasessServiceImpl implements FirstClasessService {
//
//    @Autowired
//    private FirstClasessMapper firstClasessMapper;
//
//
//    public List<FirstClasess> findsParendIdAndPage(int classId, int pages) {
//        System.out.println("classid:"+classId);
//        System.out.println("pages:"+pages);
//        List<FirstClasess> firstClasesses = firstClasessMapper.findsClasess(classId,pages);
//
//        return firstClasesses;
//    }
//}
////