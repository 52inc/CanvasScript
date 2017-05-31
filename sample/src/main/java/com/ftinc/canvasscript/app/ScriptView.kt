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
                .paint(null)
                .restore()
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