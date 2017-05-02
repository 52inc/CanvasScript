package com.ftinc.canvasscript;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.annotation.NonNull;


public final class CanvasScript {

    private Bitmap bitmap;
    private Canvas rootCanvas;


    private CanvasScript(Bitmap bitmap) {
        this.bitmap = bitmap;
        rootCanvas = new Canvas(this.bitmap);
        rootCanvas.draw
    }


    public static CanvasScript create(int width, int height) {
        return create(width, height, Bitmap.Config.ARGB_8888);
    }


    public static CanvasScript create(int width, int height, @NonNull Bitmap.Config config) {
        return new CanvasScript(Bitmap.createBitmap(width, height, config));
    }


    public static CanvasScript create(@NonNull Bitmap bitmap) {
        return new CanvasScript(bitmap);
    }



}
