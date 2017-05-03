package com.ftinc.canvasscript.params;


import android.graphics.Canvas;


public class SkewParams implements CanvasParams {

    private final float sx;
    private final float sy;


    /**
     * @see Canvas#skew(float, float)
     */
    public SkewParams(float sx, float sy) {
        this.sx = sx;
        this.sy = sy;
    }


    @Override
    public void draw(Canvas canvas) {
        canvas.skew(sx, sy);
    }
}
