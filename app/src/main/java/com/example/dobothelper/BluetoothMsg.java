package com.example.dobothelper;

/**
 * Created by Johan on 2016/2/27 0027.
 */
public class BluetoothMsg {
    /**
     * 蓝牙连接类型
     * @author Andy
     *
     */
    public enum ServerOrClient {
        NONE,
        SERVICE,
        CLIENT
    }
    //蓝牙连接方式
    public static ServerOrClient serviceOrClient = ServerOrClient.NONE;
    //连接蓝牙地址
    public static String BlueToothAddress = null,lastblueToothAddress=null;
    //通信线程是否开启
    public static boolean isOpen = false;

}
