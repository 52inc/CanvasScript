package com.ftinc.canvasscript.params;


import android.graphics.Canvas;


public interface CanvasParams {

    /**
     * The default value for the draw method when the operation doesn't involve a save
     */
    int NO_SAVE = -1;

    /**
     * Render the draw parameter to the canvas
     * @param canvas the canvas to render to
     * @return the save count, if available, or -1
     */
    int draw(Canvas canvas);
}
