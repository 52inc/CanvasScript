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
    public int draw(Canvas canvas) {
        if (flags != -1) {
            return canvas.save();
        } else {
            return canvas.save(flags);
        }
    }
}
