package com.ftinc.canvasscript.params;


import android.graphics.Canvas;
import android.graphics.Paint;


public class PaintParams implements CanvasParams {

    private final Paint paint;


    public PaintParams(Paint paint) {
        this.paint = paint;
    }


    @Override
    public void draw(Canvas canvas) {
        canvas.drawPaint(paint);
    }
}
