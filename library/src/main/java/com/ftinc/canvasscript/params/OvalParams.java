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


public class OvalParams implements CanvasParams {

    private final RectF bounds;
    private final Paint paint;


    public OvalParams(float left, float right, float top, float bottom, @NonNull Paint paint) {
        bounds = new RectF(left, top, right, bottom);
        this.paint = paint;
    }


    public OvalParams(RectF bounds, @NonNull Paint paint) {
        this.bounds = bounds;
        this.paint = paint;
    }


    @Override
    public int draw(Canvas canvas) {
        canvas.drawOval(bounds, paint);
        return NO_SAVE;
    }
}
