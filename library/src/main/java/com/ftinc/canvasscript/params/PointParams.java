package com.ftinc.canvasscript.params;


import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Size;


public class PointParams implements CanvasParams {

    private final float[] pts;
    private final int offset;
    private final int count;
    private final Paint paint;


    public PointParams(@NonNull @Size(min = 2, multiple = 2) float[] pts, int offset, int count, @NonNull Paint paint) {
        this.pts = pts;
        this.offset = offset;
        this.count = count;
        this.paint = paint;
    }


    public PointParams(float x, float y, @NonNull Paint paint) {
        this.pts = new float[] { x, y };
        this.paint = paint;
        offset = 0;
        count = 2;
    }


    public PointParams(@NonNull @Size(min = 2, multiple = 2) float[] pts, @NonNull Paint paint) {
        this.pts = pts;
        this.paint = paint;
        offset = 0;
        count = pts.length;
    }


    @Override
    public void draw(Canvas canvas) {
        if (count == 2) {
            canvas.drawPoint(pts[0], pts[1], paint);
        } else {
            canvas.drawPoints(pts, offset, count, paint);
        }
    }
}
