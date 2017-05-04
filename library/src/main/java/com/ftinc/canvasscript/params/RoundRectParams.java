package com.ftinc.canvasscript.params;


import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;


public class RoundRectParams implements CanvasParams {

    private final RectF bounds;
    private final float rx;
    private final float ry;
    private final Paint paint;


    public RoundRectParams(float left, float top, float right, float bottom, float rx, float ry, @NonNull Paint paint) {
        bounds = new RectF(left, top, right, bottom);
        this.rx = rx;
        this.ry = ry;
        this.paint = paint;
    }


    public RoundRectParams(@NonNull RectF bounds, float rx, float ry, @NonNull Paint paint) {
        this.bounds = bounds;
        this.rx = rx;
        this.ry = ry;
        this.paint = paint;
    }


    public RoundRectParams(float left, float top, float right, float bottom, float radius, @NonNull Paint paint) {
        bounds = new RectF(left, top, right, bottom);
        this.rx = radius;
        this.ry = radius;
        this.paint = paint;
    }


    public RoundRectParams(@NonNull RectF bounds, float radius, @NonNull Paint paint) {
        this.bounds = bounds;
        this.rx = radius;
        this.ry = radius;
        this.paint = paint;
    }


    @Override
    public void draw(Canvas canvas) {
        canvas.drawRoundRect(bounds, rx, ry, paint);
    }
}
