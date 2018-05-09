package com.just.dao;

import com.just.entity.LBT;

import java.util.List;

public interface LBTMapper {


    //public boolean updaterUrl(LBT lbt);

    public LBT selectLBTById(Integer pId);
    public List<LBT> selectAll();

    public boolean updateAllById(LBT lbt);
    public boolean updateUrlById(LBT lbt);
    public boolean updateNameById(LBT lbt);
    public boolean UPId(LBT lbt);
    public boolean newLbt(LBT lbt);

    public int countLbt();





}
