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


public class LineParams implements CanvasParams {

    private final float[] pts;
    private final int offset;
    private final int count;
    private final Paint paint;


    public LineParams(float startX, float startY, float endX, float endY, @NonNull Paint paint) {
        this.paint = paint;
        pts = new float[] { startX, startY, endX, endY };
        offset = 0;
        count = 4;
    }


    public LineParams(@Size(multiple = 4) @NonNull float[] pts, @NonNull Paint paint) {
        this(pts, 0, pts.length, paint);
    }


    public LineParams(@Size(multiple = 4) @NonNull float[] pts, int offset, int count, @NonNull Paint paint) {
        this.pts = pts;
        this.offset = offset;
        this.count = count;
        this.paint = paint;
    }


    @Override
    public int draw(Canvas canvas) {
        if (pts.length == 4) {
            canvas.drawLine(pts[0], pts[1], pts[2], pts[3], paint);
        } else {
            canvas.drawLines(pts, offset, count, paint);
        }
        return NO_SAVE;
    }
}
