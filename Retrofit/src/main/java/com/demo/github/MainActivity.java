package com.demo.github;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.demo.github.Retrofit.BaseCallBack;
import com.demo.github.Retrofit.DES;
import com.demo.github.Retrofit.MovieBean;
import com.demo.github.Retrofit.HttpApi;
import com.demo.github.Retrofit.UpdateBean;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        getMovie();
    }

    private void getMovie() {
        System.out.println("AAAAAAA");
//        String baserUrl = "https://api.douban.com/v2/movie/";
        String baserUrl = "http://120.202.17.126:8070/";
//        https://api.douban.com/v2/movie/top250?start=0&count=10

        Retrofit retrofit = new Retrofit.Builder().baseUrl(baserUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HttpApi service = retrofit.create(HttpApi.class);

//        Call<MovieBean> call = service.getTopMovie(0, 10);
//        System.out.println("call1:" + call.hashCode());
//
//        call.enqueue(new BaseCallBack<MovieBean>() {
//            @Override
//            public void onSuccess(Response<MovieBean> response) {
//                System.out.println("call2:" + response.body().getSubjects().size());
//            }
//
//            public void onFailed(Throwable t) {
//                t.printStackTrace();
//            }
//        });

        Map<String, String> param = new HashMap<>();
        param.put("version", "1");
        param.put("term", "ANDROID_ADVANCE");
        param.put("os", "android");
        param.put("termType", "android");

        Call<JSONObject> call1 = service.getUserInfo(param);
        call1.enqueue(new BaseCallBack<JSONObject>() {
            @Override
            public void onSuccess(JSONObject response) {
                System.out.println("call2:" + response.toString());
            }

        });
    }


    public static void main(String[] arg) {

        System.out.println("30年 2000元，0.04 totle:" + Sum(30, 2000, 0.04));
        System.out.println("30年 2000元，0.02 totle:" + Sum(30, 2000, 0.02));


    }

    static double Sum(int year, int money, double a) {
        double sum = 0;
//        System.out.println("totle2:" + Math.pow(1 + a, Double.valueOf(year)));
//        sum = ((money / (-a)) * (1 - Math.pow(1 + a, Double.valueOf(year))));
        for (int i = 0; i < year; i++) {
            sum += money * Math.pow((1 + a), i);
        }
        return sum;
    }
}
