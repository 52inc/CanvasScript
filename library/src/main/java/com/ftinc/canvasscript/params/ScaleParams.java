package com.ftinc.canvasscript.params;


import android.graphics.Canvas;


public class ScaleParams implements CanvasParams {

    private final float sx;
    private final float sy;
    private final float px;
    private final float py;


    /**
     * @see Canvas#scale(float, float)
     */
    public ScaleParams(float sx, float sy) {
        this.sx = sx;
        this.sy = sy;
        this.px = 0f;
        this.py = 0f;
    }


    /**
     * @see Canvas#scale(float, float, float, float)
     */
    public ScaleParams(float sx, float sy, float px, float py) {
        this.sx = sx;
        this.sy = sy;
        this.px = px;
        this.py = py;
    }


    @Override
    public int draw(Canvas canvas) {
        if (px == 0 && py == 0) {
            canvas.scale(sx, sy);
        } else {
            canvas.scale(sx, sy, px, py);
        }
        return NO_SAVE;
    }
}
