package com.ailianlian.base;
/*
    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ 
       Author   :  lixiaodaoaaa
       Date     :  2017/11/21
       Time     :  15:49
    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
 */

import android.app.Application;

import com.want.location.LocationManager;
import com.want.location.gd.GDLocationClient;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化位置模块
        LocationManager.init(new GDLocationClient(this));
        LocationManager.getInstance().requestLocationUpdate();
    }
}
