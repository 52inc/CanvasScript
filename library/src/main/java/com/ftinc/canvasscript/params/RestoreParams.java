package com.ftinc.canvasscript.params;


import android.graphics.Canvas;


public class RestoreParams implements CanvasParams {

    private final int count;


    public RestoreParams() {
        count = -1;
    }


    public RestoreParams(int count) {
        this.count = count;
    }


    @Override
    public void draw(Canvas canvas) {
        if (count == -1) {
            canvas.restore();
        } else {
            canvas.restoreToCount(count);
        }
    }
}
