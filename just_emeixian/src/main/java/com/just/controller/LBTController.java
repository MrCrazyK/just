package com.just.controller;

import com.just.Util.FastJson_All;
import com.just.entity.LBT;
import com.just.service.LBTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
@Controller
@RequestMapping("/LBT")
public class LBTController {
    @Autowired
    private LBTService lbtService;
    @RequestMapping("/byId")
    public void selectLBTById(Integer pId, HttpServletResponse response){
        FastJson_All.toJson(lbtService.selectLBTById(pId),response);

    }
    @RequestMapping("/showAll")
    public void selectAll(HttpServletResponse response){
        FastJson_All.toJson(lbtService.selectAll(),response);
    }
    @RequestMapping("/updateThis")
    public void updateAllById(LBT lbt, HttpServletResponse response){
        lbtService.updateAllById(lbt);
        FastJson_All.toJson("success",response);
    }
    @RequestMapping("/updateUrl")
    public void updateUrlById(LBT lbt,HttpServletResponse response){
        lbtService.updateUrlById(lbt);
        FastJson_All.toJson("success",response);
    }
    @RequestMapping("/updateName")
    public void updateNameById(LBT lbt,HttpServletResponse response){
        lbtService.updateNameById(lbt);
        FastJson_All.toJson("success",response);
    }
    @RequestMapping("/UPUP")
    public void UPIt(int lbtId,HttpServletResponse response){
        lbtService.UPIt(lbtId);
        FastJson_All.toJson("success",response);
    }
    @RequestMapping("/DOWN")
    public void DOWNIt(int lbtId,HttpServletResponse response){
        lbtService.DOWNIt(lbtId);
        FastJson_All.toJson("success",response);
    }
    @RequestMapping("/addNew")
    public void newLbt(LBT lbt,HttpServletResponse response){
        lbtService.newLbt(lbt);
        FastJson_All.toJson("success",response);
    }

}
