package com.demo.github.Retrofit;

/**
 * Created by Administrator on 2017/6/30.
 */

public class UpdateBean {

    /**
     * flag : 1
     * msg : 新版本已经升级，请您更新
     * url : http://120.202.17.126:8070/app/pkg/PalmData.apk
     * version : 11
     */

    private int flag;
    private String msg;
    private String url;
    private String version;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
