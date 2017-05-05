package com.ftinc.canvasscript.params;


import android.graphics.Canvas;


public class TranslateParams implements CanvasParams {

    private final float dx;
    private final float dy;

    /**
     * @see Canvas#translate(float, float)
     */
    public TranslateParams(float dx, float dy) {
        this.dx = dx;
        this.dy = dy;
    }


    @Override
    public int draw(Canvas canvas) {
        canvas.translate(dx, dy);
        return NO_SAVE;
    }
}
