package com.ftinc.canvasscript.app

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import com.ftinc.canvasscript.CanvasScript


class ScriptView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {


    val image : Bitmap by lazy {
        BitmapFactory.decodeResource(context.resources, R.drawable.dr_kotlin)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(image.width, image.height);
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        CanvasScript.create()
                .bitmap(image, 0f, 0f)
                .color(color(R.color.colorAccent))
                .circle(measuredWidth/2f, measuredHeight/2f, measuredWidth/4f)
                .draw(canvas)
    }

}