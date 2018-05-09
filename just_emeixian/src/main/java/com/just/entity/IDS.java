package com.just.entity;

import java.util.List;

/**
 * Created by just on 2017/12/9.
 */
public class IDS {
    //数组实体类,用于接收前端数组对象
    private List<Integer> Ids;
    private List<Integer> Ids2;

    @Override
    public String toString() {
        return "IDS{" +
                "Ids=" + Ids +
                ", Ids2=" + Ids2 +
                '}';
    }

    public List<Integer> getIds2() {
        return Ids2;
    }

    public void setIds2(List<Integer> ids2) {
        Ids2 = ids2;
    }

    public List<Integer> getIds() {
        return Ids;
    }

    public void setIds(List<Integer> Ids) {
        this.Ids = Ids;
    }

}