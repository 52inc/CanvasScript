package com.ftinc.canvasscript.params;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;


public class ColorParams implements CanvasParams {

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
        this(255, r, g, b, null);
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
