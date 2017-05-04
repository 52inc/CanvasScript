package com.ftinc.canvasscript.params;


import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


public class RectParams implements CanvasParams {

    private final float left;
    private final float right;
    private final float top;
    private final float bottom;
    @Nullable private final Rect rect;
    @Nullable private final RectF rectF;
    private final Paint paint;


    public RectParams(float left, float top, float right, float bottom, @NonNull Paint paint) {
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
        this.paint = paint;
        rect = null;
        rectF = null;
    }


    public RectParams(@NonNull Rect rect, @NonNull Paint paint) {
        this.rect = rect;
        this.paint = paint;
        rectF = null;
        left = top = right = bottom = 0;
    }


    public RectParams(@NonNull RectF rect, @NonNull Paint paint) {
        this.rectF = rect;
        this.paint = paint;
        this.rect = null;
        left = top = right = bottom = 0;
    }


    @Override
    public void draw(Canvas canvas) {
        if (rect != null) {
            canvas.drawRect(rect, paint);
        } else if (rectF != null) {
            canvas.drawRect(rectF, paint);
        } else {
            canvas.drawRect(left, top, right, bottom, paint);
        }
    }
}
