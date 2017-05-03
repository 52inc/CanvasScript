package com.ftinc.canvasscript;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.annotation.NonNull;

import com.ftinc.canvasscript.params.CanvasParams;

import java.util.ArrayDeque;
import java.util.Deque;


public final class CanvasScript implements CanvasProxy{

    private Bitmap bitmap;
    private Canvas rootCanvas;
    private final Deque<CanvasParams> parameters;


    private CanvasScript(Bitmap bitmap) {
        this.bitmap = bitmap;
        parameters = new ArrayDeque<>(10);
        rootCanvas = new Canvas(this.bitmap);
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


    @Override
    public Bitmap draw() {
        for (CanvasParams parameter : parameters) {
            parameter.draw(rootCanvas);
        }
        return bitmap;
    }

}
