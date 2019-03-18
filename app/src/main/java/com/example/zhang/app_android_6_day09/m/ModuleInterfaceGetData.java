package com.example.zhang.app_android_6_day09.m;

import com.example.zhang.app_android_6_day09.Data.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ModuleInterfaceGetData {

    //http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1
    @GET("{path}")
    Observable<Bean> getData(@Path("path") String path, @Query("stage_id") String stage_id,
                             @Query("limit") String limit,@Query("page") String page);

}
