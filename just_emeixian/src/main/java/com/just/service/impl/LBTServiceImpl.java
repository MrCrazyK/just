package com.just.service.impl;

import com.just.dao.LBTMapper;
import com.just.entity.LBT;
import com.just.service.LBTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("lbtService")
public class LBTServiceImpl implements LBTService {
    @Autowired
    private LBTMapper lbtMapper;

    public LBT selectLBTById(Integer pId) {
        return lbtMapper.selectLBTById(pId);
    }


    public List<LBT> selectAll() {
        return lbtMapper.selectAll();
    }


    public boolean updateAllById(LBT lbt) {
        return lbtMapper.updateAllById(lbt);
    }


    public boolean updateUrlById(LBT lbt) {
        return updateUrlById(lbt);
    }


    public boolean updateNameById(LBT lbt) {
        return updateNameById(lbt);
    }


    public boolean UPIt(int lbtId) {
        int count = lbtMapper.countLbt();
        LBT lbt = new LBT();
        lbt.setLbtId(lbtId);
        lbt.setpId(count + 1);
        lbtMapper.UPId(lbt);

        LBT top = new LBT();
        top.setLbtId(lbtId - 1);
        top.setpId(lbtId);
        lbtMapper.UPId(top);

        lbt.setLbtId(count + 1);
        lbt.setpId(lbtId - 1);
        lbtMapper.UPId(lbt);
        return true;
    }


    public boolean DOWNIt(int lbtId) {
        int count = lbtMapper.countLbt();
        LBT lbt = new LBT();
        lbt.setLbtId(lbtId);
        lbt.setpId(count + 1);
        lbtMapper.UPId(lbt);

        LBT down = new LBT();
        down.setLbtId(lbtId + 1);
        down.setpId(lbtId);
        lbtMapper.UPId(down);

        lbt.setLbtId(count + 1);
        lbt.setpId(lbtId + 1);
        lbtMapper.UPId(lbt);
        return true;
    }


    public boolean newLbt(LBT lbt) {
        lbt.setLbtId(lbtMapper.countLbt()+1);
        return lbtMapper.newLbt(lbt);
    }
}
