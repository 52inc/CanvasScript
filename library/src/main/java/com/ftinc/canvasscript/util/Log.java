package com.ftinc.canvasscript.util;

import java.util.Locale;

public final class Log {

    private static boolean enabled = true;

    private Log() {
        // Unused
    }


    public static void setEnabled(boolean flag) {
        enabled = flag;
    }


    public static void v(String tag, String message, Object... args) {
        if (enabled) android.util.Log.v(tag, String.format(Locale.ROOT, message, args));
    }


    public static void d(String tag, String message, Object... args) {
        if (enabled) android.util.Log.d(tag, String.format(Locale.ROOT, message, args));
    }


    public static void i(String tag, String message, Object... args) {
        if (enabled) android.util.Log.i(tag, String.format(Locale.ROOT, message, args));
    }


    public static void w(String tag, String message, Object... args) {
        if (enabled) android.util.Log.w(tag, String.format(Locale.ROOT, message, args));
    }


    public static void e(String tag, String message, Object... args) {
        if (enabled) android.util.Log.e(tag, String.format(Locale.ROOT, message, args));
    }


    public static void v(Throwable throwable, String tag, String message, Object... args) {
        if (enabled) android.util.Log.v(tag, String.format(Locale.ROOT, message, args, throwable));
    }


    public static void d(Throwable throwable, String tag, String message, Object... args) {
        if (enabled) android.util.Log.d(tag, String.format(Locale.ROOT, message, args, throwable));
    }


    public static void i(Throwable throwable, String tag, String message, Object... args) {
        if (enabled) android.util.Log.i(tag, String.format(Locale.ROOT, message, args, throwable));
    }


    public static void w(Throwable throwable, String tag, String message, Object... args) {
        if (enabled) android.util.Log.w(tag, String.format(Locale.ROOT, message, args, throwable));
    }


    public static void e(Throwable throwable, String tag, String message, Object... args) {
        if (enabled) android.util.Log.e(tag, String.format(Locale.ROOT, message, args, throwable));
    }

}
