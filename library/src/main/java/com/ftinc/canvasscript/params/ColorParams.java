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

package com.ftinc.canvasscript.params;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;


public class ColorParams implements CanvasParams {

    public static final int DEFAULT_ALPHA = 255;

    @ColorInt private final int color;
    @Nullable private final PorterDuff.Mode mode;


    public ColorParams(@ColorInt int color) {
        this(color, null);
    }


    public ColorParams(@ColorInt int color, PorterDuff.Mode mode) {
        this.color = color;
        this.mode = mode;
    }


    public ColorParams(int r, int g, int b) {
        this(DEFAULT_ALPHA, r, g, b, null);
    }


    public ColorParams(int a, int r, int g, int b) {
        this(a, r, g, b, null);
    }


    public ColorParams(int a, int r, int g, int b, PorterDuff.Mode mode) {
        this.color = Color.argb(a, r, g, b);
        this.mode = mode;
    }


    @Override
    public int draw(Canvas canvas) {
        if (mode == null) {
            canvas.drawColor(color);
        } else {
            canvas.drawColor(color, mode);
        }
        return NO_SAVE;
    }
}
