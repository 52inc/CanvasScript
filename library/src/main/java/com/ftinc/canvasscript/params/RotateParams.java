package com.ftinc.canvasscript.params;


import android.graphics.Canvas;


public class RotateParams implements CanvasParams {

    private final float degrees;
    private final float px;
    private final float py;


    /**
     * @see Canvas#rotate(float)
     */
    public RotateParams(float degrees) {
        this.degrees = degrees;
        this.px = 0f;
        this.py = 0f;
    }


    /**
     * @see Canvas#rotate(float, float, float)
     */
    public RotateParams(float degrees, float px, float py) {
        this.degrees = degrees;
        this.px = px;
        this.py = py;
    }


    @Override
    public int draw(Canvas canvas) {
        if (px == 0 && py == 0) {
            canvas.rotate(degrees);
        } else {
            canvas.rotate(degrees, px, py);
        }
        return NO_SAVE;
    }
}
