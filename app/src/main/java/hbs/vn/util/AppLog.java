package hbs.vn.util;

import android.util.Log;

import hbs.vn.BuildConfig;


/**
 * Created by thanhbui on 2018/10/09.
 */

public class AppLog {

    public static void i(String tag, String msg) {
        Log.i(safeToString(tag), safeToString(msg));
    }

    public static void d(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(safeToString(tag), safeToString(msg));
        }
    }

    public static void e(String tag, String msg) {
        Log.e(safeToString(tag), safeToString(msg));
    }

    private static String safeToString(Object o) {
        if (o == null) {
            return "";
        } else {
            return o.toString();
        }
    }
}