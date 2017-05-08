/*
 * Copyright (c) 2017 52inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ftinc.canvasscript.params;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


public class BitmapParams implements CanvasParams {

    private final Bitmap bitmap;
    private final float left;
    private final float top;
    @Nullable private final Rect src;
    @Nullable private final Rect dest;
    @Nullable private final RectF destF;
    @Nullable private final Matrix matrix;
    @Nullable private final Paint paint;


    public BitmapParams(@NonNull Bitmap bitmap, float left, float top, @Nullable Paint paint) {
        this.bitmap = bitmap;
        this.left = left;
        this.top = top;
        this.paint = paint;
        src = null;
        dest = null;
        destF = null;
        matrix = null;
    }


    public BitmapParams(@NonNull Bitmap bitmap, @Nullable Rect src, @NonNull Rect dest, @Nullable Paint paint) {
        this.bitmap = bitmap;
        this.src = src;
        this.dest = dest;
        this.paint = paint;
        left = -1f;
        top = -1f;
        destF = null;
        matrix = null;
    }


    public BitmapParams(@NonNull Bitmap bitmap, @Nullable Rect src, @NonNull RectF dest, @Nullable Paint paint) {
        this.bitmap = bitmap;
        this.src = src;
        this.destF = dest;
        this.paint = paint;
        this.dest = null;
        matrix = null;
        left = -1f;
        top = -1f;
    }


    public BitmapParams(@NonNull Bitmap bitmap, @NonNull Matrix matrix, @Nullable Paint paint) {
        this.bitmap = bitmap;
        this.matrix = matrix;
        this.paint = paint;
        left = -1f;
        top = -1f;
        src = null;
        dest = null;
        destF = null;
    }


    @Override
    public int draw(Canvas canvas) {
        if (matrix != null) {
            canvas.drawBitmap(bitmap, matrix, paint);
        } else if (destF != null) {
            canvas.drawBitmap(bitmap, src, destF, paint);
        } else if (dest != null) {
            canvas.drawBitmap(bitmap, src, dest, paint);
        } else {
            canvas.drawBitmap(bitmap, left, top, paint);
        }
        return NO_SAVE;
    }
}
