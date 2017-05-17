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
    public ArcParams(@NonNull RectF bounds, float startAngle, float sweepAngle, boolean useCenter,
                     @NonNull Paint paint) {
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
    public int draw(Canvas canvas) {
        canvas.drawArc(bounds, startAngle, sweepAngle, useCenter, paint);
        return NO_SAVE;
    }
}
