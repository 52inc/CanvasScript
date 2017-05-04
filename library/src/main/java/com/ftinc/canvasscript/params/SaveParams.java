package com.ftinc.canvasscript.params;


import android.graphics.Canvas;


public class SaveParams implements CanvasParams {

    private final int flags;


    public SaveParams() {
        flags = -1;
    }


    public SaveParams(int flags) {
        this.flags = flags;
    }


    @Override
    public void draw(Canvas canvas) {
        if (flags != -1) {
            canvas.save();
        } else {
            canvas.save(flags);
        }
    }
}