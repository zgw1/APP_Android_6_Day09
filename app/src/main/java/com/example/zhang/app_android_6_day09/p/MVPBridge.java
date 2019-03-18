package com.example.zhang.app_android_6_day09.p;

import com.example.zhang.app_android_6_day09.Data.Bean;
import com.example.zhang.app_android_6_day09.m.ModluieInterface;
import com.example.zhang.app_android_6_day09.m.ModuleData;
import com.example.zhang.app_android_6_day09.v.MVPView;

import java.util.List;

public class MVPBridge implements ModluieInterface {

    private ModuleData data = new ModuleData(this);
    private MVPView mvpView;

    public MVPBridge(MVPView mvpView) {
        this.mvpView = mvpView;
    }

    public void handleData(){
        data.getData();

    }

    @Override
    public void LoadSucceed(List<Bean> list) {
        mvpView.setListItem(list);

    }

    @Override
    public void LoadFailed() {

    }
}
