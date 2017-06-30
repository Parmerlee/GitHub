package com.demo.github.Retrofit;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Administrator on 2017/6/29.
 */

public abstract class BaseCallBack<T> implements Callback<T> {
    @Override
    public void onResponse(Call call, Response response) {

        //1,格式化数据，对内容进行预处理等。eg：判断返回值是否正常
        //2,停止进度条
        //3,对结果进行分发等。

        System.out.println("response:" + response.body().toString());

//        onSuccess((T) new Gson().fromJson(DES.decrypt2(response.body().toString()), UpdateBean.class));
    }

    @Override
    public void onFailure(Call call, Throwable t) {

        //失败操作，如：提供用户错误，发送错误反馈给后台
        t.printStackTrace();
        onFailed(t);
    }

    //必选
    public abstract void onSuccess(T response);

    //可选方法
    public void onFailed(Object t) {

    }
}
