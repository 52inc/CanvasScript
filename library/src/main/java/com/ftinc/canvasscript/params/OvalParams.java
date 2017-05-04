package com.ftinc.canvasscript.params;


import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;


public class OvalParams implements CanvasParams {

    private final RectF bounds;
    private final Paint paint;


    public OvalParams(float left, float right, float top, float bottom, @NonNull Paint paint) {
        bounds = new RectF(left, top, right, bottom);
        this.paint = paint;
    }


    public OvalParams(RectF bounds, @NonNull Paint paint) {
        this.bounds = bounds;
        this.paint = paint;
    }


    @Override
    public void draw(Canvas canvas) {
        canvas.drawOval(bounds, paint);
    }
}