package com.ftinc.canvasscript.params;


import android.graphics.Canvas;
import android.graphics.Paint;


public class CircleParams implements CanvasParams {

    private final float centerX;
    private final float centerY;
    private final float radius;
    private final Paint paint;


    public CircleParams(float centerX, float centerY, float radius, Paint paint) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.paint = paint;
    }


    @Override
    public void draw(Canvas canvas) {
        canvas.drawCircle(centerX, centerY, radius, paint);
    }
}
