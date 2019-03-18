package com.example.zhang.app_android_6_day09.m;

import com.example.zhang.app_android_6_day09.Data.Bean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ModuleData {

    private List<Bean> list = new ArrayList<>();
    private ModluieInterface modluieInterface;

    public ModuleData(ModluieInterface modluieInterface) {
        this.modluieInterface = modluieInterface;
    }

    public void getData(){
        //http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.qubaobei.com/ios/cf/")
                .addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        retrofit.create(ModuleInterfaceGetData.class)
                .getData("dish_list.php","1","20","1")
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Bean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Bean bean) {
                list.add(bean);
                modluieInterface.LoadSucceed(list);

            }

            @Override
            public void onError(Throwable e) {
                modluieInterface.LoadFailed();

            }

            @Override
            public void onComplete() {

            }
        });


    }

}
