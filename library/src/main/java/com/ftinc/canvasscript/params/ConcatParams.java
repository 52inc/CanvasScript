package com.ftinc.canvasscript.params;


import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.annotation.Nullable;


public class ConcatParams implements CanvasParams {

    @Nullable private final Matrix matrix;


    public ConcatParams(@Nullable Matrix matrix) {
        this.matrix = matrix;
    }


    @Override
    public void draw(Canvas canvas) {
        canvas.concat(matrix);
    }
}
