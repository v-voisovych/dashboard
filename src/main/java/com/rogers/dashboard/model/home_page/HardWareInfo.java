package com.rogers.dashboard.model.home_page;

import com.rogers.dashboard.model.enums.HardWareStatus;

public class HardWareInfo {

    private String name;
    private String model;
    private HardWareStatus hardWareStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public HardWareStatus getHardWareStatus() {
        return hardWareStatus;
    }

    public void setHardWareStatus(HardWareStatus hardWareStatus) {
        this.hardWareStatus = hardWareStatus;
    }
}
