package com.ftinc.canvasscript.params;


import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Size;


public class LineParams implements CanvasParams {

    private final float[] pts;
    private final int offset;
    private final int count;
    private final Paint paint;


    public LineParams(float startX, float startY, float endX, float endY, Paint paint) {
        this.paint = paint;
        pts = new float[] { startX, startY, endX, endY };
        offset = 0;
        count = 4;
    }


    public LineParams(@Size(multiple = 4) @NonNull float[] pts, Paint paint) {
        this(pts, 0, pts.length, paint);
    }


    public LineParams(@Size(multiple = 4) @NonNull float[] pts, int offset, int count, Paint paint) {
        this.pts = pts;
        this.offset = offset;
        this.count = count;
        this.paint = paint;
    }


    @Override
    public void draw(Canvas canvas) {
        if (pts.length == 4) {
            canvas.drawLine(pts[0], pts[1], pts[2], pts[3], paint);
        } else {
            canvas.drawLines(pts, offset, count, paint);
        }
    }
}
