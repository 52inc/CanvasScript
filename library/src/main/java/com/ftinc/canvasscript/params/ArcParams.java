package com.ftinc.canvasscript.params;


import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;


public class ArcParams implements CanvasParams {

    private final RectF bounds;
    private final float startAngle;
    private final float sweepAngle;
    private final boolean useCenter;
    private final Paint paint;

    /**
     * @see Canvas#drawArc(RectF, float, float, boolean, Paint)
     */
    public ArcParams(RectF bounds, float startAngle, float sweepAngle, boolean useCenter, Paint paint) {
        this.bounds = bounds;
        this.startAngle = startAngle;
        this.sweepAngle = sweepAngle;
        this.useCenter = useCenter;
        this.paint = paint;
    }


    @Override
    public void draw(Canvas canvas) {
        canvas.drawArc(bounds, startAngle, sweepAngle, useCenter, paint);
    }
}
