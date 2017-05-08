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
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


public class PictureParams implements CanvasParams {

    private final Picture picture;
    @Nullable private final Rect dest;
    @Nullable private final RectF destF;


    public PictureParams(@NonNull Picture picture) {
        this.picture = picture;
        dest = null;
        destF = null;
    }


    public PictureParams(@NonNull Picture picture, @NonNull Rect dest) {
        this.picture = picture;
        this.dest = dest;
        destF = null;
    }


    public PictureParams(@NonNull Picture picture, @NonNull RectF destF) {
        this.picture = picture;
        this.destF = destF;
        dest = null;
    }


    @Override
    public int draw(Canvas canvas) {
        if (destF != null) {
            canvas.drawPicture(picture, destF);
        } else if (dest != null) {
            canvas.drawPicture(picture, dest);
        } else {
            canvas.drawPicture(picture);
        }
        return NO_SAVE;
    }
}
