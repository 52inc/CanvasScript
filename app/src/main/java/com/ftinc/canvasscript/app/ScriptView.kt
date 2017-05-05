package com.ftinc.canvasscript.app

import android.content.Context
import android.graphics.*
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
        setMeasuredDimension(image.width*2, image.height*2);
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        CanvasScript.wrap(canvas)
                .saveLayer()
                .bitmap(image, measuredWidth, measuredHeight)
                .porterDuffXfer(PorterDuff.Mode.CLEAR)
                .circle(measuredWidth/2f, measuredHeight/2f, measuredWidth/4f)
                .drawColor(Color.RED, PorterDuff.Mode.SRC_IN)
                .restore()
                .draw()
    }

    fun getClipBitmap() : Bitmap {
        return CanvasScript.create(measuredWidth, measuredHeight)
                .bitmap(image, measuredWidth, measuredHeight)
                .xfermode(PorterDuffXfermode(PorterDuff.Mode.CLEAR))
                .circle(measuredWidth/2f, measuredHeight/2f, measuredWidth/4f)
                .draw()!!
    }

    fun scriptTest1(canvas: Canvas?) {
        CanvasScript.wrap(canvas)
                .bitmap(getClipBitmap())
                .color(color(R.color.colorAccent))
                .alpha(0.5f)
                .rect(0f, 0f, measuredWidth/2f, measuredHeight/2f)
                .alpha(1f)
                .color(Color.BLUE)
                .roundedRect(measuredWidth/2f, measuredHeight/2f, measuredWidth.toFloat(), measuredHeight.toFloat(), 20f)
                .color(Color.YELLOW)
                .style(Paint.Style.STROKE)
                .strokeWidth(10f)
                .strokeCap(Paint.Cap.ROUND)
                .arc(20f, 20f, measuredWidth.toFloat() - 40f, measuredHeight.toFloat() - 40f, -135f, 90f, false)
                .draw()
    }

}