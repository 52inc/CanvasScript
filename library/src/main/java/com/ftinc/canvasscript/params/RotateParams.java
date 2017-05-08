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


public class RotateParams implements CanvasParams {

    private final float degrees;
    private final float px;
    private final float py;


    /**
     * @see Canvas#rotate(float)
     */
    public RotateParams(float degrees) {
        this.degrees = degrees;
        this.px = 0f;
        this.py = 0f;
    }


    /**
     * @see Canvas#rotate(float, float, float)
     */
    public RotateParams(float degrees, float px, float py) {
        this.degrees = degrees;
        this.px = px;
        this.py = py;
    }


    @Override
    public int draw(Canvas canvas) {
        if (px == 0 && py == 0) {
            canvas.rotate(degrees);
        } else {
            canvas.rotate(degrees, px, py);
        }
        return NO_SAVE;
    }
}
