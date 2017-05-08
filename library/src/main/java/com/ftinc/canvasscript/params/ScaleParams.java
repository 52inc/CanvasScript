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


public class ScaleParams implements CanvasParams {

    private final float sx;
    private final float sy;
    private final float px;
    private final float py;


    /**
     * @see Canvas#scale(float, float)
     */
    public ScaleParams(float sx, float sy) {
        this.sx = sx;
        this.sy = sy;
        this.px = 0f;
        this.py = 0f;
    }


    /**
     * @see Canvas#scale(float, float, float, float)
     */
    public ScaleParams(float sx, float sy, float px, float py) {
        this.sx = sx;
        this.sy = sy;
        this.px = px;
        this.py = py;
    }


    @Override
    public int draw(Canvas canvas) {
        if (px == 0 && py == 0) {
            canvas.scale(sx, sy);
        } else {
            canvas.scale(sx, sy, px, py);
        }
        return NO_SAVE;
    }
}
