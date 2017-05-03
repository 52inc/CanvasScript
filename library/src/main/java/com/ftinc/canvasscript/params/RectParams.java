package com.ftinc.canvasscript.params;


import android.graphics.Canvas;
import android.graphics.Paint;


public class RectParams implements CanvasParams {

    private final float left;
    private final float right;
    private final float top;
    private final float bottom;
    private final Paint paint;


    public RectParams(float left, float right, float top, float bottom, Paint paint) {
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
        this.paint = paint;
    }


    @Override
    public void draw(Canvas canvas) {
        canvas.drawRect(left, top, right, bottom, paint);
    }
}
