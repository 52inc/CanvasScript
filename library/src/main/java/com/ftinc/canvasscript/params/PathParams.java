package com.ftinc.canvasscript.params;


import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;


public class PathParams implements CanvasParams {

    private final Path path;
    private final Paint paint;


    public PathParams(Path path, Paint paint) {
        this.path = path;
        this.paint = paint;
    }


    @Override
    public void draw(Canvas canvas) {
        canvas.drawPath(path, paint);
    }
}
