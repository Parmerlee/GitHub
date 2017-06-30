package com.demo.github.Retrofit;

import org.json.JSONObject;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2017/6/29.
 */

public interface HttpApi {
    // https://api.douban.com/v2/movie/top250?start=0&count=10
    @GET("top250")
    Call<MovieBean> getTopMovie(@Query("start") int start, @Query("count") int count);

    @GET("/sysUser/getVersion")
    Call<JSONObject> getUserInfo(@QueryMap Map<String, String> map);
}
