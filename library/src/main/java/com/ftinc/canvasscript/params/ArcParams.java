package com.ftinc.canvasscript.params;


import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;


public class ArcParams implements CanvasParams {

    private final RectF bounds;
    private final float startAngle;
    private final float sweepAngle;
    private final boolean useCenter;
    private final Paint paint;


    /**
     * @see Canvas#drawArc(RectF, float, float, boolean, Paint)
     */
    public ArcParams(@NonNull RectF bounds, float startAngle, float sweepAngle, boolean useCenter, @NonNull Paint paint) {
        this.bounds = bounds;
        this.startAngle = startAngle;
        this.sweepAngle = sweepAngle;
        this.useCenter = useCenter;
        this.paint = paint;
    }


    /**
     * @see Canvas#drawArc(RectF, float, float, boolean, Paint)
     */
    public ArcParams(float left, float top, float right, float bottom, float startAngle, float sweepAngle,
                     boolean useCenter, @NonNull Paint paint) {
        this(new RectF(left, top, right, bottom), startAngle, sweepAngle, useCenter, paint);
    }


    @Override
    public void draw(Canvas canvas) {
        canvas.drawArc(bounds, startAngle, sweepAngle, useCenter, paint);
    }
}
