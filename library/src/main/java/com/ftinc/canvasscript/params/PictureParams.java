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


    public PictureParams(@NonNull Picture picture, Rect dest) {
        this.picture = picture;
        this.dest = dest;
        destF = null;
    }


    public PictureParams(@NonNull Picture picture, RectF destF) {
        this.picture = picture;
        this.destF = destF;
        dest = null;
    }


    @Override
    public void draw(Canvas canvas) {
        if (destF != null) {
            canvas.drawPicture(picture, destF);
        } else if (dest != null) {
            canvas.drawPicture(picture, dest);
        } else {
            canvas.drawPicture(picture);
        }
    }
}
