package com.ftinc.canvasscript.params;


import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;


public class SaveLayerParams implements CanvasParams {

    private final RectF bounds;
    private final int saveFlags;
    private final int alpha;
    @Nullable private final Paint paint;


    public SaveLayerParams(@Nullable RectF bounds, @Nullable Paint paint, int saveFlags) {
        this.bounds = bounds;
        this.paint = paint;
        this.saveFlags = saveFlags;
        alpha = -1;
    }


    public SaveLayerParams(@Nullable RectF bounds, @Nullable Paint paint) {
        this(bounds, paint, Canvas.ALL_SAVE_FLAG);
    }


    public SaveLayerParams(float left, float top, float right, float bottom, @Nullable Paint paint, int saveFlags) {
        this(new RectF(left, top, right, bottom), paint, saveFlags);
    }


    public SaveLayerParams(float left, float top, float right, float bottom, @Nullable Paint paint) {
        this(left, top, right, bottom, paint, Canvas.ALL_SAVE_FLAG);
    }


    public SaveLayerParams(@Nullable RectF bounds, int alpha, int saveFlags) {
        this.bounds = bounds;
        this.alpha = alpha;
        this.saveFlags = saveFlags;
        this.paint = null;
    }


    public SaveLayerParams(float left, float top, float right, float bottom, int alpha, int saveFlags) {
        this(new RectF(left, top, right, bottom), alpha, saveFlags);
    }


    @Override
    public void draw(Canvas canvas) {
        if (alpha == -1) {
            canvas.saveLayer(bounds, paint, saveFlags);
        } else {
            canvas.saveLayerAlpha(bounds, alpha, saveFlags);
        }
    }
}
