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
import android.support.annotation.NonNull;
import android.support.annotation.Size;


public class PointParams implements CanvasParams {

    private final float[] pts;
    private final int offset;
    private final int count;
    private final Paint paint;


    public PointParams(float x, float y, @NonNull Paint paint) {
        this(new float[]{x, y}, paint);
    }


    public PointParams(@Size(multiple = 2) @NonNull float[] pts, @NonNull Paint paint) {
        this(pts, 0, pts.length, paint);
    }


    public PointParams(@Size(multiple = 2) @NonNull float[] pts, int offset, int count, @NonNull Paint paint) {
        this.pts = pts;
        this.offset = offset;
        this.count = count;
        this.paint = paint;
    }


    @Override
    public int draw(Canvas canvas) {
        if (count == 2) {
            canvas.drawPoint(pts[0], pts[1], paint);
        } else {
            canvas.drawPoints(pts, offset, count, paint);
        }
        return NO_SAVE;
    }
}
