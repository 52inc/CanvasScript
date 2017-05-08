package com.ftinc.canvasscript;


import android.annotation.TargetApi;
import android.graphics.ColorFilter;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.Xfermode;
import android.os.Build;
import android.os.LocaleList;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Size;

import java.util.Locale;


public final class PaintScript {

    private final Paint paint;


    private PaintScript(int flags) {
        paint = new Paint(flags);
    }


    private PaintScript(Paint paint) {
        this.paint = new Paint(paint);
    }


    public static PaintScript create() {
        return new PaintScript(Paint.ANTI_ALIAS_FLAG);
    }


    public static PaintScript create(int flags) {
        return new PaintScript(flags);
    }


    public static PaintScript create(Paint paint) {
        return new PaintScript(paint);
    }


    public PaintScript color(@ColorInt int color) {
        paint.setColor(color);
        return this;
    }


    public PaintScript colorFilter(@Nullable ColorFilter filter) {
        paint.setColorFilter(filter);
        return this;
    }


    public PaintScript argb(int a, int r, int g, int b) {
        paint.setARGB(a, r, g, b);
        return this;
    }


    public PaintScript alpha(@IntRange(from = 0, to = 255) int alpha) {
        paint.setAlpha(alpha);
        return this;
    }


    public PaintScript alpha(@FloatRange(from = 0f, to = 1f) float alpha) {
        paint.setAlpha((int) (255f * alpha));
        return this;
    }


    public PaintScript flags(int flags) {
        paint.setFlags(flags);
        return this;
    }


    public PaintScript addFlags(int flags) {
        paint.setFlags(paint.getFlags() | flags);
        return this;
    }


    public PaintScript style(Paint.Style style) {
        paint.setStyle(style);
        return this;
    }


    public PaintScript strokeWidth(float width) {
        paint.setStrokeWidth(width);
        return this;
    }


    public PaintScript strokeMiter(float miter) {
        paint.setStrokeMiter(miter);
        return this;
    }


    public PaintScript strokeCap(Paint.Cap cap) {
        paint.setStrokeCap(cap);
        return this;
    }


    public PaintScript strokeJoin(Paint.Join join) {
        paint.setStrokeJoin(join);
        return this;
    }


    public PaintScript shader(Shader shader) {
        paint.setShader(shader);
        return this;
    }


    public PaintScript xfermode(Xfermode xfermode) {
        paint.setXfermode(xfermode);
        return this;
    }


    public PaintScript porterDuffXfer(PorterDuff.Mode mode) {
        paint.setXfermode(new PorterDuffXfermode(mode));
        return this;
    }


    public PaintScript pathEffect(PathEffect pathEffect) {
        paint.setPathEffect(pathEffect);
        return this;
    }


    public PaintScript maskFilter(MaskFilter maskFilter) {
        paint.setMaskFilter(maskFilter);
        return this;
    }


    public PaintScript typeface(Typeface typeface) {
        paint.setTypeface(typeface);
        return this;
    }


    public PaintScript shadow(float radius, float dx, float dy, @ColorInt int shadowColor) {
        paint.setShadowLayer(radius, dx, dy, shadowColor);
        return this;
    }


    public PaintScript clearShadow() {
        if (paint != null) {
            paint.clearShadowLayer();
        }
        return this;
    }


    public PaintScript textAlign(Paint.Align align) {
        paint.setTextAlign(align);
        return this;
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public PaintScript textLocale(@NonNull Locale locale) {
        paint.setTextLocale(locale);
        return this;
    }


    @TargetApi(Build.VERSION_CODES.N)
    public PaintScript textLocales(@NonNull @Size(min = 1) LocaleList locales) {
        paint.setTextLocales(locales);
        return this;
    }


    public PaintScript textSize(float textSize) {
        paint.setTextSize(textSize);
        return this;
    }


    public PaintScript textScaleX(float scaleX) {
        paint.setTextScaleX(scaleX);
        return this;
    }


    public PaintScript textSkewX(float skewX) {
        paint.setTextSkewX(skewX);
        return this;
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PaintScript letterSpacing(float letterSpacing) {
        paint.setLetterSpacing(letterSpacing);
        return this;
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PaintScript fontFeatureSettings(String settings) {
        paint.setFontFeatureSettings(settings);
        return this;
    }


    public Paint build() {
        return paint;
    }
}
