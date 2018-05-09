package com.just.service;

import com.just.entity.LBT;

import java.util.List;

public interface LBTService {
    public LBT selectLBTById(Integer pId);
    public List<LBT> selectAll();

    public boolean updateAllById(LBT lbt);
    public boolean updateUrlById(LBT lbt);
    public boolean updateNameById(LBT lbt);
    public boolean UPIt(int lbtId);
    public boolean DOWNIt(int lbtId);
    public boolean newLbt(LBT lbt);

}
