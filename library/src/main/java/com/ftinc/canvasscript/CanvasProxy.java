package com.ftinc.canvasscript;


import android.graphics.Bitmap;


public interface CanvasProxy {


    /**
     * Render the built script stack onto a bitmap and return it
     * @return the bitmap that is a result of the canvas scripts
     */
    Bitmap draw();
}
