package com.sensorsdata.uniapp.util;

import static android.Manifest.permission.ACCESS_WIFI_STATE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;

import androidx.annotation.RequiresPermission;

/**
 * @author Dennis<S010323>
 * @description
 * @date 2023/12/13 14:46
 */
public class NetWorkUtils {

    @RequiresPermission(ACCESS_WIFI_STATE)
    public static String getIpAddressByWifi(Context context) {
        @SuppressLint("WifiManagerLeak")
        WifiManager wm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        if (wm == null) return "";
        return Formatter.formatIpAddress(wm.getDhcpInfo().ipAddress);
    }
}
