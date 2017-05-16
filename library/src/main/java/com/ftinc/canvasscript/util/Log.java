/*
 * Copyright (c) 2017 52inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
