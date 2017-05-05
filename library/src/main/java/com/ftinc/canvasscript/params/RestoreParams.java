package com.ftinc.canvasscript.params;


import android.graphics.Canvas;


public class RestoreParams implements CanvasParams {

    private int count;


    public RestoreParams() {
        count = NO_SAVE;
    }


    public RestoreParams(int count) {
        this.count = count;
    }


    public int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count = count;
    }


    @Override
    public int draw(Canvas canvas) {
        if (count == -1) {
            canvas.restore();
        } else {
            canvas.restoreToCount(count);
        }
        return 0;
    }
}
