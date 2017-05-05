package com.ftinc.canvasscript.params;


import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;


public class PaintParams implements CanvasParams {

    private final Paint paint;


    public PaintParams(@NonNull Paint paint) {
        this.paint = paint;
    }


    @Override
    public int draw(Canvas canvas) {
        canvas.drawPaint(paint);
        return NO_SAVE;
    }
}
