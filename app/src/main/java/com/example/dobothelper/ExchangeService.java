package com.example.dobothelper;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by XuToTo on 2016/3/23 0023.
 * MVC控制层？
 */
public class ExchangeService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //TODO 后台服务，处理数据与蓝牙进行通讯
}
